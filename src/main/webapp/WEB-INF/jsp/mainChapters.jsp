<%-- 
    Document   : mainChapters
    Created on : Nov 17, 2017, 11:36:03 AM
    Author     : Harshada
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:forEach var="ch" items="${sessionScope.chapterNames}">
                <h6><a href="${pageContext.request.contextPath}/getTotalSpeakers/${ch.chapterId}">${ch.name}</a></h6>
             
         </c:forEach>
    </body>
</html>
