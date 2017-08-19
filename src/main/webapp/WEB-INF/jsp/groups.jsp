<jsp:include page="elements/header.jsp"/>



<form action="${pageContext.request.contextPath}/groups" method="post">


    <p> Name: <p>

    <label>
        <input type="text" name="name" required>
    </label>

    <p>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button type="submit">Create group</button>
</form>
<jsp:include page="elements/footer.jsp"/>