<%@page language="java" import="java.sql.*" %>

<%

    String vemail = request.getParameter("txtEmail");
    String vsenha = request.getParameter("txtSenha");

    // Variaveis para o banco de dados
    String banco    = "web" ;
    String endereco = "jdbc:mysql://localhost:3306/" + banco ;
    String usuario  = "root";
    String senha    = "" ;
  
    String driver   = "com.mysql.jdbc.Driver" ;

    //Carregar o driver na memória
    Class.forName( driver ) ;

    //Cria a variavel para conectar com banco
    Connection conexao ;

    // Abrir a conexao com o banco
    conexao = DriverManager.getConnection(endereco, usuario, senha) ;

    String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?";

    // Cria o statement para executar o camando no banco
    PreparedStatement stm = conexao.prepareStatement( sql );

    stm.setString(1, vemail) ;
    stm.setString(2, vsenha) ;

    ResultSet dados =  stm.executeQuery() ;

    if(dados.next())
    {
       session.setAttribute( "usuario"  ,  dados.getString("nome")  ) ;
       response.sendRedirect("consulta.jsp");
    }
    else
    {
        out.print("Login incorreto");
    }

%>

