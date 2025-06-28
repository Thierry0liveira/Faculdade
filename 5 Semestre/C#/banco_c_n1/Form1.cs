using MySql.Data.MySqlClient;

namespace banco_c_n1
{
    public partial class Form1 : Form
    {
        // Declarar uma variável para armazenar a conexão com o banco de dados
        public MySqlConnection conexao;

        // Define um método para limpar os campos
        public void LimparDados()
        {
            txtCodigo.Text = "";
            txtNome.Text = "";
            txtEmail.Text = "";
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void btNovo_Click(object sender, EventArgs e)
        {
            // Verificar se o texto do btNovo == "Novo"
            if (btNovo.Text == "Novo")
            {
                // Habilitar o btSalvar
                btSalvar.Enabled = true;

                // Alterar o texto do btNovo para "Cancelar"
                btNovo.Text = "Cancelar";

                // Desabilitar o txtCodigo
                txtCodigo.Enabled = false;

                LimparDados();
            }
            else
            {
                // Desabilitar o btSalvar
                btSalvar.Enabled = false;

                // Alterar o texto do btNovo para "Novo"
                btNovo.Text = "Novo";

                // Habilitar o txtCodigo
                txtCodigo.Enabled = true;

                LimparDados();
            }

        }

        private void btSalvar_Click(object sender, EventArgs e)
        {
            try 
            {
                // Criando uma variável e salvando o texto dos campos nela em maiusculo
                String nome = txtNome.Text.ToUpper();
                String email = txtEmail.Text.ToUpper();

                // Obtendo uma instância de conexão com o banco de dados
                conexao = Banco.Conexao.Getconexao();

                // Abre a conexào com o banco de dados
                conexao.Open();

                //Criar um objeto para executar os comandos em SQL
                MySqlCommand comando = new MySqlCommand();

                comando.Connection = conexao;
                comando.CommandText = "INSERT INTO funcionarios (nome, email)" + "VALUES (@nome, @email)";
                comando.Parameters.AddWithValue("@nome", nome);
                comando.Parameters.AddWithValue("@email", email);

                // Prepara o comando SQL para otimizar as consultas repetidas
                comando.Prepare();
                // Executando o comando
                comando.ExecuteNonQuery();

                LimparDados();

                MessageBox.Show("Dados Gravados com Sucesso!");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Erro ao Gravar os Dados! \n" + ex.Message);
            }
            finally
            {
                // Fechar a conexão com o Banco de Dados
                conexao.Close();
            }
        }
    }
}
