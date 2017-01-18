<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<section id='hello_section'>
    <header>
        <nav>
            <div class="logo-box">
                <h1 class="logo">
                    <a href="/">
                        <img src="images/logo.png">
                    </a>
                </h1>
            </div>
            <ul>
                <li><a href="#schedule_section">расписание</a></li>
                <li><a href="#price_section">билеты</a></li>
                <li><a href="#form_section">перезвоним</a></li>
            </ul>
        </nav>
    </header>
</section>
<section id='schedule_section'>
    <table class="schedule">
        <caption>Расписание</caption>
        <tr class='ft'>
            <th>Маршрут</th>
            <th>Дни недели</th>
            <th>Время отправления</th>
        </tr>
        <tr class='sd'>
            <td>Киев-Москва</td>
            <td>Вт</td>
            <td>14:30</td>
        </tr>
        <tr class='ft'>
            <td>Киев-Житомир</td>
            <td>Ср</td>
            <td>15:30</td>
        </tr>
        <tr class='sd'>
            <td>Киев-Жмеринка</td>
            <td>Чт</td>
            <td>16:30</td>
        </tr>
    </table>
</section>
<section id='price_section'>
    <table class='price'>
        <caption>Цены на билеты</caption>
        <tr class='ft'>
            <th>Отправление с:</th>
            <th>Прибитие в:</th>
            <th>Стоимость, руб.</th>
            <th>Время поездки</th>
        </tr>
        <tr>
            <td>Киев</td>
            <td>Москва</td>
            <td>1000 руб.</td>
            <td>12 ч</td>
        </tr>
        <tr class='ft'>
            <td>Луганск</td>
            <td>Москва</td>
            <td>1060 руб.</td>
            <td>12 ч</td>
        </tr>
        <tr>
            <td>Донецк</td>
            <td>Москва</td>
            <td>1200 руб.</td>
            <td>12 ч</td>
        </tr>
        <tr class='ft'>
            <td>Макеевка</td>
            <td>Москва</td>
            <td>100 руб.</td>
            <td>12 ч</td>
        </tr>
    </table>
</section>
<section id='form_section'>
    <form method="POST" action="${path}/index"/>
    <table="dataform" classborder ="0"><tr><td valign="top">
    <caption class="datacaption">Пожалуйста, введите ваши данные. Мы вам перезвоним.</caption>
    <br>
    <td>Ваше имя:</td> <td valign="top">
        <input type="text" name="name" size="20">
    </td></tr><tr><td valign="top">
    Телефон: </td> <td valign="top">
    <input type="text" name="phone" size="20">
</td></tr><tr><td valign="top">
    <input type="submit" value="Отправить"></td></tr>
    </table></form>
</section>
</body>
</html>
