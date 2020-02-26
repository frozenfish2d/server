<#macro registration>
<form action="/registration" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Фамилия:</label>
        <div class="col-sm-6">
            <input type="text" name="secondName" placeholder="Фамилия"
                   value="<#if user??>${user.secondName}</#if>"
                   class="form-control ${(secondNameError??)?string('is-invalid','')}"/>
            <#if secondNameError??>
                <div class="invalid-feedback">
                    ${secondNameError}
                </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Имя:</label>
        <div class="col-sm-6">
            <input type="text" name="firstName" placeholder="Имя"
                   value="<#if user??>${user.firstName}</#if>"
                   class="form-control ${(firstNameError??)?string('is-invalid','')}"/>
            <#if firstNameError??>
                <div class="invalid-feedback">
                    ${firstNameError}
                </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Отчество:</label>
        <div class="col-sm-6">
            <input type="text" name="middleName" placeholder="Отчество" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Дата рождения:</label>
        <div class="col-sm-6">
            <input type="date" name="bDay" placeholder="Дата рождения" class="form-control"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер телефона:</label>
        <div class="col-sm-6">
            <input type="tel" name="phoneNumber" placeholder="+79991234567"
                   value="<#if user??>${user.phoneNumber}</#if>"
                   class="form-control ${(phoneNumberError??)?string('is-invalid','')}"/>
            <#if phoneNumberError??>
                <div class="invalid-feedback">
                    ${phoneNumberError}
                </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Адрес:</label>
        <div class="col-sm-6">
            <input type="text" name="address" placeholder="Адрес"
                   value="<#if user??>${user.address}</#if>"
                   class="form-control ${(addressError??)?string('is-invalid','')}"/>
            <#if addressError??>
                <div class="invalid-feedback">
                    ${addressError}
                </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Номер полиса ОМС:</label>
        <div class="col-sm-6">
            <input type="text" name="omsNumber" placeholder="Номер полиса ОМС"
                   value="<#if user??>${user.omsNumber}</#if>"
                   class="form-control ${(omsNumberError??)?string('is-invalid','')}"/>
            <#if omsNumberError??>
            <div class="invalid-feedback">
                ${omsNumberError}
            </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Имя пользователя:</label>
        <div class="col-sm-6">
            <input type="text" name="username" placeholder="Логин"
                   value="<#if user??>${user.username}</#if>"
                   class="form-control ${(usernameError??)?string('is-invalid','')}"/>
            <#if usernameError??>
            <div class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Пароль:</label>
        <div class="col-sm-6">
            <input type="password" name="password" placeholder="Пароль"
                   class="form-control ${(passwordError??)?string('is-invalid','')}"/>
            <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* Подтвердите пароль:</label>
        <div class="col-sm-6">
            <input type="password" name="passwordConfirm" placeholder="Подтвердите пароль"
                   class="form-control ${(password2Error??)?string('is-invalid','')}"/>
            <#if password2Error??>
                <div class="invalid-feedback">
                    ${password2Error}
                </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">* E-mail:</label>
        <div class="col-sm-6">
            <input type="text" name="email" placeholder="E-mail"
                   value="<#if user??>${user.email}</#if>"
                   class="form-control ${(emailError??)?string('is-invalid','')}"/>
            <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <div class="g-recaptcha" data-sitekey="6LddiNsUAAAAAN4JUf-4-rk-9BaUOneJnUOJ8q6_"></div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-sm-8"><input type="submit" value="Зарегистрироваться" class="btn btn-secondary btn-lg btn-block"/></div>
</form>
<div>Поля отмеченные * обязательны к заполнению</div>
</#macro>