<#import "parts/common.ftl" as common>
<@common.page "Дополнительные услуги">
<div><a href="/admin">Назад </a> </div>

<form action="/admin/add_service" method="post" class="form-inline mb-3 mt-3">
    <div class="form-group mr-3">
            <input type="text" name="serviceName" class="form-control" placeholder="Название услуги"/>
    </div>
    <div class="form-group mr-3">
        <input type="text" name="servicePrice" class="form-control" placeholder="Цена услуги"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-secondary btn-lg btn-block" />
    </div>
</form>
<h3>Список дополнительных услуг</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Название</th>
        <th scope="col">Цена</th>
    </tr>
    </thead>
    <#list services as service>
        <tr>
            <td>${service.serviceName}</td>
            <td>${service.servicePrice}</td>
        </tr>
    </#list>

</table>

</@common.page>