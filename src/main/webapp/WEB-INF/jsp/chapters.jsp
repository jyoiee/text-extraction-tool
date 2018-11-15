
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
                            <c:forEach var="verse" items="${requestScope.verses}">
                                <p><h5> " ${verse.verseContent}  "</h5> &nbsp;  &nbsp; - ${verse.sDetails.name}  </p> 
                           <>
                            </c:forEach>      
                         </div>
                         <a href="${pageContext.request.contextPath}/getSubChapterwiseVerses/${sessionScope.SubchapterId}/1">1</a>   
                            <a href="${pageContext.request.contextPath}/getSubChapterwiseVerses/${sessionScope.SubchapterId}/2">2</a>   
                            <a href="${pageContext.request.contextPath}/getSubChapterwiseVerses/${sessionScope.SubchapterId}/3">3</a>  
                </section>            
            </div> 
        </div>
           
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>

<%-- 
    Document   : chapters
    Created on : Sep 20, 2017, 3:44:00 PM
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
        <h1>Hello </h1>
        <div class="panel-body" >

            <c:forEach var="cd" items="${requestScope.chapterNames}">
                <h4><a href="${pageContext.request.contextPath}/verses/getFullDnyaneshwary/${cd.chapterId}">${cd.chapNo} . ${cd.name}</a></h4>
            </c:forEach>


            <c:forEach var="cm" items="${requestScope.MahaChapter}">
                <h4><a href="${pageContext.request.contextPath}/verses/getFullMahabharat/${cm.chapterId}">${cm.name}</a></h4>
                </c:forEach>


            <c:forEach var="ln" items="${requestScope.Language}">
                <h4><a href="${pageContext.request.contextPath}/chapter/getChapters/${ln.id}">${ln.lang}</a></h4>
                </c:forEach>
           
                 <c:forEach var="cm" items="${requestScope.Chapterlist}">
                <h4><a href="${pageContext.request.contextPath}/verses/getFullMahabharat/${cm.chapterId}">${cm.name}</a></h4>
                </c:forEach>
        </div>
    </body>
</html>
--%>