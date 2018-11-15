<%-- 
    Document   : dcontents
    Created on : Nov 10, 2017, 2:43:42 PM
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
        <h1>Hello World!</h1>
        
        <table style="border: grey solid ">
            <tbody>
                
                    <c:forEach var="d" items="${requestScope.listOfWords}">
                       <tr>
                            <td><h4>${d.id} </h4></td>
                            <td><h4>${d.originalName} </h4></td>
                            <td><h4>${d.meaning} </h4></td>
               
                      </tr>
           
                    </c:forEach>
              
                
                
            </tbody>
            
            
        </table>
        
        
    </body>
</html>
