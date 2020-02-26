<#macro login>
<form action="/login" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя пользователя:</label>
        <div class="col-sm-5">
            <input type="text" name="username" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Пароль:</label>
        <div class="col-sm-5">
            <input type="password" name="password" class="form-control"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-sm-7"><input type="submit" value="Войти" class="btn btn-secondary btn-lg btn-block"/></div>

</form>
<div class="mt-2">
    <a href="/registration">Зарегистрироваться</a>
</div>
</#macro>

<#macro logout>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Выйти" class="btn btn-outline-secondary"/>
    </form>
</div>
</#macro>