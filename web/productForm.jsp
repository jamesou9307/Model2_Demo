<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-09-18
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
<div id="global">
    <c:if test="${requestScope.errors!=null}">
        <p id="errors">

            Error(s)!
        <ul>
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
        </p>
    </c:if>
    <form action="save.do" method="post">
        <fieldset>
            <legend>Add a Product</legend>
            <p>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Product Description:</label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Product Price:</label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
