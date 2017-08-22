<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="elements/header.jsp"/>


<form action="${pageContext.request.contextPath}/events" method="post" class="form-horizontal" style="width: 30%">
    <div class="form-group">
        <label for="inputEmail4" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail4" name="name" placeholder="Name events" required>
        </div>
    </div>

    <div class="form-group">
        <label for="inputEmail5" class="col-sm-2 control-label">Latitude</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail5" name="latitude" placeholder="latitude" required>
        </div>
    </div>

    <div class="form-group">
        <label for="inputEmail6" class="col-sm-2 control-label">Longitude</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail6" name="longitude" placeholder="longitude" required>
        </div>
    </div>

    <div class="form-group">
        <label for="inputEmail7" class="col-sm-2 control-label">Date/Time</label>
        <div class="col-sm-10">
            <input type="datetime-local" class="form-control" id="inputEmail7" name="dateTime" placeholder="dateTime" required>
        </div>
    </div>
    <p>
        <select size="1" multiple name="groupId" required>
            <option disabled>Select groups</option>
            <c:forEach items="${groups}" var="group">
                <option value="${group.getId()}">${group.getName()}</option>
            </c:forEach>
        </select>
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Create</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="reset" class="btn btn-default">Reset</button>
        </div>
    </div>
</form>


<h3>
    Select a group to view events
</h3>

<form method="post" action="/events/all">
    <select size="1" multiple name="groupId" required>
        <option disabled>Select groups</option>
        <c:forEach items="${groups}" var="group">
            <option value="${group.getId()}">${group.getName()}</option>
        </c:forEach>
    </select>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button type="submit">Check</button>
</form>


<%--<form action="${pageContext.request.contextPath}/events" method="post">--%>
<%--<label>--%>
<%--<input type="text" name="name" required>--%>
<%--</label>--%>

<%--<p>--%>
<%--<label>--%>
<%--<input type="text" name="latitude" required>--%>
<%--</label>--%>
<%--<p>--%>
<%--<label>--%>
<%--<input type="text" name="longitude" required>--%>
<%--</label>--%>
<%--<p>--%>
<%--<label>--%>
<%--<input type="datetime-local" name="dateTime" required>--%>
<%--</label>--%>
<%--<p>--%>

<%--<p>--%>
<%--<select size="1" multiple name="groupId" required>--%>
<%--<option disabled>Select groups</option>--%>
<%--<c:forEach items="${groups}" var="group">--%>
<%--<option value="${group.getId()}">${group.getName()}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</p>--%>
<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--<button type="reset">Reset</button>--%>
<%--<button type="submit" value="submit">Create event</button>--%>
<%--</form>--%>
<hr>
<center>
    <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=
constructor%3Acd6c53c10d279670a6c596582bb6cd22da7db365fdcf54b46cdb795058f7f4ae
&amp;width=544&amp;height=365&amp;lang=ru_RU&amp;scroll=true"></script>
</center>

<jsp:include page="elements/footer.jsp"/>