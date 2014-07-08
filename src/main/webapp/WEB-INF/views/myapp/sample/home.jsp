<%@ page language= "java" contentType ="text/html; charset=UTF-8" pageEncoding ="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Hello world!!!!!!!!!</h1>
    <h2>${sMessage}</h2>
    <P>The time on the server is ${serverTime}.</P>
    <table border="1">
        <tr>
            <th>종목단축코드</th>
            <th>종목명</th>
            <th>종목코드</th>
            <th>시장구분</th>
        </tr>
        <c:forEach var="m" items="${rs}">
            <tr>
                <td><c:out value="${m.gicode}"/></td>
                <td><c:out value="${m.itemcd}"/></td>
                <td><c:out value="${m.itemabbrnm}"/></td>
                <td><c:out value="${m.mkt_gb}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>