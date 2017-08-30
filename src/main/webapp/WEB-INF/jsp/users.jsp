<jsp:include page="elements/header.jsp"/>

<form action="${pageContext.request.contextPath}/users" method="post" class="form-horizontal" style="width: 30%">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Latitude</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="latitude" placeholder="latitude" required>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Longitude</label>
        <div class="col-sm-10">
            <input type="text" name="longitude" class="form-control" id="inputPassword3" required
                   placeholder="Longitude">
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Set</button>
        </div>
    </div>

</form>
<jsp:include page="elements/footer.jsp"/>