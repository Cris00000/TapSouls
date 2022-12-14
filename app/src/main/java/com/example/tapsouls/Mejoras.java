package com.example.tapsouls;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mejoras#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mejoras extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mejoras() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mejoras.
     */
    // TODO: Rename and change types and number of parameters
    public static Mejoras newInstance(String param1, String param2) {
        Mejoras fragment = new Mejoras();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ConexionFireBase cb;

    Bundle bundle;
    private String correo;
    private String contrasena;

    private Jugador jugador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mejoras, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ConexionFireBase cb = new ConexionFireBase();

        Bundle bundle = getActivity().getIntent().getExtras();
        String correo = bundle.getString("Correo");
        String contrasena = bundle.getString("Contrasena");

        cb.recuperarDatos(correo, contrasena);

        Jugador jugador = VariablesGlobales.jugador;

        ArrayList<Objeto> mejorasActuales = jugador.getMejorasActuales();

        TextView tituloMejoraAtaque = (TextView) getView().findViewById(R.id.tituloAtaque);
        TextView descripcionMejoraAtaque = (TextView) getView().findViewById(R.id.descripcionAtaque);
        TextView precioMejoraAtaque = (TextView) getView().findViewById(R.id.precioAtaque);

        TextView tituloMejoraDefensa = (TextView) getView().findViewById(R.id.tituloDefensa);
        TextView descripcionMejoraDefensa = (TextView) getView().findViewById(R.id.descripcionDefensa);
        TextView precioMejoraDefensa = (TextView) getView().findViewById(R.id.precioDefensa);

        TextView tituloMejoraDPS = (TextView) getView().findViewById(R.id.tituloDPS);
        TextView descripcionMejoraDPS = (TextView) getView().findViewById(R.id.descripcionDPS);
        TextView precioMejoraDPS = (TextView) getView().findViewById(R.id.precioDPS);

        TextView monedas = (TextView) getActivity().findViewById(R.id.monedas);


        tituloMejoraAtaque.setText(mejorasActuales.get(0).getNombre());
        descripcionMejoraAtaque.setText(mejorasActuales.get(0).getDescripcion());
        precioMejoraAtaque.setText(String.valueOf(mejorasActuales.get(0).getPrecio()));

        tituloMejoraDefensa.setText(mejorasActuales.get(1).getNombre());
        descripcionMejoraDefensa.setText(mejorasActuales.get(1).getDescripcion());
        precioMejoraDefensa.setText(String.valueOf(mejorasActuales.get(1).getPrecio()));

        tituloMejoraDPS.setText(mejorasActuales.get(2).getNombre());
        descripcionMejoraDPS.setText(mejorasActuales.get(2).getDescripcion());
        precioMejoraDPS.setText(String.valueOf(mejorasActuales.get(2).getPrecio()));

        Button botonComprarAtaque = (Button) getView().findViewById(R.id.botonComprarAtaque);
        Button botonComprarDefensa = (Button) getView().findViewById(R.id.botonComprarDefensa);
        Button botonComprarDPS = (Button) getView().findViewById(R.id.botonComprarDPS);

        botonComprarAtaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jugador.getMonedas()> mejorasActuales.get(0).getPrecio()){
                    jugador.comprarMejora(mejorasActuales.get(0).getPrecio());
                    jugador.efectuarMejoraAtaque();
                    tituloMejoraAtaque.setText(mejorasActuales.get(0).getNombre());
                    descripcionMejoraAtaque.setText(mejorasActuales.get(0).getDescripcion());
                    precioMejoraAtaque.setText(String.valueOf(mejorasActuales.get(0).getPrecio()));
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                }
            }
        });

        botonComprarDefensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jugador.getMonedas()> mejorasActuales.get(1).getPrecio()){
                    jugador.comprarMejora(mejorasActuales.get(1).getPrecio());
                    jugador.efectuarMejoraDefensa();
                    tituloMejoraDefensa.setText(mejorasActuales.get(1).getNombre());
                    descripcionMejoraDefensa.setText(mejorasActuales.get(1).getDescripcion());
                    precioMejoraDefensa.setText(String.valueOf(mejorasActuales.get(1).getPrecio()));
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                }
            }
        });

        botonComprarDPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jugador.getMonedas()> mejorasActuales.get(2).getPrecio()){
                    jugador.comprarMejora(mejorasActuales.get(2).getPrecio());
                    jugador.efectuarMejoraAutomatico();
                    tituloMejoraDPS.setText(mejorasActuales.get(2).getNombre());
                    descripcionMejoraDPS.setText(mejorasActuales.get(2).getDescripcion());
                    precioMejoraDPS.setText(String.valueOf(mejorasActuales.get(2).getPrecio()));
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                }
            }
        });

    }
}