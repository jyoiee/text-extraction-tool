<%-- 
    Document   : contents
    Created on : Nov 3, 2017, 4:57:52 PM
    Author     : hcdc-pc15
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
      <c:forEach var="speaker" items="${sessionScope.speakers}">
               
                     <h4><a href="${pageContext.request.contextPath}/SearchAndRetreive/${sessionScope.subchapterId}/${speaker['key']}">${speaker['value']}</a></h4> 
                    
            </c:forEach>
       
          
     
                
        
    </body>
</html>
