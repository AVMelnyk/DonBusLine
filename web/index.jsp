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
    <div id="app">
			<form id="f" method="POST" action="${path}/index" class="callback callback_pristine">
			<table class="datatable">
			<caption class="datacaption">Пожалуйста, введите ваши данные. Мы вам перезвоним.</caption>
			<tr>
				<td>Имя:</td>
				<td class="callback__name"><input name="name" placeholder="Имя"/></td>
			</tr>
			<tr>
				<td>Телефон:</td>
				<td class="callback__tel"><input type="tel" name="tel" placeholder="Телефон" /></td>
			</tr>
		</table>
		<div class="callback__notification">
            <p>Пожалуйста, введите телефон, по которому мы сможем с вами связаться.</p>
        </div><div>
            <input type="submit" value="Отправить"/>
        </div>
		</form>
		</div>
</section>
<script src="scripts/index.js"></script>
<script src="scripts/libphonenumber-js.min.js"></script>
</body>
</html>
