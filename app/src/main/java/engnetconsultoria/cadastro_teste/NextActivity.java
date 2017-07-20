package engnetconsultoria.cadastro_teste;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NextActivity extends AppCompatActivity {

    private TextView texto1, texto2;

    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuariosReferencia = firebaseReferencia.child("usuarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        texto1 = (TextView) findViewById(R.id.caixa_texto);
        texto2 = (TextView) findViewById(R.id.caixa_texto2);
        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            String name_passado = extra.getString("key1");
            String email_passado = extra.getString("key2");
            texto1.setText(name_passado);
            texto2.setText(email_passado);


            /*Inserir Firebase
            //firebaseReferencia.child("Pessoas").child("Nome").setValue(name_passado);
            //firebaseReferencia.child("Pessoas").child("Email").setValue(email_passado);
            Usuario user = new Usuario(name_passado,email_passado);
            usuariosReferencia.child("002").setValue(user);
            */
            usuariosReferencia.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    texto1.setText(dataSnapshot.getValue().toString());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    texto2.setText(databaseError.toString());
                }
            });


            /*
            //Armazenamento interno
            try {
                open_database();
                insert_database(name_passado,email_passado);
                recupera_database();
            } catch (Exception e) {
                texto2.setText("OUTSIDE");
            }*/

        } else {
            texto1.setText("ERROR1");
            texto2.setText("ERROR2");
        }
    }


}