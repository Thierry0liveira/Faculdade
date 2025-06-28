package com.aula.controle_estoque;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity  implements View.OnClickListener{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Definir os destinos principais do menu
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_consultar, R.id.nav_requisicao,
                R.id.nav_perdas, R.id.nav_furtos, R.id.nav_cadastroProdutos)
                .setOpenableLayout(drawer)
                .build();

        // Configurar o NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Recuperar os parâmetros passados
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String usuario = extras.getString("usuario");

            // Salvar o nome do usuário em SharedPreferences
            SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nomeUsuario", usuario);
            editor.apply();
        }

        // Recuperar a referência do header do NavigationView
        View headerView = navigationView.getHeaderView(0);

        EditText txtHeadUsuario = headerView.findViewById(R.id.txtHeadUsuario);
        Button btHeadLogout = headerView.findViewById(R.id.btHeadLogout);

        // Carregar o nome do usuário de SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String nomeUsuario = prefs.getString("nomeUsuario", "Usuário");

        txtHeadUsuario.setText(nomeUsuario);

        btHeadLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btHeadLogout) {
            handleLogout();
        }
    }

    private void handleLogout() {
        // Removendo dados do usuário de SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();

        // Redirecionando para a tela de login
        Intent intent = new Intent(MenuActivity.this, Login.class);
        startActivity(intent);
        finish(); // Fecha a activity atual
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}