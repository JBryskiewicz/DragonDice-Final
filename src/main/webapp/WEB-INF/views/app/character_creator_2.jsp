<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>

        <!-- Character Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="stats" action="/app/character-creator-step-2-result" method="post">

                            <p>HINT: Rules say that you can invest max 27 points into ability score from point buy.
                            Every point bought from 14 score upwards costs 2 instead of 1.</p>

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
                                            <select name="level" aria-label="Floating label select example" id="lvl-condition" onchange="LevelSelectorController()">
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
                            <input type="hidden" name="id" value="${charId}">
                        <button type="submit" class="btn btn-primary">Next</button>
                            <a style="color: #d41414">${errorMsg}</a>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Character Creator End -->

<%@include file="_footer.jsp" %>