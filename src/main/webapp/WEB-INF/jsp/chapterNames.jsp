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
                    <div class="col-sm-12 text-left"> 
                        <div>
                              <c:forEach var="ch" items="${sessionScope.chapterNames}">
                                 <p> <a href="${pageContext.request.contextPath}/getWholeContent/${ch.chapterId}/${ch.name}">${ch.name}</a></p>
                                  </c:forEach>       
                         </div>
                </section>            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>

<%-- 
   
    Created on : Nov 3, 2017, 3:47:08 PM
    Author     : hcdc-pc15

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chapters :</h1>
        
        <h2>Get Mahabharata's contents chapterwise : </h2>
         <c:forEach var="ch" items="${sessionScope.chapterNames}">
                <h6><a href="${pageContext.request.contextPath}/getSubchapters/${ch.chapterId}/${ch.name}">${ch.name}</a></h4>
             
         </c:forEach>
                
              <h2>Get Mahabharata's full contents: </h2>  
         <c:forEach var="ch" items="${sessionScope.chapterNames}">
                <h6><a href="${pageContext.request.contextPath}/getVerses/${ch.chapterId}">${ch.name}</a></h6>
              <h4>Get Mahabharata's full contents : </h4>  
                <c:forEach var="ch" items="${sessionScope.chapterNames}">
                <h4><a href="${pageContext.request.contextPath}/getWholeContent/${ch.chapterId}/${ch.name}">${ch.name}</a></h4>
             
         </c:forEach>
                
                
    </body>
</html>
--%>
