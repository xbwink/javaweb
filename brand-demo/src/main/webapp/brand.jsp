<%--
  Created by IntelliJ IDEA.
  User: xb
  Date: 2022/11/15
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${user!=null}">
  <h1>欢迎您,${user.username}</h1>
</c:if>
<input type="button" value="新增" onclick="on()"><br>
<hr>
<table border="1" cellspacing="0" width="800">
  <tr>
    <th>序号</th>
    <th>品牌名称</th>
    <th>企业名称</th>
    <th>排序</th>
    <th>品牌介绍</th>
    <th>状态</th>
    <th>操作</th>
  </tr>

  <c:forEach items="${brands}" var="brand">
  <tr align="center">
    <td>${brand.id}</td>
    <td>${brand.brandName}</td>
    <td>${brand.companyName}</td>
    <td>${brand.ordered}</td>
    <td>${brand.description}</td>
    <c:if test="${brand.status == 1}">
      <td>启用</td>
    </c:if>
    <c:if test="${brand.status != 1}">
      <td>禁用</td>
    </c:if>
    <td><a href="/brand_demo/selectByIdServlet?id=${brand.id}" id="btnUpdate">修改</a> <a href="/brand_demo/deleteServlet?id=${brand.id}">删除</a></td>
  </tr>
  </c:forEach>

</table>


</body>
</html>
<script>

//修改地址到addBrand.html
function on(){
  location.href = "addBrand.jsp"
}



</script>
