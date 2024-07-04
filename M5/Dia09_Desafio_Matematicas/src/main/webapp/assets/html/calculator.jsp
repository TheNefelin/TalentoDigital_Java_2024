<%@ page import="cl.praxis.services.CalculatorService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="operations" value="<%= new CalculatorService().getOperations().entrySet() %>"/>

<h1>Calculadora</h1>

<form method="get" action="calculator-servlet">
  <fieldset>
    <input type="number" name="number1" placeholder="Número 1" required/>
    <input type="number" name="number2" placeholder="Número 2" required/>

    <select name="operation" aria-label="Select your favorite cuisine..." required>
      <option selected disabled value="">
        Seleccióne una Operación
      </option>
      <c:forEach var="operation" items="${operations}">
        <option value="${operation.key}">${operation.value}</option>
      </c:forEach>
    </select>
  </fieldset>

  <input type="submit" value="Calcular"/>
</form>

<article>
  <h2>Resultado</h2>
  <p><c:out value="${strResponse != null ? strResponse : ''}"/></p>
</article>