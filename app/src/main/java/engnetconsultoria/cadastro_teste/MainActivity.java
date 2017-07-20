package engnetconsultoria.cadastro_teste;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoSubmit;
    private EditText caixa_name,caixa_email;
    private TextView cadastro_concluido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variáveis para componentes da página
        botaoSubmit = (Button) findViewById(R.id.cadastro_button);
        cadastro_concluido = (TextView) findViewById(R.id.cadastro_concluido);
        caixa_name = (EditText) findViewById(R.id.nameID);
        caixa_email = (EditText) findViewById(R.id.emailID);


        //Função onclick do botão
        botaoSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V) {
                //recuperar oq foi digitado
                String name = caixa_name.getText().toString();
                String email = caixa_email.getText().toString();

                //Verificar se está vazia
                if (name.isEmpty() || email.isEmpty())
                    cadastro_concluido.setText("Por favor preencha todos os campos.");
                else
                {
                    //realizar cadastro

                    cadastro_concluido.setText("Cadastro concluído");
                    //Redirecionamento

                    Intent intent = new Intent(MainActivity.this,NextActivity.class);
                    intent.putExtra("key1",name);
                    intent.putExtra("key2",email);
                    startActivity(intent);

                }
                }
            }
        );

    }
}
