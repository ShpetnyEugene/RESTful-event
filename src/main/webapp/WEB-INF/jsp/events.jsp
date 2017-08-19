<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="elements/header.jsp"/>


<form action="${pageContext.request.contextPath}/events" method="post">


    <%--<table>--%>
        <%--<tr>--%>
            <%--Name:--%>
        <%--</tr>--%>
        <%----%>
        <%--<tr>--%>
            <%--Coordinate:--%>
        <%--</tr>--%>
        <%----%>
        <%----%>
        <%--<c:forEach items="events" var="{items}">--%>
            <%----%>
        <%--</c:forEach>--%>
    <%--</table>--%>


    <label>
        <input type="text" name="name" required>
    </label>

    <p>
        <label>
            <input type="text" name="latitude" required>
        </label>
    <p>
        <label>
            <input type="text" name="longitude" required>
        </label>
        <p>
            <label>
                <input type="datetime-local" name="dateTime" required>
            </label>
    <p>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


        <button type="reset">Reset</button>
        <button type="submit" value="submit">Create event</button>
</form>


<script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=
constructor%3Acd6c53c10d279670a6c596582bb6cd22da7db365fdcf54b46cdb795058f7f4ae
&amp;width=544&amp;height=365&amp;lang=ru_RU&amp;scroll=true"></script>

<jsp:include page="elements/footer.jsp"/>