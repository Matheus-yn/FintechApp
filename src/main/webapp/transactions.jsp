<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fintech - Transações</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Transações da Última Semana</h1>
        <table>
            <tr>
                <th>Quantia</th>
                <th>Data</th>
                <th>Horário</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                    <td>${transaction.time}</td>
                </tr>
            </c:forEach>
        </table>
        <button onclick="window.location.href='newTransaction.jsp'">Nova Transação</button>
    </div>
</body>
</html>