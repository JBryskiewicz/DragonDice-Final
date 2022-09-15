<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>

        <!-- Character Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form modelAttribute="increase" action="/app/character-createor-step-4-result" method="post">

                            <p>HINT: According to rules for each Ability Score Increase level, you can either
                                choose score increase or feat. You cannot choose both of them.</p>

                            <c:choose>

                            <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 4 - START --%>

                            <c:when test="${lvl >= 4}">

                            <div id="lvl-4">
                                <h5>4th level feature</h5>
                            <%-- Button for change none -> feat -> score increase --%>
                                <button type="button" id="lvl-4-feat-carouse" class="btn btn-primary" data-toggle="button"
                                        aria-pressed="false" autocomplete="off" onclick="handleFeatsButton(this, '4')">None</button>
                            <%-- SELECTOR FOR FEAT --%>
                                <div id="lvl-4-feat" style="display: none">
                                    <div class="form-floating mb-3">
                                        <select name="featFour" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                            <option selected>-----------</option>
                                            <c:forEach items="${feats}" var="feat">
                                            <option value="${feat.id}">${feat.name}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="floatingSelect">Select a Feat</label>
                                    </div>
                                </div>
                            <%-- SELECTOR FOR SCORE INCREASE --%>
                                <div id="lvl-4-increase" style="display: none">
                                    <div class="bg-secondary rounded h-100 p-4"><h6>Ability Score Increase</h6>
                                        <table class="table table-borderless">
                                            <thead>
                                            <tr>
                                                <th scope="col">STR</th>
                                                <th scope="col">DEX</th>
                                                <th scope="col">CON</th>
                                                <th scope="col">INT</th>
                                                <th scope="col">WIS</th>
                                                <th scope="col">CHA</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="strIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                            <option value="2">+2</option>
                                                        </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="dexIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                            <option value="2">+2</option>
                                                         </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="conIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                            <option value="2">+2</option>
                                                        </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="intIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                              <option value="2">+2</option>
                                                       </select>
                                                     </div>
                                                </td>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="wisIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                            <option value="2">+2</option>
                                                        </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-floating mb-3">
                                                        <select name="chaIncrease" aria-label="Floating label select example">
                                                            <option selected value="0">0</option>
                                                            <option value="1">+1</option>
                                                            <option value="2">+2</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            </c:when>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 4 - END --%>

                        <%-- HERE WILL BE IMPLEMENTED LEVEL 6 FEATURE FOR FIGHTER --%>


                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 8 - START --%>

                            <c:when test="${lvl >= 8}">



                            </c:when>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 8 - END --%>


                        <%-- HERE WILL BE IMPLEMENTED LEVEL 10 FEATURE FOR ROGUE --%>


                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 12 - START --%>

                            <c:when test="${lvl >= 12}">



                            </c:when>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 12 - END --%>


                        <%-- HERE WILL BE IMPLEMENTED LEVEL 14 FEATURE FOR FIGHTER --%>


                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 16 - START --%>

                            <c:when test="${lvl >= 16}">



                            </c:when>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 16 - END --%>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 19 - START --%>

                            <c:when test="${lvl >= 19}">



                            </c:when>

                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 19 - END --%>

                            </c:choose>

                        <input type="hidden" name="id" value="${charId}">
                        <button type="submit" class="btn btn-primary">Next</button>
                        <a style="color: #d41414">${errorMsg}</a>

                        </form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Character Creator End -->

<%@include file="_footer.jsp" %>