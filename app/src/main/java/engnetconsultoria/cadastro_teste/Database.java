package engnetconsultoria.cadastro_teste;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by daniel on 20/07/17.
 */

public class Database extends AppCompatActivity {

    private SQLiteDatabase bancodeDados;

    public Database() {
        open_database();
    }

    private void insert_database(String text1, String text2) {
        try {

            if (text1.equals("") || text2.equals(""))
                ;
                //Toast.makeText(NextActivity.class, "Texto vazio", Toast.LENGTH_SHORT).show();
            else {
                this.bancodeDados.execSQL("INSERT INTO guilda (classe, elemento) VALUES('" + text1 + "', '" + text2 + "')");
            }
        } catch (Exception e) {
            //Toast.makeText(NextActivity.class, "Erro ao inserir", Toast.LENGTH_SHORT).show();
        }

    }


    private void recupera_database() {
        //Recupera os dados
        Cursor cursor = this.bancodeDados.rawQuery("SELECT * FROM guilda", null);

        int indicenome = cursor.getColumnIndex("classe");
        int indiceemail = cursor.getColumnIndex("elemento");

        cursor.moveToFirst();
        //texto1.setText("Class = " + cursor.getString(indicenome));
        //texto2.setText("Element = " + cursor.getString(indiceemail));

        // DA erro dps de printar o ultimo
            /*
            while ( cursor != null ) {
                Log.i("Nome = ", cursor.getString(indicenome));
                Log.i("Email = ", cursor.getString(indiceemail));
                //texto1.setText("Nome == "  + cursor.getString(indicenome) + " END");
                //texto2.setText("Email = " + cursor.getString(indiceemail));
                cursor.moveToNext();
            }*/
    }

    private void open_database()
    {
        this.bancodeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
        this.bancodeDados.execSQL("DROP TABLE guilda");
        this.bancodeDados.execSQL("CREATE TABLE IF NOT EXISTS guilda(classe VARCHAR, elemento VARCHAR ) ");
    }


}
