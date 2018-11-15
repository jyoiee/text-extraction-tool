<%-- 
    Document   : common-layout
    Created on : Nov 16, 2017, 11:29:59 AM
    Author     : Jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container text-center">
            <div class="row content ">
                    <section class="sidebar col-lg-3 col-md-3 col-sm-4 col-xs-12" >
                    <ul class="list-group">
                        <li><a class="list-group-item"  href="#">Full Content</a></li>
                        <a class="list-group-item"  href="#">Chapter Name</a>
                        <a class="list-group-item"  href="#">Characters in Mahabharata</a>
                    </ul>
                </section> 
            </div>
        </div>
    </body>
</html>
