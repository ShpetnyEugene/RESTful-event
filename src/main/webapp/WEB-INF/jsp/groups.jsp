<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="elements/header.jsp"/>

<h3>Create new group</h3>

<form action="${pageContext.request.contextPath}/groups" method="post" class="form-horizontal" style="width: 30%">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="name" placeholder="Name group" required>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Create</button>
        </div>
    </div>
</form>

<h3>All groups:</h3>
<hr>
<table align="center" class="table table-hover" style="width: auto;">
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
            <td>
                <form method="post" action="/groups/join">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" name="join" value="${groups.getId()}">Join</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="elements/footer.jsp"/>