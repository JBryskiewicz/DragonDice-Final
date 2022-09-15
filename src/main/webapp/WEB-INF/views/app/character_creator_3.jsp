<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>

        <!-- Character Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="userCharacter" action="/app/character-creator-result" method="post">

                            <p>NOTE: To create new character, name and age fields must be filled, additionally min age is 1.
                                Anything else can be added later in edit window.</p>
                            <div class="bg-secondary rounded h-100 p-4"><h6>Select Ability Score</h6>
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
                                        <td><div class="form-floating mb-3">
                                            <select name="strAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="dexAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="conAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="intAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="wisAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="chaAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">
                                        <h6>Level</h6>
                                        <div class="form-floating mb-3">
                                            <select name="charLevel" aria-label="Floating label select example" id="lvl-condition" onchange="LevelSelectorController()">
                                                <option selected value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="4">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                                <option value="11">11</option>
                                                <option value="12">12</option>
                                                <option value="13">13</option>
                                                <option value="14">14</option>
                                                <option value="15">15</option>
                                                <option value="16">16</option>
                                                <option value="17">17</option>
                                                <option value="18">18</option>
                                                <option value="19">19</option>
                                                <option value="20">20</option>
                                            </select>
                                        </div>
                                    </th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                            </table>
                            <div class="form-floating mb-3">
                                <select name="race" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${Race}" var="race">
                                    <option value="${race.id}">${race.raceName}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your Race</label>
                            </div>

                            <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 4 - START --%>
                            <div id="lvl-4" style="display: none">

                                <button type="button" id="lvl-4-feat-carouse" class="btn btn-primary" data-toggle="button"
                                        aria-pressed="false" autocomplete="off" onclick="handleFeatsButton(this, '4')">None</button>
                                <div id="lvl-4-feat" style="display: none">
                                    <div class="form-floating mb-3">
                                        <select name="featFour" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                            <option selected></option>
                                            <c:forEach items="${Feats}" var="feat">
                                            <option value="${feat.id}">${feat.featName}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="floatingSelect">Select a Feat</label>
                                    </div>
                                </div>

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
                                        <td><div class="form-floating mb-3">
                                            <select name="strIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="dexIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="conIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="intIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="wisIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="chaIncrease" aria-label="Floating label select example">
                                                <option selected value="0">0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                        </div>
                        <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 4 - END --%>

                            <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 8 - START --%>
                            <div id="lvl-8" style="display: none">

                                <button type="button" id="lvl-8-feat-carouse" class="btn btn-primary" data-toggle="button"
                                        aria-pressed="false" autocomplete="off" onclick="handleFeatsButton(this, '8')">None</button>
                                <div id="lvl-8-feat" style="display: none">
                                    <div class="form-floating mb-3">
                                        <select name="featEight" class="form-select" id="floatingSelect"
                                                aria-label="Floating label select example">
                                            <option selected></option>
                                            <c:forEach items="${Feats}" var="feat">
                                                <option value="${feat.id}">${feat.featName}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="floatingSelect">Select a Feat</label>
                                    </div>
                                </div>

                                <div id="lvl-8-increase" style="display: none">
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
                                                <td><div class="form-floating mb-3">
                                                    <select name="strIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                                <td><div class="form-floating mb-3">
                                                    <select name="dexIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                                <td><div class="form-floating mb-3">
                                                    <select name="conIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                                <td><div class="form-floating mb-3">
                                                    <select name="intIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                                <td><div class="form-floating mb-3">
                                                    <select name="wisIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                                <td><div class="form-floating mb-3">
                                                    <select name="chaIncrease" aria-label="Floating label select example">
                                                        <option selected value="0">0</option>
                                                        <option value="1">+1</option>
                                                        <option value="2">+2</option>
                                                    </select>
                                                </div></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <%-- THIS PART SHOULD BE HIDDEN UNTIL LEVEL 8 - END --%>

                            <input type="hidden" name="id" value="${userCharacter.id}">
                            <input type="hidden" name="userId" value="${user}">
                            <input type="hidden" name="proficiency" value="3">
                            <input type="hidden" name="expertise" value="6">
                        <button type="submit" class="btn btn-primary">Create</button>
                            <a style="color: #d41414">${errorMsg}</a>
                    </div>
                </div>
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="form-floating mb-3">
                                <!-- !character name input! -->
                                <form:input path="charName" cssClass="form-control" id="floatingInput" placeholder="Character Name"/>
                                <form:errors path="charName" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Character Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !character age input! -->
                                <form:input type="number" path="charAge" cssClass="form-control" id="floatingInput" placeholder="Character Age"/>
                                <form:errors path="charAge" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Character Age</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !character backstory input! -->
                                <form:textarea path="backstory" cssClass="form-control" placeholder="Backstory"
                                               id="floatingTextarea" cssStyle="height: 300px;"></form:textarea>
                                <form:errors path="backstory" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingTextarea">Backstory</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select name="charAlignment" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <option value="Lawful Good">Lawful Good</option>
                                    <option value="Lawful Neutral">Lawful Neutral</option>
                                    <option value="Lawful Evil">Lawful Evil</option>
                                    <option value="Neutral Good">Neutral Good</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Neutral Evil">Neutral Evil</option>
                                    <option value="Chaotic Good">Chaotic Good</option>
                                    <option value="Chaotic Neutral">Chaotic Neutral</option>
                                    <option value="Chaotic Evil">Chaotic Evil</option>
                                </select>
                                <label for="floatingSelect">Select your alignment</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select name="background" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${Background}" var="bGround">
                                    <option value="${bGround.id}">${bGround.backgroundName}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your background</label>
                            </div>
                        </div>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Character Creator End -->

<%@include file="_footer.jsp" %>