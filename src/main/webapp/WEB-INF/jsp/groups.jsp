<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="elements/header.jsp"/>


<form action="${pageContext.request.contextPath}/groups" method="post">



    <p> Name:
    <p>

        <label>
            <input type="text" name="name" required>
        </label>

    <p>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit">Create group</button>
</form>


<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Count events</th>
        <th>Count users</th>
        <th>Action</th>
    </tr>
    <c:forEach var="groups" items="${groups}">
        <tr>
            <td>${groups.getId()}</td>
            <td>${groups.getName()}</td>
            <td>${groups.getEvents().size()}</td>
            <td>${groups.getUsers().size()}</td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="elements/footer.jsp"/>