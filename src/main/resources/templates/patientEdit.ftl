<#import "parts/common.ftl" as common>
<@common.page "Редактировать информацию">

<form action="/main/save" method="post">


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
        <label class="col-sm-2 col-form-label">* Пароль:</label>
        <div class="col-sm-6">
           <input type="password" name="password"  class="form-control"/>
        </div>
    </div>

    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-sm-8"><input type="submit" value="Сохранить" class="btn btn-secondary btn-lg btn-block"/></div>
</form>


</@common.page>