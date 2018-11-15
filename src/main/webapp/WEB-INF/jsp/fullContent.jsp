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
                    <p>Here we came up with the new idea to understand the Mahabharata in easy way. </p>
                    <div class="col-sm-8 text-left"> 
                         <div>
                             <h4>Sub chapter Name :  ${sessionScope.subchaptername}</h4>

                             <h4>Speaker Name :  ${sessionScope.speakername}</h4>

                             <c:forEach var="verse" items="${sessionScope.fullcontent}">
                                 <hr>
                                 <h4>${verse.verseContent}</h4>	   
                                 <h4></h4>
                             </c:forEach>
                         </div>
                </section>
            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>


<%-- 
    Document   : fullContent
    Created on : Sep 21, 2017, 3:43:45 PM
    Author     : hcdc-pc16

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <div>
            <h4>Sub chapter Name :  ${sessionScope.subchaptername}</h4>

            <h4>Speaker Name :  ${sessionScope.speakername}</h4>

            <c:forEach var="verse" items="${sessionScope.fullcontent}">
                <hr>
                <h4>${verse.verseContent}</h4>	   
                <h4></h4>
            </c:forEach>

        </div>
    </body>
</html>
--%>