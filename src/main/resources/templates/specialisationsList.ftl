<#import "parts/common.ftl" as common>
<@common.page "Список специализаций">
<div><a href="/admin">Назад </a> </div>

<form action="/admin/add_specialisation" method="post" class="form-inline mb-3 mt-3">
    <div class="form-group mr-3">
            <input type="text" name="specialisationName" class="form-control" placeholder="Название специализации"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-secondary btn-lg btn-block" />
    </div>
</form>
<h3>Список специализаций</h3>
<table class="table">

    <#list specialisations as specialisation>
            <tr>
                <td>${specialisation.specialisationName}</td>
            </tr>
    </#list>

</table>

</@common.page>