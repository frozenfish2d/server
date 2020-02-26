<#import "parts/common.ftl" as common>
<@common.page "Личный кабинет">

<h3>Личный кабинет</h3>
<div>
    ${user.firstName} ${user.middleName}
</div>
<div>
    ${user.omsNumber}
</div>
<div>
    ${user.address}
</div>
<div>
    ${user.phoneNumber}
</div>
<div>
    ${user.email}
</div>
<div>
    <a href="main/edit">Изменить данные</a>
</div>

<h3>Мои записи</h3>
<div>Нет записей</div>
<h3>Архив</h3>
<div>Нет записей</div>
</@common.page>