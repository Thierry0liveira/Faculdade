<?php
      // Arquivo de "Regras de negócio": 
      // MODELO -> Operações para ter acesso ao BD e realizar CRUD !!

     /* criarmos uma classe para ter acesso ao BD e criarmos dois métodos  de consulta:
       1) consultar um determinado o registro através de um parâmetro "id"     
       2) consultar todos os registros sem parâmetro "id"   
       3) Inserir dados ou registros ao Banco de dados   
       4) Excluir dados ou registro através o parâmetro "id" 
       5) Alterar dados ou registro através o parâmetro "id"*/   
      
      //inserir o arquivo 'config.php'
      require_once 'config.php' ; // ou include 'config.php'
      
      /* Criamos uma class chamar "Solidario"  */
      class Solidario 
      {
        //1) um método para fazer consulta atráves do parâmetro $id
        public static function select(int $id)
        {
            //Criar duas variáveis para tabela e primeira coluna
            $tabela = "voluntarios"; //variável para nome da tabela
            $coluna = "id_voluntario"; //variável para chave primaria            
            // Conectando com o banco de dados através da classe (objeto) PDO
            // pegando as informações do config.php (variáveis globais)
            $connPdo = new PDO(dbDrive.':host='.dbHost.'; dbname='.dbName, dbUser, dbPass);            
            // Usando comando sql que será executado no banco de dados para consultar um 
            // determinado registro 
            $sql = "select * from $tabela where $coluna = :id" ;            
            //preparando o comando Select do SQL para ser executado usando método prepare()
            $stmt = $connPdo->prepare($sql); 
            //configurando (ou mapear) o parametro de busca
            $stmt->bindValue(':id' , $id) ;           
            // Executando o comando select do SQL no banco de dados
            $stmt->execute() ; 
                      
            if ($stmt->rowCount() > 0){// se houve retorno de dados (Registros)    
                // retornando os dados do banco de dados através do método fetch(...)
                return $stmt->fetch(PDO::FETCH_ASSOC) ;                
            }else{// se não houve retorno de dados, jogar no classe Exception (erro)
                  // e mostrar a mensagem "Sem registro do aluno"                
                throw new Exception("Sem registro do Voluntario");
            }
        }
        //2) um método para fazer consulta de todos os registros sem parâmetro $id
        public static function selectAll()
        {            
            $tabela = "voluntarios"; //variável para nome da tabela                
            $connPdo = new PDO(dbDrive.':host='.dbHost.'; dbname='.dbName, dbUser, dbPass);  
            $sql = "select * from $tabela" ;  
            $stmt = $connPdo->prepare($sql);             
            $stmt->execute() ; 
                      
            if ($stmt->rowCount() > 0){// se houve retorno de dados (Registros)    
                // retornando os dados do banco de dados através do método fetchAll(...)
                return $stmt->fetchAll(PDO::FETCH_ASSOC) ;                
            }else{// se não houve retorno de dados, jogar no classe Exception (erro)
                  // e mostrar a mensagem "Sem registro do aluno"                
                throw new Exception("Sem registro do Voluntario");
            }
        }
        //3) um método para fazer inclusao de dados no Banco de dados
        public static function insert($dados)
        {
            $tabela = "voluntarios"; //variável para nome da tabela   
            //temos a conexao de banco de dados             
            $connPdo = new PDO(dbDrive.':host='.dbHost.'; dbname='.dbName, dbUser, dbPass); 
            //comando sql para inserção 
            $sql = "insert into $tabela (nome,ocupacao,horario_disponivel,telefone,email) values (:nome, :ocupacao, :horario_disponivel, :telefone, :email )";
            $stmt = $connPdo->prepare($sql); 
            //Mapeamento de parâmetros com campos da tabela            
            $stmt->bindValue(':nome' , $dados['nome']) ;
            $stmt->bindValue(':ocupacao' , $dados['ocupacao']) ;
            $stmt->bindValue(':horario_disponivel' , $dados['horario_disponivel']) ;
            $stmt->bindValue(':telefone' , $dados['telefone']) ;
            $stmt->bindValue(':email' , $dados['email']) ;
            
            
            //execução 
            $stmt->execute() ; 

            if ($stmt->rowCount() > 0){
               return "Dados cadastrados com sucesso!" ;
            }
            else{
              throw new Exception("Erro ao inserir os dados!");
            }
        }
        //4) um método para fazer exclusão de um determiando dado no Banco de dados
        public static function delete($id)
        {
            $tabela = "voluntarios"; //variável para nome da tabela 
            $coluna = "id_voluntario"; //variável para chave primaria   
            //temos a conexao de banco de dados             
            $connPdo = new PDO(dbDrive.':host='.dbHost.'; dbname='.dbName, dbUser, dbPass); 
            //comando sql para deletar um determinado registro 
            $sql = "delete from $tabela where $coluna = :id";
            $stmt = $connPdo->prepare($sql); 
            //Mapeamento de parâmetros com campos da tabela
            $stmt->bindValue(':id', $id) ;            
            //execução 
            $stmt->execute() ; 

            if ($stmt->rowCount() > 0){
               return "Dados excluidos com sucesso!" ;
            }
            else{
              throw new Exception("Erro ao excluir os dados!");
            }
        }
        //5) um método para fazer a alteração de dados no Banco de dados
        public static function alterar($id,$dados)
        {
          $tabela = "voluntarios"; //variável para nome da tabela 
          $coluna = "id_voluntario"; //variável para chave primaria    
            //temos a conexao de banco de dados             
            $connPdo = new PDO(dbDrive.':host='.dbHost.'; dbname='.dbName, dbUser, dbPass); 
            //comando sql para alteração 
            $sql = "update $tabela 
            set nome=:nome,
            ocupacao=:ocupacao,
            horario_disponivel=:horario_disponivel,
            telefone=:telefone,
            email=:email where $coluna=:id";
            $stmt = $connPdo->prepare($sql); 
            //Mapeamento de parâmetros com campos da tabela
            $stmt->bindValue(':id' , $id) ;
            $stmt->bindValue(':nome' , $dados['nome']) ;
            $stmt->bindValue(':ocupacao' , $dados['ocupacao']) ;
            $stmt->bindValue(':horario_disponivel' , $dados['horario_disponivel']) ;
            $stmt->bindValue(':telefone' , $dados['telefone']) ;
            $stmt->bindValue(':email' , $dados['email']) ;
            //execução 
            $stmt->execute() ; 

            if ($stmt->rowCount() > 0){
               return "Dados alterados com sucesso!" ;
            }
            else{
              throw new Exception("Erro ao alterar os dados!");
            }
        }               
      }
?>