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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JuegoPrincipal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JuegoPrincipal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JuegoPrincipal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JuegoPrincipal.
     */
    // TODO: Rename and change types and number of parameters
    public static JuegoPrincipal newInstance(String param1, String param2) {
        JuegoPrincipal fragment = new JuegoPrincipal();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_juego_principal, container, false);
    }

    LevelManager levelManager = new LevelManager();
    Enemigo enemigoActual;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Jugador jugador = new Jugador("Prueba", "1234", 150, 17, 250, 5, R.drawable.caballero);


        levelManager.inicializarNiveles();

        TextView nombreEnemigo = (TextView) getView().findViewById(R.id.nombreEnemigo);
        TextView saludEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
        TextView saludJugador = (TextView) getView().findViewById(R.id.saludJugador);

        ImageView imagenEnemigo = (ImageView) getView().findViewById(R.id.imagenEnemigo);
        ImageView imagenJugador = (ImageView) getView().findViewById(R.id.imagenJugador);

        Button botonAtacar = (Button) getView().findViewById(R.id.atacar);

        imagenJugador.setImageResource(jugador.getImagen());

        enemigoActual=levelManager.comprobacionEnemigoActual();

        imagenEnemigo.setImageResource(enemigoActual.getImagen());
        saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
        nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
        saludJugador.setText(String.valueOf(jugador.getSalud()));

        botonAtacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enemigoActual.recibirDano(jugador.getAtaque(), enemigoActual.getDefensa(), enemigoActual.getSalud());
                saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));

                if (enemigoActual.getSalud()<=0){
                    enemigoActual = levelManager.comprobacionEnemigoActual();
                    imagenEnemigo.setImageResource(enemigoActual.getImagen());
                    saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                    nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
                }
            }
        });
    }


}