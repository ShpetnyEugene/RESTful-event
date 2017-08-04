<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="elements/header.jsp"/>

 <form action="${pageContext.request.contextPath}/registration" method="post">


    <p>Enter nick Name: </p>
    <label>
        <input type="text" name="nickName">
    </label>


    <p> Enter password: </p>
    <label>
        <input type="password" name="password1">
    </label>


    <p>Repeat password: </p>
    <label>
        <input type="password" name="password2">
    </label>

    <p>
    <button type="submit">Sign Up</button>


<jsp:include page="elements/footer.jsp"/>