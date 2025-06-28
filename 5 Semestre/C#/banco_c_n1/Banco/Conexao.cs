using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace banco_c_n1.Banco
{
    internal class Conexao
    {
        public static MySqlConnection Getconexao()
        {
            // Inicia um bloco try para tratamento de erros
            try
            {
                // Definir os parâmetros da conexão: servidor, porta, banco de dados, usuário e senha
                MySqlConnection con = new MySqlConnection("datasorce=localhost; port=3306; " +
                    "database=aula_sextou_n1; username=root; password='';");

                // Retornar o objeto criado
                return con;
            }
            // Caso ocorra alguma exceção no try
            catch (Exception ex)
            {
                // Em caso de erro da criação da conexão ele retorna null
                return null;
            }
        }
    }
}
