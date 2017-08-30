<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="elements/header.jsp"/>

<table align="center" class="table table-hover" style="width: auto;">

    <h3>
        Event that will soon occur
    </h3>
    <hr>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>dateTime</th>
        <th>Coordinate</th>
    </tr>
    <c:forEach var="events" items="${events}">
        <tr>
            <td>${events.getId()}</td>
            <td>${events.getName()}</td>
            <td>${events.getDateTime()}</td>
            <td>${events.getCoordinate()}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="elements/footer.jsp"/>