namespace Assunto_4_N1
{
    partial class Form1
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            txtN1 = new TextBox();
            txtN2 = new TextBox();
            txtRes = new TextBox();
            btSoma = new Button();
            btSub = new Button();
            btMult = new Button();
            btDiv = new Button();
            btReset = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe Print", 27.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.ForeColor = Color.Blue;
            label1.Location = new Point(249, 9);
            label1.Name = "label1";
            label1.Size = new Size(248, 65);
            label1.TabIndex = 0;
            label1.Text = "Calculadora";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label2.ForeColor = Color.Blue;
            label2.Location = new Point(12, 104);
            label2.Name = "label2";
            label2.Size = new Size(202, 33);
            label2.TabIndex = 1;
            label2.Text = "Digite um número:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label3.ForeColor = Color.Blue;
            label3.Location = new Point(12, 220);
            label3.Name = "label3";
            label3.Size = new Size(223, 33);
            label3.TabIndex = 2;
            label3.Text = "Digite outro número:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label4.ForeColor = Color.Blue;
            label4.Location = new Point(12, 335);
            label4.Name = "label4";
            label4.Size = new Size(114, 33);
            label4.TabIndex = 3;
            label4.Text = "Resultado:";
            // 
            // txtN1
            // 
            txtN1.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtN1.ForeColor = Color.Blue;
            txtN1.Location = new Point(335, 104);
            txtN1.Name = "txtN1";
            txtN1.Size = new Size(162, 41);
            txtN1.TabIndex = 4;
            // 
            // txtN2
            // 
            txtN2.BackColor = Color.White;
            txtN2.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtN2.ForeColor = Color.Blue;
            txtN2.Location = new Point(335, 220);
            txtN2.Name = "txtN2";
            txtN2.Size = new Size(162, 41);
            txtN2.TabIndex = 5;
            // 
            // txtRes
            // 
            txtRes.BackColor = Color.FromArgb(192, 192, 255);
            txtRes.Enabled = false;
            txtRes.Font = new Font("Segoe Print", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtRes.ForeColor = Color.Blue;
            txtRes.Location = new Point(335, 335);
            txtRes.Name = "txtRes";
            txtRes.Size = new Size(162, 41);
            txtRes.TabIndex = 6;
            // 
            // btSoma
            // 
            btSoma.BackColor = Color.FromArgb(192, 192, 255);
            btSoma.Font = new Font("Segoe Print", 27.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btSoma.ForeColor = Color.Black;
            btSoma.Location = new Point(542, 191);
            btSoma.Name = "btSoma";
            btSoma.Size = new Size(94, 70);
            btSoma.TabIndex = 7;
            btSoma.Text = "+";
            btSoma.UseVisualStyleBackColor = false;
            btSoma.Click += btSoma_Click;
            // 
            // btSub
            // 
            btSub.BackColor = Color.FromArgb(192, 192, 255);
            btSub.Font = new Font("Segoe Print", 27.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btSub.Location = new Point(542, 269);
            btSub.Name = "btSub";
            btSub.Size = new Size(94, 70);
            btSub.TabIndex = 8;
            btSub.Text = "-";
            btSub.UseVisualStyleBackColor = false;
            btSub.Click += btSub_Click;
            // 
            // btMult
            // 
            btMult.BackColor = Color.FromArgb(192, 192, 255);
            btMult.Font = new Font("Segoe Print", 27.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btMult.Location = new Point(652, 191);
            btMult.Name = "btMult";
            btMult.Size = new Size(94, 70);
            btMult.TabIndex = 9;
            btMult.Text = "X";
            btMult.UseVisualStyleBackColor = false;
            btMult.Click += btMult_Click;
            // 
            // btDiv
            // 
            btDiv.BackColor = Color.FromArgb(192, 192, 255);
            btDiv.Font = new Font("Segoe Print", 27.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btDiv.Location = new Point(652, 269);
            btDiv.Name = "btDiv";
            btDiv.Size = new Size(94, 70);
            btDiv.TabIndex = 10;
            btDiv.Text = "/";
            btDiv.UseVisualStyleBackColor = false;
            btDiv.Click += btDiv_Click;
            // 
            // btReset
            // 
            btReset.BackColor = Color.IndianRed;
            btReset.Font = new Font("Segoe Print", 20.25F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btReset.Location = new Point(542, 104);
            btReset.Name = "btReset";
            btReset.Size = new Size(204, 70);
            btReset.TabIndex = 11;
            btReset.Text = "C";
            btReset.UseVisualStyleBackColor = false;
            btReset.Click += BtReset_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btReset);
            Controls.Add(btDiv);
            Controls.Add(btMult);
            Controls.Add(btSub);
            Controls.Add(btSoma);
            Controls.Add(txtRes);
            Controls.Add(txtN2);
            Controls.Add(txtN1);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Calculadora";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox txtN1;
        private TextBox txtN2;
        private TextBox txtRes;
        private Button btSoma;
        private Button btSub;
        private Button btMult;
        private Button btDiv;
        private Button btReset;
    }
}
