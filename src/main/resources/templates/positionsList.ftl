<#import "parts/common.ftl" as common>
<@common.page "Должности врачей">
<div><a href="/admin">Назад </a> </div>

<form action="/admin/add_position" method="post" class="form-inline mb-3 mt-3">
    <div class="form-group mr-3">
            <input type="text" name="positionName" class="form-control" placeholder="Название должности"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-secondary btn-lg btn-block" />
    </div>
</form>
<h3>Должности врачей</h3>
<table class="table">
    <#list positions as position>
            <tr>

                <td>${position.positionName}</td>
            </tr>
    </#list>

</table>

</@common.page>