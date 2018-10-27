package ejemplo1.com.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static  ejemplo1.com.juego.Principal.Nick;

public class NuevoJugador extends AppCompatActivity {

    private EditText campo;
    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_np);

        this.campo = findViewById(R.id.Nick);
        this.aceptar = findViewById(R.id.btnAceptar);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campo.getText().toString().isEmpty()){

                    Toast.makeText(NuevoJugador.this, "Ingrese su NICK", Toast.LENGTH_SHORT).show();

                }else{

                    Nick= campo.getText().toString().trim();

                    Intent resul = new Intent(NuevoJugador.this,Principal.class);
                    startActivity(resul);
                    finish();
                }
            }
        });
    }
}
