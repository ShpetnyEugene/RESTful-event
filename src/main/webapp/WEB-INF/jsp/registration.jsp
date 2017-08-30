<jsp:include page="elements/header.jsp"/>

<form action="${pageContext.request.contextPath}/registration" method="post" class="form-horizontal" style="width: 30%">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Login</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="nickName" placeholder="Login" required>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" name="password1" class="form-control" id="inputPassword4" required
                   placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Repeat password</label>
        <div class="col-sm-10">
            <input type="password" name="password2" class="form-control" id="inputPassword3" required
                   placeholder="Password">
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>

<jsp:include page="elements/footer.jsp"/>