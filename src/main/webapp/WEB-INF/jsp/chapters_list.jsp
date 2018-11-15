<%-- 
    Document   : chapters_list
    Created on : Nov 16, 2017, 5:26:28 PM
    Author     : Jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html> 
<html>
    <head>
        <title>Text-Extraction-Tool</title>  
        <%@include file="pages/inc/common-head.jsp" %>
    </head>
    <body>
        <%@include file="pages/inc/header.jsp" %>

        <div class="container text-center">
            <div class="row content ">
                   
                <section class="main-container jumbotron col-lg-12 col-md-12 col-sm-12 col-xs-12" style="min-height: 760px;">
                    <div class="col-sm-12 text-center"> 
                        <div>                             
                                         <c:forEach var="ch" items="${sessionScope.chapterName}">
                                             <p><a href="${pageContext.request.contextPath}/getSubchapters/${ch.chapterId}/${ch.name}">${ch.name}</a></p>
                                         </c:forEach>
                         </div>
                </section>            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>
