package com.example.tapsouls;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

    private Jugador jugador = VariablesGlobales.jugador;
    private LevelManager levelManager = jugador.getProgresoNiveles();
    private Enemigo enemigoActual;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nombreEnemigo = (TextView) getView().findViewById(R.id.nombreEnemigo);
        TextView saludEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
        TextView saludJugador = (TextView) getView().findViewById(R.id.saludJugador);

        TextView monedas = (TextView) getActivity().findViewById(R.id.monedas);
        TextView nivel = (TextView) getActivity().findViewById(R.id.nivel);

        ImageView imagenEnemigo = (ImageView) getView().findViewById(R.id.imagenEnemigo);
        ImageView imagenJugador = (ImageView) getView().findViewById(R.id.imagenJugador);

        ProgressBar barraEnemiga = (ProgressBar) getView().findViewById(R.id.barraEnemigo);
        ProgressBar barraJugador = (ProgressBar) getView().findViewById(R.id.barraJugador);

        Button botonAtacar = (Button) getView().findViewById(R.id.atacar);

        imagenJugador.setImageResource(jugador.getImagen());

        enemigoActual=levelManager.comprobacionEnemigoActual();

        barraEnemiga.setMax(enemigoActual.getSalud());
        barraEnemiga.setProgress(enemigoActual.getSalud());


        imagenEnemigo.setImageResource(enemigoActual.getImagen());
        saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
        nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
        saludJugador.setText(String.valueOf(jugador.getSalud()));

        new ProcesoDPS().execute(enemigoActual.getSalud(), jugador.getDps());

        botonAtacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enemigoActual.recibirDano(jugador.getAtaque());
                saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                barraEnemiga.setProgress(enemigoActual.getSalud());

                if (enemigoActual.getSalud()<=0){
                    enemigoActual = levelManager.comprobacionEnemigoActual();
                    barraEnemiga.setProgress(enemigoActual.getSalud());
                    barraEnemiga.setMax(enemigoActual.getSalud());
                    imagenEnemigo.setImageResource(enemigoActual.getImagen());
                    saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                    nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
                    jugador.obtenerRecompensa(enemigoActual.getRecompensa());
                    jugador.subirNivel();
                    nivel.setText(String.valueOf(jugador.getNivel()));
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                }
            }
        });
    }

    class ProcesoDPS extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            Jugador jugador=VariablesGlobales.jugador;
            Enemigo enemigo=jugador.getProgresoNiveles().comprobacionEnemigoActual();
            while (enemigo.getSalud()>0){
                try{
                    enemigo=jugador.getProgresoNiveles().comprobacionEnemigoActual();
                    Thread.sleep(1000);
                    integers[0]=enemigo.getSalud();
                    integers[1]=jugador.getDps();
                    integers[0]-=integers[1];
                    if(integers[0]<=0){
                        enemigo.setSalud(0);
                        integers[0]=0;
                    }
                    enemigo.setSalud(integers[0]);
                    publishProgress(integers[0]);
                } catch (Exception e){
                    Log.v("Error: ", e.toString());
                }

            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("TAG", String.valueOf(values[0]));
            try{
                Log.d("TAG", "Se está intentando");
                ProgressBar progresoEnemigo = (ProgressBar) getView().findViewById(R.id.barraEnemigo);
                Log.d("TAG", "a");
                TextView vidaDelEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
                Log.d("TAG", "b");
                progresoEnemigo.setProgress(values[0]);
                vidaDelEnemigo.setText(String.valueOf(values[0]));
                if(values[0]<=0){
                    Enemigo enemigo=jugador.getProgresoNiveles().comprobacionEnemigoActual();
                    progresoEnemigo.setMax(enemigo.getSalud());
                    progresoEnemigo.setProgress(enemigo.getSalud());
                    TextView saludEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
                    TextView nombreEnemigo = (TextView) getView().findViewById(R.id.nombreEnemigo);
                    ImageView imagenEnemigo = (ImageView) getView().findViewById(R.id.imagenEnemigo);
                    saludEnemigo.setText(String.valueOf(enemigo.getSalud()));
                    nombreEnemigo.setText(enemigo.getNombre());
                    imagenEnemigo.setImageResource(enemigo.getImagen());
                }
            } catch (Exception e){

            }

        }
    }

}

