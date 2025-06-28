namespace Menu
{
    partial class Funcionarios
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            label8 = new Label();
            label9 = new Label();
            label10 = new Label();
            maskedTextBox1 = new MaskedTextBox();
            maskedTextBox2 = new MaskedTextBox();
            maskedTextBox3 = new MaskedTextBox();
            comboBox1 = new ComboBox();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            label11 = new Label();
            maskedTextBox4 = new MaskedTextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(391, 37);
            label1.Name = "label1";
            label1.Size = new Size(304, 32);
            label1.TabIndex = 0;
            label1.Text = "Cadastro de Funcionários";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(59, 111);
            label2.Name = "label2";
            label2.Size = new Size(48, 25);
            label2.TabIndex = 1;
            label2.Text = "CPF:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(59, 183);
            label3.Name = "label3";
            label3.Size = new Size(67, 25);
            label3.TabIndex = 2;
            label3.Text = "Nome:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(789, 108);
            label4.Name = "label4";
            label4.Size = new Size(186, 25);
            label4.TabIndex = 3;
            label4.Text = "Data de Nascimento:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(53, 237);
            label5.Name = "label5";
            label5.Size = new Size(70, 25);
            label5.TabIndex = 4;
            label5.Text = "E-mail:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(888, 237);
            label6.Name = "label6";
            label6.Size = new Size(87, 25);
            label6.TabIndex = 5;
            label6.Text = "Telefone:";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(59, 344);
            label7.Name = "label7";
            label7.Size = new Size(95, 25);
            label7.TabIndex = 6;
            label7.Text = "Endereço:";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(59, 398);
            label8.Name = "label8";
            label8.Size = new Size(135, 25);
            label8.TabIndex = 7;
            label8.Text = "Complemento:";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(636, 398);
            label9.Name = "label9";
            label9.Size = new Size(75, 25);
            label9.TabIndex = 8;
            label9.Text = "Cidade:";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(919, 398);
            label10.Name = "label10";
            label10.Size = new Size(72, 25);
            label10.TabIndex = 9;
            label10.Text = "Estado:";
            // 
            // maskedTextBox1
            // 
            maskedTextBox1.Location = new Point(113, 103);
            maskedTextBox1.Mask = "000,000,000-00";
            maskedTextBox1.Name = "maskedTextBox1";
            maskedTextBox1.Size = new Size(153, 33);
            maskedTextBox1.TabIndex = 10;
            // 
            // maskedTextBox2
            // 
            maskedTextBox2.Location = new Point(981, 100);
            maskedTextBox2.Mask = "00/00/0000";
            maskedTextBox2.Name = "maskedTextBox2";
            maskedTextBox2.Size = new Size(137, 33);
            maskedTextBox2.TabIndex = 11;
            maskedTextBox2.ValidatingType = typeof(DateTime);
            // 
            // maskedTextBox3
            // 
            maskedTextBox3.Location = new Point(981, 229);
            maskedTextBox3.Mask = "(99) 00000-0000";
            maskedTextBox3.Name = "maskedTextBox3";
            maskedTextBox3.Size = new Size(137, 33);
            maskedTextBox3.TabIndex = 12;
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Items.AddRange(new object[] { "SP", "RJ", "MG", "SC" });
            comboBox1.Location = new Point(997, 390);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(121, 33);
            comboBox1.TabIndex = 13;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(142, 175);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(976, 33);
            textBox1.TabIndex = 14;
            textBox1.Text = "  ";
            // 
            // textBox2
            // 
            textBox2.Location = new Point(129, 229);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(676, 33);
            textBox2.TabIndex = 15;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(171, 336);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(591, 33);
            textBox3.TabIndex = 16;
            // 
            // textBox4
            // 
            textBox4.Location = new Point(200, 390);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(348, 33);
            textBox4.TabIndex = 17;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(717, 390);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(176, 33);
            textBox5.TabIndex = 18;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(59, 289);
            label11.Name = "label11";
            label11.Size = new Size(49, 25);
            label11.TabIndex = 19;
            label11.Text = "CEP:";
            // 
            // maskedTextBox4
            // 
            maskedTextBox4.Location = new Point(129, 281);
            maskedTextBox4.Mask = "00000-000";
            maskedTextBox4.Name = "maskedTextBox4";
            maskedTextBox4.Size = new Size(100, 33);
            maskedTextBox4.TabIndex = 20;
            // 
            // Funcionarios
            // 
            AutoScaleDimensions = new SizeF(11F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1183, 611);
            Controls.Add(maskedTextBox4);
            Controls.Add(label11);
            Controls.Add(textBox5);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(comboBox1);
            Controls.Add(maskedTextBox3);
            Controls.Add(maskedTextBox2);
            Controls.Add(maskedTextBox1);
            Controls.Add(label10);
            Controls.Add(label9);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            Margin = new Padding(5);
            Name = "Funcionarios";
            Text = "Cadastrar Funcionários";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private Label label8;
        private Label label9;
        private Label label10;
        private MaskedTextBox maskedTextBox1;
        private MaskedTextBox maskedTextBox2;
        private MaskedTextBox maskedTextBox3;
        private ComboBox comboBox1;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private TextBox textBox5;
        private Label label11;
        private MaskedTextBox maskedTextBox4;
    }
}