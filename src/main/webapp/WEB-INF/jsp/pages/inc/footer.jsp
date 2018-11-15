<%-- 
    Document   : footer
    Created on : Nov 15, 2017, 12:29:05 PM
    Author     : Jyoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<style>
  /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
</style>
<footer class="footer navbar navbar-inverse navbar-fixed-bottom">
    <section class="container">
        <br>
        <p>All rights reserved <i class="fa fa-copyright"></i> 2017, <a href="${context}">Text Extraction Tool</a> &mdash; Language Research</p>
    </section>
</footer>
