<%@page language="java" import="java.sql.*" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Consulta Blue Origin</title>
    <style>
        tr:nth-child(even) {
            background-color: lightgray;
        }
        tr:hover{
            background-color: #6495ED;
        }
        h2{
            align-items: center;
            text-align: center;
        }
        table{
            text-align: center;
            justify-content: center;
            align-items: center;
            vertical-align: center;
            position:absolute;
            left:25vh;            
        }
        
    </style>
</head>
<body>
    <div class="container">
        <div class="cabecalho"> 
            <a href="PaginaInicial.html" class="home">Blue Origin </br> Para o beneficio da Terra</a>
        </div>
        <div class="conteudo">    
            <%
                //variaveis para o banco de dados
                String banco    = "web" ;
                String endereco = "jdbc:mysql://localhost:3306/"+banco;
                String usuario  = "root";
                String senha    = "" ;

                //Variavel para o Driver
                String driver = "com.mysql.jdbc.Driver" ;

                //Carregar o driver na memória
                Class.forName( driver ) ;

                //Cria a variavel para conectar com o banco de dados
                Connection conexao ;

                //Abrir a conexao com o banco de dados
                conexao = DriverManager.getConnection(endereco, usuario, senha) ;

                String sql = "SELECT * FROM usuarios" ;

                //Cria o statement para executar o comando no banco
                PreparedStatement stm = conexao.prepareStatement(sql) ;

                ResultSet  dados = stm.executeQuery() ;

                out.print("<h2> Tabela de Cadastros</h2>");
                out.print("</br>");
                out.print("</br>");
                out.print("<table border=1 width='500'>");
                out.print("<tr>") ;
                    out.print("<th>Codigo</th>") ;
                    out.print("<th>Nome</th>") ;
                    out.print("<th>Data Nasc.</th>") ;
                    out.print("<th>Email</th>") ;
                    out.print("<th>Link</th>") ;
                    out.print("<th>Genero</th>") ;
                    out.print("<th>Nacionalidade</th>") ;
                    out.print("<th>Telefone</th>") ;
                    out.print("<th>Endereco</th>") ;
                    out.print("<th>Assento</th>") ;
                    out.print("<th>Titular Cartao</th>") ;
                    out.print("<th>CPF</th>") ;
                    out.print("<th>Numero do Cartao</th>") ;
                    out.print("<th>Vencimento</th>") ;
                    out.print("<th>CVV</th>") ;
                    out.print("<th>Senha</th>") ;

                out.print("</tr>") ;
                while( dados.next() ) 
                {
                    out.print("<tr>") ;
                        out.print("<td>") ;
                            out.print( dados.getString("codigo") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("nome") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("datanasc") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("email") ) ;
                        out.print("</td>") ;                
                        
                        out.print("<td>") ;
                            out.print( dados.getString("link") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("genero") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("nacionalidade") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("telefone") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("endereco") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("assento") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("titularcartao") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("cpf") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("numerocartao") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("venccartao") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("cvvcartao") ) ;
                        out.print("</td>") ;

                        out.print("<td>") ;
                            out.print( dados.getString("senha") ) ;
                        out.print("</td>") ;

                    out.print("</tr>") ;

                }

                out.print("</table>") ;
            %>
        </div>
        <div class="rodape"></div>
    </div>
</body>
</html>
