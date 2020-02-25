<#import "parts/common.ftl" as common>
<@common.page "Список заболеваний">
<div><a href="/admin">Назад </a> </div>

<form action="/admin/add_disease" method="post" class="form-inline mb-3 mt-3">
    <div class="form-group mr-3">
            <input type="text" name="diseaseName" class="form-control" placeholder="Название заболевания"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-secondary btn-lg btn-block" />
    </div>
</form>
<h3>Список заболеваний</h3>
<table class="table">

    <#list diseases as disease>
            <tr>
                <td>${disease.diseaseName}</td>
            </tr>
</#list>

</table>

</@common.page>