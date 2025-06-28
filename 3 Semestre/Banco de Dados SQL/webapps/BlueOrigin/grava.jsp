<%@page language="java" import="java.sql.*" %>
<%
    //cria as variaveis para armazenar as informações 
    //digitadas pelo usuário

    String vnome= request.getParameter("txtNome"); //variavel nome
    String vemail= request.getParameter("txtEmail"); //variavel email
    String vlink= request.getParameter("txtlink"); //variavel link
    String vdataniver= request.getParameter("txtDate"); //variavel data de aniv
    String vgenero= request.getParameter("txtGenero"); // variavel genero
    String vnacionalidade= request.getParameter("txtNacio"); //variavel nacionalidade
    String vtelefone= request.getParameter("txtTelefone"); //variavel telefone
    String vendereco= request.getParameter("txtEndereco"); //variavel endereco
    String vassentos = request.getParameter("assentos"); //variavel assentos
    String vnometitular= request.getParameter("txtTitular"); //variavel nome do titular
    String vcpf= request.getParameter("txtCpf"); //variavel cpf
    String vnumcartao= request.getParameter("txtNumcartao"); //variavel numero cartao
    String vvenccartao= request.getParameter("txtVenccartao"); //variavel vencimento cartao
    String vcvv= request.getParameter("txtCvv"); //variavel cvv
    String vsenha= request.getParameter("txtSenha"); //variavel senha    

    //variaveis para o banco de dados
    String banco    = "web" ;
    String endereco = "jdbc:mysql://localhost:3306/"+banco;
    String usuario  = "root";
    String senha    = "" ;

    //Variavel para o Driver
    String driver = "com.mysql.jdbc.Driver";

    //Carregar o driver na memória
    Class.forName( driver );

    //Cria a variavel para conectar com o banco de dados
    Connection conexao;

    //Abrir a conexao com o banco de dados
    conexao = DriverManager.getConnection(endereco, usuario, senha);

    //Cria a variavel sql como o comando INSERT
    String sql = "INSERT INTO usuarios (nome, datanasc, email, link, genero, nacionalidade, telefone, endereco, assento, titularcartao, cpf, numerocartao, venccartao, cvvcartao, senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement stm = conexao.prepareStatement(sql);
    stm.setString( 1 , vnome);
    stm.setString( 2 , vdataniver );
    stm.setString( 3 , vemail );
    stm.setString( 4 , vlink);
    stm.setString( 5 , vgenero);
    stm.setString( 6 , vnacionalidade);
    stm.setString( 7 , vtelefone);
    stm.setString( 8 , vendereco);
    stm.setString( 9 , vassentos);
    stm.setString( 10 , vnometitular);
    stm.setString( 11 , vcpf);
    stm.setString( 12 , vnumcartao);
    stm.setString( 13 , vvenccartao);
    stm.setString( 14 , vcvv);
    stm.setString(15 , vsenha);
        
    stm.execute();
    stm.close();
    out.print("Dados gravados com sucesso!!!");
    out.print("<br><br>");
    out.print("<a href='PaginaInicial.html'>Voltar</a>");
%>