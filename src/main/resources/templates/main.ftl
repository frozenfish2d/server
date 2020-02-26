<#import "parts/common.ftl" as common>
<@common.page "Личный кабинет">

<h3>Личный кабинет</h3>
<div>
    ФИО<br>
    <b>${user.secondName} ${user.firstName} ${user.middleName}</b>
</div>
<br>
<div>
    Номер полиса ОМС<br>
    <b>${user.omsNumber}</b>
</div>
<br>
<div>
    Адрес<br>
    <b>${user.address}</b>
</div>
<br>
<div>
    Номер телефона<br>
    <b>${user.phoneNumber}</b>
</div>
<br>
<div>
    E-mail<br>
    <b>${user.email}</b>
</div>
<br>
<div>
    <a href="main/edit">Изменить данные</a>
</div>
<br>
<h3>Мои записи</h3>
<div>Нет записей</div>
<br>
<h3>Архив</h3>
<div>Нет записей</div>
</@common.page>