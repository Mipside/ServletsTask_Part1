<%--
  Created by IntelliJ IDEA.
  User: Julia
  Date: 18.05.2019
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="cp1251">
    <title>Login</title>
    <meta charset="UTF-8">
</head>
<body>
<div align="center">
    <div>
        <form action="<c:url value="/user/login/"/>" method="post">
				<span>
                    <h1>	Sign In</h1>
				</span>

            <div data-validate="Enter username or email">
                <input type="text" name="username" placeholder="username">
                <span></span>
            </div>

            <div data-validate="Enter password">
                <input type="password" name="password" placeholder="password">
                <span></span>
            </div>
            <div>
                <button>
                    Sign In
                </button>
            </div>
        </form>

    </div>
</div>


</body>
</html>
