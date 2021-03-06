<#import "parts/common.ftl" as common>
<@common.page "Список врачей">
<div><a href="/admin">Назад </a> </div>
<h3>Список врачей</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Фамилия</th>
        <th scope="col">Имя</th>
        <th scope="col">Отчество</th>
        <th scope="col">Дата рождения</th>
        <th scope="col">Должность</th>
        <th scope="col">Специализация</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <#list users as user>
    <#if user.roles?seq_contains('DOCTOR')>
    <tr>
        <td>${user.secondName}</td>
        <td>${user.firstName}</td>
        <td>${user.middleName}</td>
        <td>${user.bDay}</td>
        <td>${user.bDay}</td>
        <td>${user.bDay}</td>
        <td><a href="/admin/uid_${user.userId}">Edit</a> </td>
    </tr>
</#if>
</#list>
</table>

</@common.page>