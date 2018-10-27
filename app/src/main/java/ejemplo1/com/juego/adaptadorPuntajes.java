package ejemplo1.com.juego;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class adaptadorPuntajes extends ArrayAdapter<Jugador> {

    public adaptadorPuntajes(Context context, List<Jugador> objects) {
        super(context,0,objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obteniendo el dato
        Jugador jugador= getItem(position);


        //odo inicializando el layout correspondiente al item (estudiante)
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_puntaje,parent,false);
        }
        TextView txtnombre = convertView.findViewById(R.id.txtnombre);
        TextView txtpuntaje = convertView.findViewById(R.id.txtpuntaje);

        txtnombre.setText(jugador.getNick());
        txtpuntaje.setText(jugador.getPuntaje());

        return convertView;
    }
}
