<%-- 
    Document   : header
    Created on : Nov 14, 2017, 3:08:20 PM
    Author     : Jyoti
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" 
                type="button" 
                data-toggle="collapse" 
                data-target="#navbarsExampleDefault" 
                aria-controls="navbarsExampleDefault" 
                aria-expanded="false" 
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="${context}/WEB-INF/jsp/index.jsp">
            <strong style="font-size: 30px;font-weight: bold;">Text Extraction Tool</strong>
        </a>
    </div>
</nav>
<br>