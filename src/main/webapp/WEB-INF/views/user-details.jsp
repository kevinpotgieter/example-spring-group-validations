<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" charset="utf-8">

    function submitAddUserWithFullValidation(){
        document.forms['user-details'].action = 'add-user-full.html';
        document.forms['user-details'].submit();
        return true;
    }

    function submitAddUserWithPartialValidation(){
        document.forms['user-details'].action = 'add-user-partial.html';
        document.forms['user-details'].submit();
        return true;
    }
</script>

<form:form id="user-details" action="add-user-full.html" modelAttribute="userDTO">
     <spring:hasBindErrors name="userDTO">
         <c:forEach items="${errors.allErrors}" var="error">
            <span style="color: red;">${error.defaultMessage}</span> <br/>
         </c:forEach>

     </spring:hasBindErrors>
    <br/>

    <label>Username: </label><form:input path="username"/><br/>
    <label>Password: </label><form:input path="password"/><br/>
    <label>Confirm Password: </label><form:input path="confirmPassword"/><br/>

    <label>Email: </label><form:input path="emailAddress"/><br/>
    <label>Confirm Email: </label><form:input path="confirmEmailAddress"/><br/>

    <input type="button" value="Add with full Validation" onclick="javascript:submitAddUserWithFullValidation();"/>
    <input type="button" value="Add with partial Validation" onclick="javascript:submitAddUserWithPartialValidation();"/>
    </form:form>