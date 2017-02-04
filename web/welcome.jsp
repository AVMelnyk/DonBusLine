<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8" />
<title>Пассажирские перевозки | Don-BusLine</title>
<meta property="og:title" content="Пассажирские перевозки | Don-BusLine" />
<meta name="author" content="Don-BusLine" />
<meta name="keywords" content="автобусные, пассажирские, перевозки, Донбасс, Москва, Воронеж, Новошахтинск, Шахтёрск, Макеевка, Енакиево, Горловка, Донецк" />
<meta name="description" content="Пассажирское сообщение в направлении Донбасс-Москва" />
<meta property="og:site_name" content="Пассажирские перевозки | Don-BusLine" />
<meta property="og:title" content="Пассажирские перевозки | Don-BusLine" />
<meta property="og:type" content="website" />
<meta property="og:description" content="Пассажирское сообщение в направлении Донбасс-Москва" />
<meta property="og:url" content="/" />
<meta property="og:image" content="/images/website_share.png" />
<meta name="twitter:card" content="summary" />
<meta name="twitter:url" content="/" />
<meta name="twitter:title" content="Пассажирские перевозки | Don-BusLine" />
<meta name="twitter:description" content="Пассажирское сообщение в направлении Донбасс-Москва" />
<meta name="twitter:image" content="http://don-busline.com/images/website_share.png" />
<!--<meta name="twitter:site" content="@nilfalse" />-->
<link rel="stylesheet" href="main.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<header class="nav">
    <div class="nav__main">
        <a href="/" class="nav__logo"><h1 class="logo">Don-BusLine</h1></a>
    </div>
    <nav class="nav__items">
        <li class="nav__item"><a href="#schedule">Расписание</a></li>
        <li class="nav__item"><a href="#tickets">Билеты</a></li>
        <li class="nav__item"><a href="#callback">Перезвоним</a></li>
    </nav>
</header>
<div class="message message_${severity}">${message}</div>
<div class="slides">
    <section class="slides__slide slides__slide_n1 hero">
        <div class="hero__container">
            <h1 class="hero__item">Комфортные перевозки пассажиров из Донбасса в города России!</h1>
            <a href="#callback" class="button button_action hero__call-to-action hero__item">Заказать обратный звонок</a>
        </div>
    </section>
    <section class="slides__slide slides__slide_n2 schedule" id="schedule">
        <h2 class="schedule__table-headline">Расписание</h2>
        <table class="table schedule__table">
            <thead>
                <tr>
                    <th>Маршрут</th>
                    <th>Дни недели</th>
                    <th>Время отправления</th>
                </tr>
            </thead><tbody>
                <tr>
                    <td>Киев-Москва</td>
                    <td>Вт</td>
                    <td>14:30</td>
                </tr><tr>
                    <td>Киев-Житомир</td>
                    <td>Ср</td>
                    <td>15:30</td>
                </tr><tr>
                    <td>Киев-Жмеринка</td>
                    <td>Чт</td>
                    <td>16:30</td>
                </tr>
            </tbody>
        </table>
    </section>
    <section class="slides__slide slides__slide_n3 tickets" id="tickets">
        <div class="tickets__container">
            <h2 class="tickets__table-headline">Цены на билеты</h2>
            <table class="table tickets__table">
                <thead>
                    <tr>
                        <th>Отправление</th>
                        <th>Прибитие</th>
                        <th>Стоимость, руб.</th>
                        <th>Время в дороге</th>
                    </tr>
                </thead><tbody>
                    <tr>
                        <td>Донецк</td>
                        <td>Москва</td>
                        <td>1000 руб.</td>
                        <td>12 ч</td>
                    </tr><tr>
                        <td>Горловка</td>
                        <td>Москва</td>
                        <td>1060 руб.</td>
                        <td>12 ч</td>
                    </tr><tr>
                        <td>Енакиево</td>
                        <td>Москва</td>
                        <td>1200 руб.</td>
                        <td>12 ч</td>
                    </tr><tr>
                        <td>Макеевка</td>
                        <td>Москва</td>
                        <td>100 руб.</td>
                        <td>12 ч</td>
                    </tr><tr>
                        <td>Шахтёрск</td>
                        <td>Москва</td>
                        <td>100 руб.</td>
                        <td>12 ч</td>
                    </tr>
                </tbody><tbody>
                    <tr>
                        <td>Новошахтинск</td>
                        <td>Москва</td>
                        <td>100 руб.</td>
                        <td>12 ч</td>
                    </tr><tr>
                        <td>Воронеж</td>
                        <td>Москва</td>
                        <td>100 руб.</td>
                        <td>12 ч</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
    <section class="slides__slide slides__slide_n4 slides__callback" id="callback">
        <form id="f" method="POST" action="${path}" class="callback callback_pristine callback__form">
            <h2 class="callback__headline">Пожалуйста, введите ваши данные.</h2>
            <h2 class="callback__headline">Мы вам перезвоним.</h2>
            <div class="callback__form-row">
                <label for="callback__name" class="callback__form-label">Имя:</label>
                <input name="name" id="callback__name" class="callback__form-field callback__name input" placeholder="Имя"/>
            </div>
            <div class="callback__form-row">
                <label for="callback__tel" class="callback__form-label">Телефон:</label>
                <input type="tel" name="tel" id="callback__tel" class="callback__form-field callback__tel input" placeholder="Телефон" />
            </div>
            <div class="callback__notification">
                <p>Пожалуйста, введите телефон, по которому мы сможем с вами связаться.</p>
            </div><div>
                <input type="submit" class="button button_action" value="Отправить"/>
            </div>
        </form>
    </section>
</div>
<footer class="footer">
    <p class="copyright"><a href="http://nilfalse.com" target="_blank">nilfalse © 2017</a></p>
</footer>
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
(function (d, w, c) { (w[c] = w[c] || []).push(function() { try { w.yaCounter40378235 = new Ya.Metrika({ id:40378235, clickmap:true, trackLinks:true, accurateTrackBounce:true, webvisor:true, trackHash:true }); } catch(e) { } }); var n = d.getElementsByTagName("script")[0], s = d.createElement("script"), f = function () { n.parentNode.insertBefore(s, n); }; s.type = "text/javascript"; s.async = true; s.src = "https://mc.yandex.ru/metrika/watch.js"; if (w.opera == "[object Opera]") { d.addEventListener("DOMContentLoaded", f, false); } else { f(); } })(document, window, "yandex_metrika_callbacks");
</script>
<noscript><div><img src="https://mc.yandex.ru/watch/40378235" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
<!-- /Yandex.Metrika counter -->
<script src="scripts/libphonenumber-js.min.js"></script>
<script src="scripts/index.js"></script>
