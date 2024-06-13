<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nova Transação</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>Cadastrar Nova Transação</h1>
    <form action="transactions" method="post">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="amount">Quantia:</label>
        <input type="number" id="amount" name="amount" required><br>
        <label for="type">Tipo:</label>
        <input type="radio" id="entrada" name="type" value="Entrada" required> Entrada
        <input type="radio" id="saida" name="type" value="Saída" required> Saída<br>
        <label for="date">Data:</label>
        <input type="date" id="date" name="date" required><br>
        <label for="time">Horário:</label>
        <input type="time" id="time" name="time" required><br>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>