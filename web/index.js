function isValidTel(tel) {
    return libphonenumber.isValidNumber(tel, 'UA') || libphonenumber.isValidNumber(tel, 'RU');
}


var f = document.getElementById('f');
//пост-валідація
f.addEventListener('submit', function(e) { //додає eventListener для типу "submit", функція яка реагує на event 
    if (isValidTel(f.tel.value)) {
        f.classList.remove('callback_invalid-tel'); // якшо номер валідний, то до зі списку класів форми f видаляється class callback_invalid-tel
    } else {
        e.preventDefault(); 	// якщо номер невалідний відміняє event submit і додає до списку класів форми f class callback_invalid-tel
        f.classList.add('callback_invalid-tel');
    }
});

//валідація під час введення данних
f.name.addEventListener('input', function(e) { //додає eventListener для типу "input" name-input-а  , функція яка реагує на event
    f.classList.remove('callback_pristine');  //видаляє class callback_pristine зі списку класів форми f
    f.classList.remove('callback_invalid-tel'); //видаляє class callback_invalid-tel зі списку класів форми f
});

f.tel.addEventListener('input', function(e) {  //додає eventListener для типу "input" tel-input-а  , функція яка реагує на event
    f.classList.remove('callback_pristine');  //видаляє class callback_pristine зі списку класів форми f
    f.classList.remove('callback_invalid-tel'); //видаляє class callback_invalid-tel зі списку класів форми f
    if (isValidTel(f.tel.value)) { //якщо номер валідний видаляє клас callback_invalid зі списку класів форми f
        f.classList.remove('callback_invalid');
    } else {
        f.classList.add('callback_invalid'); // якщо номер невалідний додає class callback_invalid до списку класів форми f
    }
});

