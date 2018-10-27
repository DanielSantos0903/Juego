package ejemplo1.com.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static  ejemplo1.com.juego.Principal.Nick;
public class IniciarJuego extends AppCompatActivity {

    private Button Finalizar;
    private Button CPU;
    private Button Piedra;
    private Button Papel;
    private Button Tijera;
    private TextView ganados;
    private TextView perdidos;
    private TextView empatados;
    private TextView totalPuntos;
    private TextView resultado;
    private TextView player;

    private int puntos=0;
    private boolean estado=false;
    int contE=1;
    int contP=1;
    int contG=1;
    String mensaje="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ij);

        //insertamos los botones
        this.CPU= findViewById(R.id.btnCPU);
        this.Finalizar = findViewById(R.id.btnFinalizar);
        this.Tijera = findViewById(R.id.btnTijera);
        this.Papel = findViewById(R.id.btnPapel);
        this.Piedra = findViewById(R.id.btnPiedra);
        this.player = findViewById(R.id.player);
        this.ganados = findViewById(R.id.Ganados);
        this.perdidos = findViewById(R.id.Perdidos);
        this.empatados = findViewById(R.id.Empatados);
        this.totalPuntos = findViewById(R.id.TotalPuntos);
        this.resultado = findViewById(R.id.Ganador);

        player.setText(Nick);

        Piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                randon();

                if(mensaje=="O"){

                    empatados.setText("Empatados: "+ contE++);
                    resultado.setText("Empate");


                }else if(mensaje=="[]"){

                    perdidos.setText("Perdidos: "+ contP++);
                    puntos-= 3;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Perdió");

                }else {

                    ganados.setText("Ganados: "+ contG++);
                    puntos+= 6;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Ganó");
                }
            }
        });

        Tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                randon();

                if(mensaje=="X"){

                    empatados.setText("Empatados: "+ contE++);
                    resultado.setText("Empate");

                }else if(mensaje=="O"){

                    perdidos.setText("Perdidos: "+ contP++);
                    puntos-= 3;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Perdió");

                }else {

                    ganados.setText("Ganados: "+ contG++);
                    puntos+= 6;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Ganó");
                }
            }
        });
        Papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                randon();

                if(mensaje=="[]"){

                    empatados.setText("Empatados: "+ contE++);
                    resultado.setText("Empate");

                }else if(mensaje=="X"){

                    perdidos.setText("Perdidos: "+ contP++);
                    puntos-= 3;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Perdió");

                }else {

                    ganados.setText("Ganados: "+ contG++);
                    puntos+= 6;
                    totalPuntos.setText("Puntos: "+ puntos +"ptos");
                    resultado.setText("Ganó");
                }
            }
        });

        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String total = Integer.toString(puntos);
                 Intent i = new Intent();
                 i.putExtra("nick",player.getText().toString());
                 i.putExtra("puntaje", ( total));
                 setResult(2, i);
                 finish();

            }
        });

    }

    public String randon(){


        Random r = new Random();
        int ran = r.nextInt(4 - 1) + 1;
        if(ran==1){

            mensaje="O";


        }else if(ran==2) {

            mensaje = "[]";


        }else {

            mensaje="X";

        }

        CPU.setText(mensaje);
        return mensaje;
    }
}
