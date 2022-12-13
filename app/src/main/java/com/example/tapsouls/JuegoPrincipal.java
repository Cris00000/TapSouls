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

    private AsyncTask dpsJugadorAutomatico = new ProcesoDPS();
    private AsyncTask dpsEnemigoAutomatico = new ProcesoDPSEnemigo();


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

        barraJugador.setMax(jugador.getSalud());
        barraJugador.setProgress(jugador.getSalud());


        imagenEnemigo.setImageResource(enemigoActual.getImagen());
        saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
        nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
        saludJugador.setText(String.valueOf(jugador.getSalud()));

        dpsJugadorAutomatico = new ProcesoDPS().executeOnExecutor(ProcesoDPS.THREAD_POOL_EXECUTOR, enemigoActual.getSalud(), jugador.getDps());
        dpsEnemigoAutomatico = new ProcesoDPSEnemigo().executeOnExecutor(ProcesoDPSEnemigo.THREAD_POOL_EXECUTOR, jugador.getSalud(),enemigoActual.getAtaque());

        botonAtacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enemigoActual.recibirDano(jugador.getAtaque());
                saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                barraEnemiga.setProgress(enemigoActual.getSalud());

                if (enemigoActual.getSalud()<=0){
                    jugador.obtenerRecompensa(enemigoActual.getRecompensa());
                    jugador.subirNivel();
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                    nivel.setText(String.valueOf(jugador.getNivel()));
                    enemigoActual = levelManager.comprobacionEnemigoActual();
                    barraEnemiga.setProgress(enemigoActual.getSalud());
                    barraEnemiga.setMax(enemigoActual.getSalud());
                    imagenEnemigo.setImageResource(enemigoActual.getImagen());
                    saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                    nombreEnemigo.setText(String.valueOf(enemigoActual.getNombre()));
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG", "Destruido");
        dpsJugadorAutomatico.cancel(true);
        dpsEnemigoAutomatico.cancel(true);
        Log.d("TAG", "Destruido");
    }

    class ProcesoDPS extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(!isCancelled()){
             Jugador jugador = VariablesGlobales.jugador;
             enemigoActual = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                while (enemigoActual.getSalud() > 0) {
                    jugador = VariablesGlobales.jugador;
                    Log.d("TAG", String.valueOf(isCancelled()));
                    if (isCancelled()){
                        break;
                    }
                    try {
                        enemigoActual = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                        Thread.sleep(1000);
                        integers[0] = enemigoActual.getSalud();
                        integers[1] = jugador.getDps();
                        integers[0] -= integers[1];
                        if (integers[0] <= 0) {
                            enemigoActual.setSalud(0);
                            integers[0] = 0;
                        }
                        enemigoActual.setSalud(integers[0]);
                        publishProgress(integers[0]);

                    } catch (Exception e) {
                        Log.v("Error: ", e.toString());
                    }

                }
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("TAG", String.valueOf(values[0]));
            try {
                ProgressBar progresoEnemigo = (ProgressBar) getView().findViewById(R.id.barraEnemigo);
                TextView vidaDelEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
                progresoEnemigo.setProgress(values[0]);
                vidaDelEnemigo.setText(String.valueOf(values[0]));
                Button botonAtacar = (Button) getView().findViewById(R.id.atacar);
                if (values[0] <= 0 && !botonAtacar.isPressed()) {
                    TextView monedas = (TextView) getActivity().findViewById(R.id.monedas);
                    TextView nivel = (TextView) getActivity().findViewById(R.id.nivel);
                    jugador.obtenerRecompensa(enemigoActual.getRecompensa());
                    jugador.subirNivel();
                    monedas.setText(String.valueOf(jugador.getMonedas()));
                    nivel.setText(String.valueOf(jugador.getNivel()));
                    enemigoActual = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                    progresoEnemigo.setMax(enemigoActual.getSalud());
                    progresoEnemigo.setProgress(enemigoActual.getSalud());
                    TextView saludEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
                    TextView nombreEnemigo = (TextView) getView().findViewById(R.id.nombreEnemigo);
                    ImageView imagenEnemigo = (ImageView) getView().findViewById(R.id.imagenEnemigo);
                    saludEnemigo.setText(String.valueOf(enemigoActual.getSalud()));
                    nombreEnemigo.setText(enemigoActual.getNombre());
                    imagenEnemigo.setImageResource(enemigoActual.getImagen());
                }
            } catch (Exception e) {

            }

        }
    }

        class ProcesoDPSEnemigo extends AsyncTask<Integer, Integer, Integer> {

            @Override
            protected Integer doInBackground(Integer... integers) {
                while(!isCancelled()){
                    Jugador jugador = VariablesGlobales.jugador;
                    enemigoActual = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                    while (jugador.getSalud() > 0) {
                        if (isCancelled()){
                            break;
                        }
                        try {
                            jugador = VariablesGlobales.jugador;
                            enemigoActual = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                            Thread.sleep(2000);
                            integers[0] = jugador.getSalud();
                            integers[1] = enemigoActual.getAtaque();
                            if (jugador.getDefensa() < enemigoActual.getAtaque()) {
                                integers[0] -= (integers[1] - jugador.getDefensa());
                            }

                            if (integers[0] <= 0) {
                                jugador.setSalud(0);
                                integers[0] = 0;
                            }
                            jugador.setSalud(integers[0]);
                            publishProgress(integers[0]);
                        } catch (Exception e) {
                            Log.v("Error: ", e.toString());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                Log.d("TAG", String.valueOf(values[0]));
                try {
                    ProgressBar vidaJugador = (ProgressBar) getView().findViewById(R.id.barraJugador);
                    TextView vidaDelJugador = (TextView) getView().findViewById(R.id.saludJugador);
                    ProgressBar progresoEnemigo = (ProgressBar) getView().findViewById(R.id.barraEnemigo);
                    vidaJugador.setProgress(values[0]);
                    vidaDelJugador.setText(String.valueOf(values[0]));
                    if (values[0] <= 0) {
                        Enemigo enemigo = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                        if(enemigo.getNumero()>=1 && enemigo.getNumero()<=5){
                            jugador.getProgresoNiveles().inicializarNivel1();
                        }
                        else if(enemigo.getNumero()>=6 && enemigo.getNumero()<=10){
                            jugador.getProgresoNiveles().inicializarNivel2();
                        }
                        else if(enemigo.getNumero()>=11 && enemigo.getNumero()<=15){
                            jugador.getProgresoNiveles().inicializarNivel3();
                        }
                        else if(enemigo.getNumero()>=16 && enemigo.getNumero()<=20){
                            jugador.getProgresoNiveles().inicializarNivel4();
                        }
                        else if(enemigo.getNumero()>=21 && enemigo.getNumero()<=25){
                            jugador.getProgresoNiveles().inicializarNivel5();
                        }

                        enemigo = jugador.getProgresoNiveles().comprobacionEnemigoActual();
                        progresoEnemigo.setMax(enemigo.getSalud());
                        progresoEnemigo.setProgress(enemigo.getSalud());
                        jugador.setSalud(100);
                        vidaJugador.setMax(enemigo.getSalud());
                        vidaJugador.setProgress(enemigo.getSalud());
                        vidaDelJugador.setText(String.valueOf(jugador.getSalud()));
                        TextView saludEnemigo = (TextView) getView().findViewById(R.id.saludEnemigo);
                        TextView nombreEnemigo = (TextView) getView().findViewById(R.id.nombreEnemigo);
                        ImageView imagenEnemigo = (ImageView) getView().findViewById(R.id.imagenEnemigo);
                        saludEnemigo.setText(String.valueOf(enemigo.getSalud()));
                        nombreEnemigo.setText(enemigo.getNombre());
                        imagenEnemigo.setImageResource(enemigo.getImagen());
                    }
                } catch (Exception e) {

                }

            }

        }

    }

