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
                        <h4>Character's Name</h4>
                        <div>
                            <c:forEach var="speaker" items="${sessionScope.speakers}">
                               <p> <a href="${pageContext.request.contextPath}/getCharacterWiseContents/${speaker.id}/1">${speaker.name}</a></p>
                            </c:forEach>    
                         </div>
                        <br>
                        <br>
                           <div class="container">
                              <c:set var="limit" value="${420}"/>
                               <c:forEach var="i" begin="1" end="${limit/15}">
                                 &nbsp;    <a href="${pageContext.request.contextPath}/getTotalSpeakers/${i}">${i}</a>  &nbsp; 
                               </c:forEach>
                             </div>
                </section>            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>


<%-- 
    Document   : characters
    Created on : Nov 16, 2017, 6:01:55 PM
    Author     : Harshada

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <c:forEach var="speaker" items="${requestScope.speakers}">
               
                     <h4><a href="${pageContext.request.contextPath}/getCharacterWiseContents/${speaker.id}">${speaker.name}</a></h4> 
                    
            </c:forEach>
    </body>
</html>
        <%--  <c:forEach var="speaker" items="${requestScope.speakers}">
               
                     <h4><a href="${pageContext.request.contextPath}/getCharacterWiseContents/${requestScope.chapterId}/${speaker.id}">${speaker.name}</a></h4> 
                    
            </c:forEach>
        --%>
        --%>