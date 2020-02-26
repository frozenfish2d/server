<#import "parts/common.ftl" as common>
<@common.page "Редактирование пользователя">

<form action="/admin" method="post" xmlns="http://www.w3.org/1999/html">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Фамилия:</label>
        <div class="col-sm-6">
            <input type="text" name="secondName" value="${user.secondName}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя:</label>
        <div class="col-sm-6">
            <input type="text" name="firstName" value="${user.firstName}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Отчество:</label>
        <div class="col-sm-6">
            <input type="text" name="middleName" value="${user.middleName}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Дата рождения:</label>
        <div class="col-sm-6">
            <input type="date" name="bDay" value="${user.bDay}" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер телефона:</label>
        <div class="col-sm-6">
            <input type="tel" name="phoneNumber" value="${user.phoneNumber}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Адрес:</label>
        <div class="col-sm-6">
            <input type="text" name="address" value="${user.address}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер полиса ОМС:</label>
        <div class="col-sm-6">
            <input type="text" name="omsNumber" value="${user.omsNumber}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Логин:</label>
        <div class="col-sm-6">
            <input type="text" name="username" value="${user.username}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">E-mail:</label>
        <div class="col-sm-6">
            <input type="email" name="email" value="${user.email}" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
    <#list roles as role>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
            <label class="form-check-label">${role}</label>
        </div>
    </#list>
    </div>
    <#if user.roles?seq_contains('DOCTOR')>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Специализация:</label>
            <select class="custom-select" name="specialisation" class="col-sm-5">
            <#list specialisations as specialisation>
                <option value="${specialisation.specializationId}">${specialisation.specialisationName}</option>
            </#list>
            </select>
        </div>
    </#if>
    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-sm-8"><input type="submit" value="Сохранить" class="btn btn-secondary btn-lg btn-block"/></div>
</form>


</@common.page>