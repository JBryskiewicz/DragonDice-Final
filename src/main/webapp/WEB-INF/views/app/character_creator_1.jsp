<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>

        <!-- Character Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="character" action="/app/character-creator-step-1-result" method="post">

                            <p>HINT: To create new character, name and age fields must be filled, additionally min age is 1.
                                Anything else can be added later in edit window.</p>

                            <div class="form-floating mb-3">
                                <!-- !character name input! -->
                                <form:input path="name" cssClass="form-control" id="floatingInput" placeholder="Character Name"/>
                                <form:errors path="name" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Character Name</label>
                            </div>

                            <div class="form-floating mb-3">
                                <!-- !character age input! -->
                                <form:input type="number" path="age" cssClass="form-control" id="floatingInput" placeholder="Character Age"/>
                                <form:errors path="age" cssClass="error" cssStyle="color: #bc1212"/>
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
                                <select name="alignment" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected value="Neutral">Neutral</option>
                                    <option value="Lawful Good">Lawful Good</option>
                                    <option value="Lawful Neutral">Lawful Neutral</option>
                                    <option value="Lawful Evil">Lawful Evil</option>
                                    <option value="Neutral Good">Neutral Good</option>
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
                                    <c:forEach items="${background}" var="b">
                                        <option value="${b.id}">${b.name}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your background</label>
                            </div>

                            <div class="form-floating mb-3">
                                <select name="race" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${race}" var="r">
                                    <option value="${r.id}">${r.name}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your Race</label>
                            </div>

                            <button type="submit" class="btn btn-primary">Next</button>
                            <a style="color: #d41414">${errorMsg}</a>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Character Creator End -->

<%@include file="_footer.jsp" %>