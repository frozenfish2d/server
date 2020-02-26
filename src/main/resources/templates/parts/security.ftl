<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>

    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getSecondName()+" "+user.getFirstName()
        isAdmin = user.isAdmin()
        isDoctor = user.isDoctor()
        isLogged = true
    >
<#else>
    <#assign
        name = ""
        isDoctor = false
        isAdmin = false
        isLogged = false
    >
</#if>