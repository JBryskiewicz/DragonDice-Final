<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>


        <!-- Character Window Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <c:forEach items="${characters}" var="character">
                <div class="col-sm-12 col-md-6 col-xl-4">
                    <div class="h-100 bg-secondary rounded p-4">
                        <div class="d-flex align-items-center border-bottom py-3">
                            <img class="rounded-circle flex-shrink-0" src="/resources/img/gix.png" alt="" style="width: 100px; height: 100px;">
                            <div class="w-100 ms-3">
                                <div class="d-flex w-100 justify-content-between">
                                    <h6 class="mb-0">${character.name}</h6>
                                </div>
                                <span>Level: ${character.stats.level}</span><br/>
                                <span>Race: ${character.race.name}</span><br/>
                                <span>Class: Rogue / Scout</span>

                                <div class="d-flex align-items-center justify-content-between mb-2">
                                    <a href="/app/character-sheet/${character.id}">view</a>
                                    <a href="/app/character-editor/${character.id}">edit</a>
                                    <a href="/app/character-delete/${character.id}">delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

            <!-- Character Window End -->

<%@include file="_footer.jsp" %>