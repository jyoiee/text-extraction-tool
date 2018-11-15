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
                             <h4>${ch.name}</h4>
                             <c:forEach var="ch" items="${requestScope.contents}">
                                 ${ch.fullContent}
                             </c:forEach>
                         </div>
                </section>
            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>

<%-- 
    Document   : chapterContents
    Created on : Nov 7, 2017, 5:46:49 PM
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
        <h4>${ch.name}</h4>
        <c:forEach var="ch" items="${requestScope.contents}">
                <h4><a href="${pageContext.request.contextPath}/getWholeContent/${ch.chapterId}/${ch.name}">${ch.fullContent}</a></h4>
         </c:forEach>
        
        
    </body>
</html>
--%>