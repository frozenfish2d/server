<#import "parts/common.ftl" as common>
<@common.page "Личный кабинет">

<h3>Личный кабинет</h3>
<div>
    ${user.secondName} ${user.firstName} ${user.middleName}
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

<h3>Мои записи</h3>

<h3>Архив</h3>

</@common.page>