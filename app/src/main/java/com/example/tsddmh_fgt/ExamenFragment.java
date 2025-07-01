package com.example.tsddmh_fgt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

public class ExamenFragment extends Fragment {

    public ExamenFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_examen, container, false);

        Button btnEnviar = v.findViewById(R.id.boton_enviar);

        btnEnviar.setOnClickListener(view -> {
            int score = 0;

            // Pregunta 1: correcta -> p1_op2
            CheckBox p1_op2 = v.findViewById(R.id.p1_op2);
            if (p1_op2.isChecked()) score++;

            // Pregunta 2: correcta -> p2_op3
            CheckBox p2_op3 = v.findViewById(R.id.p2_op3);
            if (p2_op3.isChecked()) score++;

            // Pregunta 3: correcta -> p3_op1
            CheckBox p3_op1 = v.findViewById(R.id.p3_op1);
            if (p3_op1.isChecked()) score++;

            // Pregunta 4: correcta -> p4_op2
            CheckBox p4_op2 = v.findViewById(R.id.p4_op2);
            if (p4_op2.isChecked()) score++;

            // Mostrar fragmento de resultados (elimina el Toast)
            ResultadoFragment resultadoFragment = ResultadoFragment.newInstance(score);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, resultadoFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return v;
    }
}