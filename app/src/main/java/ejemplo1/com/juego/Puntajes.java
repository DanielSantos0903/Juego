package ejemplo1.com.juego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import static ejemplo1.com.juego.Principal.adaptadorPuntaje;
import static ejemplo1.com.juego.Principal.lista;
import static ejemplo1.com.juego.Principal.jugadorArray;

public class Puntajes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);


            lista = findViewById(R.id.lstPuntajes);

            if (adaptadorPuntaje != null) {

                lista.setAdapter(adaptadorPuntaje);
            }
        }

}
