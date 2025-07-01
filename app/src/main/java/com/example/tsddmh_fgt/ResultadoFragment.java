package com.example.tsddmh_fgt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ResultadoFragment extends Fragment {

    private static final String ARG_PUNTAJE = "puntaje";
    private int puntaje;

    public ResultadoFragment() {}

    public static ResultadoFragment newInstance(int puntaje) {
        ResultadoFragment fragment = new ResultadoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PUNTAJE, puntaje);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            puntaje = getArguments().getInt(ARG_PUNTAJE);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.fragment_resultado, container, false);

        TextView txtResultado = v.findViewById(R.id.txt_resultado);
        TextView txtPuntaje = v.findViewById(R.id.txt_puntaje);
        Button btnReintentar = v.findViewById(R.id.btn_reintentar);
        Button btnMenu = v.findViewById(R.id.btn_menu);

        int porcentaje = (puntaje * 100) / 4;

        if (porcentaje >= 70) {
            txtResultado.setText("¡Aprobado!");
            txtResultado.setTextColor(ContextCompat.getColor(requireContext(), R.color.verde_correcto));
        } else {
            txtResultado.setText("Reprobado");
            txtResultado.setTextColor(ContextCompat.getColor(requireContext(), R.color.rojo_incorrecto));
        }

        txtPuntaje.setText("Tu puntaje: " + puntaje + " / 4 (" + porcentaje + "%)");

        btnReintentar.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "Reiniciando examen...", Toast.LENGTH_SHORT).show();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ExamenFragment())
                    .commit();
        });

        btnMenu.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "Regresando al menú principal", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext(), MainMenuActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });

        return v;
    }
}