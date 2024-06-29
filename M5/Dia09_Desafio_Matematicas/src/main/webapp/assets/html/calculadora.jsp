<%@ page import="cl.praxis.models.Calculator" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  Calculator calculator = new Calculator();
  String strResponse = (String) request.getAttribute("strResponse");
%>

<h1>Calculadora</h1>

<form method="get" action="calculator-servlet">
  <fieldset>
    <input type="number" name="number1" placeholder="Número 1" required/>
    <input type="number" name="number2" placeholder="Número 2" required/>

    <select name="operation" aria-label="Select your favorite cuisine..." required>
      <option selected disabled value="">
        Seleccióne una Operación
      </option>
      <% for (Map.Entry<Integer, String> operation : calculator.getOperations().entrySet()) { %>
      <option value="<%= operation.getKey() %>"><%= operation.getValue() %></option>
      <% } %>
    </select>
  </fieldset>

  <input type="submit" value="Calcular"/>
</form>

<article>
  <h2>Resultado</h2>
  <p><%= strResponse != null ? strResponse : "" %></p>
</article>