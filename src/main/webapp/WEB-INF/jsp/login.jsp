<jsp:include page="elements/header.jsp"/>


<form action="${pageContext.request.contextPath}/login" method="post">


    <label>
        <input type="text" name="login">
    </label>
    <p>
        <label>
            <input type="password" name="password">
        </label>
    <p>

        <button type="submit">Login in</button>
</form>


<jsp:include page="elements/footer.jsp"/>