<jsp:include page="elements/header.jsp"/>



<form action="${pageContext.request.contextPath}/users/{userID}/groups" method="post">


    <p> Name: <p>

    <label>
        <input type="text" name="name">
    </label>

    <p>

        <button type="submit">Create group</button>
</form>




<jsp:include page="elements/footer.jsp"/>