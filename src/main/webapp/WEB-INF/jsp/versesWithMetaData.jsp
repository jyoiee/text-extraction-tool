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
                        <h4>${verse.sDetails.name}</h4>
                        <div>
                            <hr>
                            <c:forEach var="verse" items="${sessionScope.verses}">
                                <div style="border: 1px; background-color: window;">
                                    <br>
                                    <c:set var="verseId" value="${verse.id}"/> 
                                    <p>"${verse.verseContent} "</p>
                                    <p><h5>Parva's Name &nbsp &nbsp :   &nbsp &nbsp ${verse.subchapterno.CDetails.name} </h5></p>
                                    <p><h5>Parva's Sub Parva No &  Name  &nbsp &nbsp :: &nbsp &nbsp ${verse.subchapterno.subchapNo} &nbsp &nbsp : ${verse.subchapterno.sname}</h5></p>
                                    <br>  
                                </div>
                                <div>
                                    <div style="border: 1px; background-color: whitesmoke;" id="sensediv">
                                        <c:forEach var="sense" items="${sessionScope.senseList}"> 
                                            <c:choose>
                                                <c:when test="${sense.vDetails.id==verse.id}">
                                                    <div class="text-md-left">
                                                        <c:set var="senseId" value="${sense.id}"/> 
                                                         <h4><span class="glyphicon glyphicon-pencil">${sense.meaning}</span></h4>
                                                         <div>
                                                         <h4><span class="glyphicon glyphicon-user">${sense.username}&nbsp</span>     
                                                          <a href="${context}/addlike/${sense.id}"><span class="glyphicon glyphicon-thumbs-up"></span></a>${sense.like}&nbsp &nbsp  
                                                         <a href="${context}/addunlike/${sense.id}"> <span class="glyphicon glyphicon-thumbs-down"></span></a>${sense.unlike} </h4> 
                                                         </div>
                                                    
                                                    <c:forEach var="comment" items="${requestScope.commentList}">                                              
                                                        <c:choose>
                                                            <c:when test="${comment.cDetails.id==sense.id}">
                                                                <div style="background-color: white">
                                                                <br>
                                                                <span class="glyphicon glyphicon-user">${comment.username} </span>  &nbsp &nbsp<span class="glyphicon glyphicon-comment">${comment.comment}</span>
                                                             
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>           
                                                    </c:forEach>  
                                                    <div>
                                                        <button type="button" class="btn btn-primary btn-add-comment" data-toggle="modal" data-target="#modal-add-comment" data-sense-id="${senseId}">
                                                            <span class="glyphicon glyphicon-comment"></span>Comment
                                                        </button>
                                                        <a href="${context}/getComment/${sense.id}" class="btn btn-primary btn-show-comment"><span class="glyphicon glyphicon-comment"></span>Show Comments</a>
                                                    </div>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>   
                                        <hr>
                                    </div>
                                    <span>
                                        <button type="button" class="btn btn-primary btn-add-sense" data-toggle="modal" data-target="#modal-add-sense" data-verse-id="${verseId}">
                                            <span class="glyphicon glyphicon-plus"></span> Add Sense    
                                        </button>                                
                                        <a href="${context}/getMeaning/${verse.id}" class="btn btn-primary btn-show-sense"><span class="glyphicon glyphicon-eye-open"></span> Show Sense</a>
                                    </span>
                                    <hr>            
                                </div>
                            </c:forEach>
                        </div>

                        <br>
                        <div class="container">
                            <c:set var="limit" value="${sessionScope.count}"/>  
                            <c:forEach var="i" begin="1" end="${limit/3}">        
                                &nbsp;    <a href="${pageContext.request.contextPath}/getCharacterWiseContents/${sessionScope.s}/${i}">${i}</a>  &nbsp; 
                            </c:forEach> 
                        </div>
                </section>

            </div>                      
        </div>
        <!-- Modal for taking Comments from users -->
        <div id="modal-add-comment" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Add Comment to the verse</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="frmAddComment" class="form-horizontal" action='${context}/addComment/${senseId}' method="POST">
                        <div class="modal-body">
                            <div class="control-group">
                                <label class="control-label"  for="username">Name</label>
                                <div class="controls">
                                    <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"  for="username">comment</label>
                                <div class="controls">
                                    <input type="text" id="comment" name="comment" placeholder="" class="input-xlarge">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" value="Add Comment" class="btn btn-primary"></input>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>  


        <!-- Modal for taking sense of verses from users -->
        <div id="modal-add-sense" class="modal fade myclass1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Add Sense to the verse</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="frmAddSense" class="form-horizontal" action='${context}/addMeaning/${verseId}' method="POST">
                        <div class="modal-body">

                            <div class="control-group">
                                <label class="control-label"  for="username">Name</label>
                                <div class="controls">
                                    <input type="text" id="username" name="username" placeholder="" class="form-control">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="meaning">Sense</label>
                                <div class="controls">
                                    <textarea id="meaning" name="meaning" placeholder="" class="form-control" rows="10"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" value="Add Sense" class="btn btn-primary"></input>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="pages/inc/footer.jsp" %>
        <script>
            $(document).ready(function(){
               $(".btn-add-sense").click(function(e){
                  var context = "${context}";
                  var verseId = e.currentTarget.getAttribute("data-verse-id");
                  $("#frmAddSense").attr("action", context+"/addMeaning/"+verseId);
               });
            });
            
              $(document).ready(function(){
               $(".btn-add-comment").click(function(e){
                  var context = "${context}";
                  var senseId = e.currentTarget.getAttribute("data-sense-id");
                  $("#frmAddComment").attr("action", context+"/addComment/"+verseId);
               });
            });
            
             $(document).ready(function(){
               $(".btn-show-sense").click(function(){
                  $("#sensediv").show();
                 
               });
            });
            
        </script>
         
          
        
    </body>
</html>


