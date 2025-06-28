namespace Assunto_4_N1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btSoma_Click(object sender, EventArgs e)
        {
            //Criar as vari�veis
            float n1, n2, res = 0;

            //Atribuir o valor digitado para a vari�vel correspondente convertendo de TEXTO para float (NUMERO)
            if(float.TryParse(txtN1.Text, out n1) && float.TryParse(txtN2.Text, out n2))
            {                
                //Processamento - Soma
                res = n1 + n2;

                //Exibir o resultado da Soma no objeto txtRes
                txtRes.Text = res.ToString();
            }
            else
            {
                //Mensagem
                MessageBox.Show("Voc� est� digitando um valor inv�lido!");
         
            }            
        }

        private void btSub_Click(object sender, EventArgs e)
        {
            //Criar as vari�veis
            float n1, n2, res = 0;

            //Atribuir o valor digitado para a vari�vel correspondente convertendo de TEXTO para float (NUMERO)
            n1 = float.Parse(txtN1.Text);
            n2 = float.Parse(txtN2.Text);

            //Processamento - Subtra��o
            res = n1 - n2;

            //Exibir o resultado da Subtra��o no objeto txtRes
            txtRes.Text = res.ToString();
        }

        private void btMult_Click(object sender, EventArgs e)
        {
            //Criar as vari�veis
            float n1, n2, res = 0;

            //Atribuir o valor digitado para a vari�vel correspondente convertendo de TEXTO para float (NUMERO)
            n1 = float.Parse(txtN1.Text);
            n2 = float.Parse(txtN2.Text);

            //Processamento - Multiplica��o
            res = n1 * n2;

            //Exibir o resultado da Multiplica��o no objeto txtRes
            txtRes.Text = res.ToString();
        }

        private void btDiv_Click(object sender, EventArgs e)
        {
            //Criar as vari�veis
            float n1, n2, res = 0;

            //Atribuir o valor digitado para a vari�vel correspondente convertendo de TEXTO para float (NUMERO)
            n1 = float.Parse(txtN1.Text);
            n2 = float.Parse(txtN2.Text);

            //Processamento - Divis�o
            res = n1 / n2;

            //Exibir o resultado da Divis�o no objeto txtRes
            txtRes.Text = res.ToString();
        }

        private void btReset_Click(object sender, EventArgs e)
        {
            //Limpa os campos
            txtN1.Text = "";
            txtN2.Text = "";
            txtRes.Text = "";
        }
    }
}
