package br.com.maximus.maximus;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db; // Defino que BD é  o meu banco



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        String nome = params.getString("nome");

        db=openOrCreateDatabase("ContatosDB", getApplicationContext().MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXIISTS contatos(nome VARCHAR, contato VARCHAR, tipo VARCHAR);");


        Button botaoLogin = (Button) findViewById(R.id.botaoLoginMaximus);
        // Button botaoCriarConta = (Button)findViewById(R.id.botaoCriarConta);
        Button sair = (Button)findViewById(R.id.sair);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.loginmaximus);
            }
        });

        sair.setOnClickListener(clickSair());
    }

    public View.OnClickListener clickSair() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","Saída");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        };
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
