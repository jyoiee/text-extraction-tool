



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

        <div class="container">
            <div class="row content ">

                <section class="main-container jumbotron col-lg-12 col-md-12 col-sm-12 col-xs-12" style="min-height: 760px;">
                    <div class="col-sm-12 text-center"> 

                        <div>
                            <!--                            <a href="#" data-toggle="popover" title="first row" data-trigger="click" class="btn btn-default">View</a>-->
                            <c:forEach var="verse" items="${requestScope.verses}">
                                <p><h5 class="tt"> " ${verse.verseContent}  "</h5> &nbsp;  &nbsp; - ${verse.sDetails.name} </p>
                                <br>
                            </c:forEach>      
                        </div>
                        <br>

                        <!--                         shows modal with meaning of word-->
                        <div id="mymodal" class="modal fade" role="dialog" style="color: #101112 ">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content" style="backface-visibility: visible">
                                    <div class="modal-header" style="background-color: #e8e8e8">
<!--                                        <button type="button" class="close" data-dismiss="modal">&times;</button>-->
                                        <h4 class="modal-title" style="color: #613d7c"><b>Selected word :</b> <span id="searched-word"></span></h4>
                                    </div>
                                    <div class="modal-body">
                                        <section>
                                            <table class="table table-bordered table-striped" >
                                                <thead>
                                                    <tr>
                                                        <th style="text-align: center ; "><b><em>Word</em></b></th>
                                                        <th style="text-align: center ; "><b><em>Sandhi Vigraha</em></b></th>
                                                        <th style="text-align: center ; "><b><em>Meaning</em></b></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="meaning-Container">

                                                </tbody>
                                            </table>
                                        </section>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal" style="color: #111 ; border-collapse: collapse ; ">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>


                        <div class="container">
                            <c:set var="limit" value="${sessionScope.Resultcount}"/>
                            <c:forEach var="i" begin="1" end="${limit/5}">
                                &nbsp;    <a href="${pageContext.request.contextPath}/getSubChapterwiseVerses/${sessionScope.SubchapterId}/${i}">${i}</a>  &nbsp; 
                            </c:forEach>
                        </div>
                    </div>
                </section>            
            </div> 

        </div>

        <%@include file="pages/inc/footer.jsp" %>


        <script id="meaning-Table" type="text/template">
            <tr>
            <td>{{=dictionaryEntry}}</td>
            <td>{{=dictionaryEntryWith}}</td>
            <td>{{=meaning}}</td>

            </tr>
        </script>


        <script>
            $('document').ready(function () {

                var context = "${context}";

                function populateData(data) {
                    // logic to show data;

                    var results = data.entry;
                    var n = 2;
                    if (results.length == 0)
                    {
                        console.log("word not found");
                        alert("Sorry !!! Word not found!!!!")
                    }
                    else
                    {
                        $("#mymodal").modal('show');
                        // document.getElementById("searched-word").innerHTML = data.searchedWord;
                        $("#searched-word").empty();
                        $("#searched-word").append(data.searchedWord);
                         $("#meaning-Container").empty();
                        _.each(results, function (result) {
                            var myTemplate = _.template($("#meaning-Table").html());
                            var myCompiledHTML = myTemplate(result);
                            $("#meaning-Container").append(myCompiledHTML);

                        });
                    }
                    return data;
                }

                function get_selection(e) {
                    console.log(e);
                    var txt = '';
                    if (window.getSelection) {
                        txt = window.getSelection();
                    } else if (document.getSelection) {
                        txt = document.getSelection();
                    } else if (document.selection) {
                        txt = document.selection.createRange().text;
                    }

                    $.ajax({
                        url: context + '/search/word?word=' + txt,
                        type: 'GET',
                        dataType: 'json',
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {
                            d = populateData(data);
                            console.log(data);
                            console.log('inside ajax');
                        }
                    });

                }

                $(".tt").dblclick(function (e) {

                    get_selection(e);


                });
            });
        </script>
        <!--for (var i = 0; i < results.length; i++) {
                                    var tr = document.createElement('tr');
                                    var wordCell = document.createElement('td');
                                    var wordCell2 = document.createElement('td');
                                    var wordCell3 = document.createElement('td');
                                    var meaningCell = document.createElement('td');
                                    wordCell.innerHTML = results[i].dictionaryEntry;
                                    wordCell2.innerHTML = results[i].dictionaryEntryWith;
        //                       wordCell3.innerHTML = results[i].etymology;
                                    meaningCell.innerHTML = results[i].meaning;
                                    tr.append(wordCell);
                                    tr.append(wordCell2);
        //                       tr.append(wordCell3);
                                    tr.append(meaningCell);
                                    document.getElementById("meaning").append(tr);
                                }-->


    </body>


</html>