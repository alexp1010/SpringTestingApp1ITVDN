<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
   <body>
      <form:form id="user-form" action="/SpringMVC/pass-data" method="post" modelAttribute="user">
         <form:input path="name"/>
         <input type="submit" value="pass data"></input>
      </form:form>
   </body>
</html>