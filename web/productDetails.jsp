<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-09-18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
</head>
<body>
<div id="global">
    <h4>The Product has been saved</h4>
    <p>
    <h5>Details:</h5>
    Product Name: ${requestScope.product.productName};
    Product Description: ${requestScope.product.description}
    Product Price:${requestScope.product.price}
    </p>
</div>
</body>
</html>
