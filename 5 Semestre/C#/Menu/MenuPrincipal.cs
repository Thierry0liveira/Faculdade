namespace Menu
{
    public partial class MenuPrincipal : Form
    {
        public MenuPrincipal()
        {
            InitializeComponent();
        }

        private void mnuCadSair_Click(object sender, EventArgs e)
        {
            // Sair do Programa
            Application.Exit();
        }

        private void funcionáriosToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void mnuCadFun_Click(object sender, EventArgs e)
        {
            // Criando um objeto para carregar a interface gráfica
            Funcionarios telaFun = new Funcionarios();

            //trava a tela showDialog se for só Show da pra mexer na tela anterior
            telaFun.ShowDialog();
        }
    }
}
