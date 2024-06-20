<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 20/06/2024
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Register</title>
</head>
<body>
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <h2> Register </h2>
    <form action="signup" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">username</label>
            <input type="text" class="form-control" id="username" name="inputUsername">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">password</label>
            <input type="password" class="form-control" id="password" name="inputPassword">
        </div>

        <button type="submit" class="btn btn-primary">Register</button>

        <p><a href="${pageContext.request.contextPath}/user/pagesignin">Already registered</a></p>

    </form>
</div>

</body>
</html>
