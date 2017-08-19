<jsp:include page="elements/header.jsp"/>


<form action="${pageContext.request.contextPath}/login" method="post">


    <label>
        <input type="text" name="username" required>
    </label>
    <p>
        <label>
            <input type="password" name="password" required>
        </label>
    <p>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit">Login in</button>
</form>


<jsp:include page="elements/footer.jsp"/>