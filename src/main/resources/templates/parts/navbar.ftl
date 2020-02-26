<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-dark"  style="background-color: #3F3F3F;">
    <a class="navbar-brand" href="/">My clinic</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Личный кабинет</a>
            </li>
            <#if !isDoctor&&!isAdmin&&isLogged>
                <li class="nav-item">
                    <a class="nav-link" href="/records">Записаться к врачу</a>
                </li>
            <#elseif isDoctor>
                <li class="nav-item">
                    <a class="nav-link" href="/records">Мое расписание</a>
                </li>
            </#if>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Admin Panel</a>
                </li>
            </#if>
        </ul>
    </div>
    <#if name != "">
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </#if>
</nav>