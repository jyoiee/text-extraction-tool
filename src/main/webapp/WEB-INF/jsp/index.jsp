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
                <section class="sidebar col-lg-3 col-md-3 col-sm-4 col-xs-12"" >
                    <div style="padding-right:  1px; background-color:#eceeef; min-height: 760px; " >
                        <ul class="list-group">
                            <li><a class="list-group-item"  href="${pageContext.request.contextPath}/forTextLikeData">Full Content as plain text</a></li>
                            <a class="list-group-item"  href="${pageContext.request.contextPath}/forVerseWiseData">Chapter wise Verses</a>
                            <a class="list-group-item"  href="${pageContext.request.contextPath}/getTotalSpeakers/1">Characters wise Verses</a>
                        </ul>
                    </div>
                </section> 
                <section class="main-container jumbotron col-lg-9 col-md-9 col-sm-8 col-xs-12" style="min-height: 760px;">
                    <p>Here we came up with the new idea to understand the Mahabharata in easy way. </p>
                    <div class="col-sm-8 text-left"> 
                        <form>
                            <div class="form-group">
                                <label for="keyword">Enter Keyword to search:  </label>
                                <input type="text" class="form-control" id="keyword" placeholder="Keyword">
                            </div>
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>
                    </div>
                </section>

            </div> 
        </div>     
        <%@include file="pages/inc/footer.jsp" %>
    </body>
</html>
<!--              <p><a href="${pageContext.request.contextPath}/readData"> Read Excel File</a>  </p> 
              <p><a href="${pageContext.request.contextPath}/readDataBase"> Read dictionary from database</a>  </p> 
-->