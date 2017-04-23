<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="logo-div">
    <img src="./static/images/logo_transparent.png" height="64px" width="64px"/>
</div>
<div class="header-content">
    <h1 class="text-3d">Consult-IT Enterprise Platform</h1>
</div>
<core:if test='${not empty USER_CONTEXT}'>
    <form action="./logout">
        <input type="submit" id="logout-btn" value="Logout" class="button-logout"/>
    </form>
</core:if>