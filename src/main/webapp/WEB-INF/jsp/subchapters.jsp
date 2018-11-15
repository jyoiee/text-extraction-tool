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
                        <h4>Sub Chapters Numbers</h4>
                        <div>
                            <c:forEach var="subch" items="${sessionScope.subchapters}">
                                <a href="${pageContext.request.contextPath}/getChapterwiseVerses/${subch.id}"> &nbsp; &nbsp;  ${subch.subchapNo} &nbsp; &nbsp;  </a> 
                            </c:forEach>      
                         </div>
                </section>            
            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>
