// utils

function isValidTel(tel) {
    return libphonenumber.isValidNumber(tel, 'UA') || libphonenumber.isValidNumber(tel, 'RU');
}

function debounce(fn, delay) {
    var timeout;
    return function() {
        if (timeout) {
            clearTimeout(timeout);
        }
        timeout = setTimeout(fn, delay);
    };
}

function findIdx(list, predicateFn) {
    for(var i = 0, l = list.length; i < l; i++) {
        if (true === predicateFn(list[i])) {
            return i;
        }
    }
    return -1;
}

function dropRepeatingCalls(fn) {
    var lastArgs;
    return function() {
        var args = Array.prototype.join.call(arguments, '');
        if (args === lastArgs) {
            return;
        }
        lastArgs = args;
        fn.apply(this, arguments);
    }
}


var app = {
    _listeners: {},
    on: function(evt, fn) {
        if(!app._listeners[evt]) {
            app._listeners[evt] = [];
        }
        app._listeners[evt].push(fn);
    },
    _emit: function(evt, data) {
        if(!app._listeners[evt]) {
            return;
        }
        app._listeners[evt].forEach(function(fn) {
            fn(data);
        });
    },

    spyScroll: function(slides) {
        function spy() {
            var bounds = Array.prototype.map.call(slides, function(slide) {
                return slide.getBoundingClientRect();
            });
            var visibleSlideIdx = findIdx(bounds, function(bounds) {
                return bounds.bottom > bounds.height / 2;
            });
            if (visibleSlideIdx >= 0) {
                app._emit('slide', slides[visibleSlideIdx].id);
            }
        }

        addEventListener('scroll', debounce(spy, 50));
        spy();
    },

    initValidation: function(f) {
        f.addEventListener('submit', function(e) {
            if (isValidTel(f.tel.value)) {
                f.classList.remove('callback_invalid');
                app.reachGoal('SUBMIT', { 
                    name: f.name.value,
                    tel: f.tel.value
                });
            } else {
                e.preventDefault();
                f.classList.add('callback_invalid');
                app.reachGoal('INVALID', { 
                    name: f.name.value,
                    tel: f.tel.value
                });
            }
            f.tel.selectionStart = 0;
            f.tel.selectionEnd = f.tel.value.length;
            f.tel.focus();
        });

        f.name.addEventListener('input', function(e) {
            f.classList.remove('callback_pristine');
            f.classList.remove('callback_invalid');
        });

        f.tel.addEventListener('input', function(e) {
            f.classList.remove('callback_pristine');
            if (isValidTel(f.tel.value)) {
                f.classList.remove('callback_invalid');
            } else {
                f.classList.add('callback_invalid');
            }
        });
    },

    watchNavigation: function(navItems) {
        app.on('slide', function(slideId) {
            Array.prototype.forEach.call(navItems, function(item) {
                var anchor = item.querySelector('a');
                if('#' + slideId === anchor.hash) {
                    item.classList.add('nav__item_current');
                } else {
                    item.classList.remove('nav__item_current');
                }
            });
        });
    },

    watchLocation: function() {
        app.on('slide', function(slideId) {
            var path = '/';
            if(slideId) {
                path += '#' + slideId;
            }
            history.replaceState({}, '', path);
        });
    },

    reachGoal: function() {
        var counter = window.yaCounter40378235;
        if (!counter) {
            return;
        }
        return counter.reachGoal.apply(counter, arguments);
    }
};

app.on('slide', dropRepeatingCalls(function(slideId) {
    app.reachGoal('ENTER_SLIDE', { 
        slide: slideId || 'welcome'
    });
    if('callback' === slideId) {
        // TODO: BEM Modification input_autofocus
        document.getElementById('f').name.focus();
    }
}));
app.initValidation(document.getElementById('f'));
app.watchLocation();
app.watchNavigation(document.getElementsByClassName('nav__item'));
app.spyScroll(document.getElementsByClassName('slides__slide'));

Array.prototype.forEach.call(document.querySelectorAll('.hero__call-to-action'), function(button) {
    button.addEventListener('click', function(e) {
        app.reachGoal('CALL_TO_ACTION_CLICKED');
    });
});
