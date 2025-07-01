package com.example.tsddmh_fgt;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    public MenuFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnTema1 = v.findViewById(R.id.btn_tema1);
        Button btnTema2 = v.findViewById(R.id.btn_tema2);
        Button btnTema3 = v.findViewById(R.id.btn_tema3);
        Button btnTema4 = v.findViewById(R.id.btn_tema4);
        Button btnExamen = v.findViewById(R.id.btn_examen);

        btnTema1.setOnClickListener(view ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Tema1Fragment())
                        .addToBackStack(null)
                        .commit()
        );

        btnTema2.setOnClickListener(view ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Tema2Fragment())
                        .addToBackStack(null)
                        .commit()
        );

        btnTema3.setOnClickListener(view ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Tema3Fragment())
                        .addToBackStack(null)
                        .commit()
        );

        btnTema4.setOnClickListener(view ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Tema4Fragment())
                        .addToBackStack(null)
                        .commit()
        );

        btnExamen.setOnClickListener(view ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ExamenFragment())
                        .addToBackStack(null)
                        .commit()
        );

        return v;
    }
}