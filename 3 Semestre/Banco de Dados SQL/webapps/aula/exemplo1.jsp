<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <!--A tag a seguir inicia-se a parte JSP-->
    <%
        out.print("<h1>");
        out.print("exemplo - jsp");
        out.print("</h1>");
        out.print("<br>");
        out.print("<h2>");
        out.print("char - caracter");
        out.print("string - texto maiores");
        out.print("byte - 8 bits");
        out.print("short - 16 bits");
        out.print("int - 32 bits");
        out.print("long - 64 bits");
        out.print("float - 32 bits");
        out.print("double - 64 bits");        
        out.print("boolean - true/false");
        out.print("</h2>");
        
        

        string nome = request.getParameter("txtnome");
        out(nome);
    %>
</body>
</html>