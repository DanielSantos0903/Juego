package ejemplo1.com.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    public static ListView lista;
    public static String Nick;
    private Button Nuevo;
    private Button Iniciar;
    private Button Puntajes;
    public static ArrayList<Jugador> jugadorArray;
    public static adaptadorPuntajes adaptadorPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.Nuevo = findViewById(R.id.btn1);
        this.Iniciar = findViewById(R.id.btn2);
        this.Puntajes = findViewById(R.id.btn3);

        if(jugadorArray == null){

            jugadorArray = new ArrayList<>();
        }

        adaptadorPuntaje = new adaptadorPuntajes(this, jugadorArray );

        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nick=null;
                Intent n = new Intent(Principal.this,NuevoJugador.class);
                startActivity(n);
            }
        });

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nick==null){

                    Toast.makeText(Principal.this, "Ingrese un Nick!", Toast.LENGTH_SHORT).show();

                }else {
                    Intent I = new Intent(Principal.this, IniciarJuego.class);
                    startActivityForResult(I,2);
                }
            }
        });

        Puntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent P = new Intent(Principal.this,Puntajes.class);
                startActivity(P);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2) {
            Jugador p = new Jugador(
                    data.getStringExtra("nick"),
                    data.getStringExtra("puntaje")
            );

            jugadorArray.add(p);
            adaptadorPuntaje.notifyDataSetChanged();
        }
    }
}
