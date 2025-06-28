namespace Menu
{
    partial class MenuPrincipal
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            cadastrarToolStripMenuItem = new ToolStripMenuItem();
            mnuCadFun = new ToolStripMenuItem();
            clientesToolStripMenuItem = new ToolStripMenuItem();
            produtosToolStripMenuItem = new ToolStripMenuItem();
            cadastrarToolStripMenuItem1 = new ToolStripMenuItem();
            entradaToolStripMenuItem = new ToolStripMenuItem();
            saidaToolStripMenuItem = new ToolStripMenuItem();
            mnuCadSair = new ToolStripMenuItem();
            relatóriosToolStripMenuItem = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { cadastrarToolStripMenuItem, relatóriosToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(800, 24);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // cadastrarToolStripMenuItem
            // 
            cadastrarToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { mnuCadFun, clientesToolStripMenuItem, produtosToolStripMenuItem, mnuCadSair });
            cadastrarToolStripMenuItem.Name = "cadastrarToolStripMenuItem";
            cadastrarToolStripMenuItem.Size = new Size(69, 20);
            cadastrarToolStripMenuItem.Text = "Cadastrar";
            // 
            // mnuCadFun
            // 
            mnuCadFun.Image = Properties.Resources.func;
            mnuCadFun.Name = "mnuCadFun";
            mnuCadFun.Size = new Size(180, 22);
            mnuCadFun.Text = "Funcionários";
            mnuCadFun.Click += mnuCadFun_Click;
            // 
            // clientesToolStripMenuItem
            // 
            clientesToolStripMenuItem.Image = Properties.Resources.clientes;
            clientesToolStripMenuItem.Name = "clientesToolStripMenuItem";
            clientesToolStripMenuItem.Size = new Size(180, 22);
            clientesToolStripMenuItem.Text = "Clientes";
            // 
            // produtosToolStripMenuItem
            // 
            produtosToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { cadastrarToolStripMenuItem1, entradaToolStripMenuItem, saidaToolStripMenuItem });
            produtosToolStripMenuItem.Image = Properties.Resources.products;
            produtosToolStripMenuItem.Name = "produtosToolStripMenuItem";
            produtosToolStripMenuItem.Size = new Size(180, 22);
            produtosToolStripMenuItem.Text = "Produtos";
            // 
            // cadastrarToolStripMenuItem1
            // 
            cadastrarToolStripMenuItem1.Image = Properties.Resources.cadastrar;
            cadastrarToolStripMenuItem1.Name = "cadastrarToolStripMenuItem1";
            cadastrarToolStripMenuItem1.Size = new Size(124, 22);
            cadastrarToolStripMenuItem1.Text = "Cadastrar";
            // 
            // entradaToolStripMenuItem
            // 
            entradaToolStripMenuItem.Image = Properties.Resources.add;
            entradaToolStripMenuItem.Name = "entradaToolStripMenuItem";
            entradaToolStripMenuItem.Size = new Size(124, 22);
            entradaToolStripMenuItem.Text = "Entrada";
            // 
            // saidaToolStripMenuItem
            // 
            saidaToolStripMenuItem.Image = Properties.Resources.minuscirclehd_106108;
            saidaToolStripMenuItem.Name = "saidaToolStripMenuItem";
            saidaToolStripMenuItem.Size = new Size(124, 22);
            saidaToolStripMenuItem.Text = "Saida";
            // 
            // mnuCadSair
            // 
            mnuCadSair.Image = Properties.Resources.sair;
            mnuCadSair.Name = "mnuCadSair";
            mnuCadSair.Size = new Size(180, 22);
            mnuCadSair.Text = "Sair";
            mnuCadSair.Click += mnuCadSair_Click;
            // 
            // relatóriosToolStripMenuItem
            // 
            relatóriosToolStripMenuItem.Name = "relatóriosToolStripMenuItem";
            relatóriosToolStripMenuItem.Size = new Size(71, 20);
            relatóriosToolStripMenuItem.Text = "Relatórios";
            // 
            // MenuPrincipal
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Name = "MenuPrincipal";
            Text = "Menu Principal";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem cadastrarToolStripMenuItem;
        private ToolStripMenuItem mnuCadFun;
        private ToolStripMenuItem clientesToolStripMenuItem;
        private ToolStripMenuItem produtosToolStripMenuItem;
        private ToolStripMenuItem cadastrarToolStripMenuItem1;
        private ToolStripMenuItem entradaToolStripMenuItem;
        private ToolStripMenuItem saidaToolStripMenuItem;
        private ToolStripMenuItem mnuCadSair;
        private ToolStripMenuItem relatóriosToolStripMenuItem;
    }
}
