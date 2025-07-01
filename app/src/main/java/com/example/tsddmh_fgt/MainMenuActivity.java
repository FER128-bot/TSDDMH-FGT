package com.example.tsddmh_fgt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainMenuActivity extends AppCompatActivity {

    private Button btnAnterior, btnSiguiente;
    private LinearLayout botonesNavegacion;
    private final Fragment[] temas = {
            new Tema1Fragment(),
            new Tema2Fragment(),
            new Tema3Fragment(),
            new Tema4Fragment()
    };
    private int indiceTemaActual = -1; // -1 indica que aún no se ha mostrado un tema

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Referencias a los botones
        btnAnterior = findViewById(R.id.btn_anterior);
        btnSiguiente = findViewById(R.id.btn_siguiente);
        botonesNavegacion = findViewById(R.id.botones_navegacion);

        // Cargar el fragmento del menú principal
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MenuFragment())
                    .commit();
        }

        btnAnterior.setOnClickListener(v -> {
            if (indiceTemaActual > 0) {
                mostrarTema(--indiceTemaActual);
            }
        });

        btnSiguiente.setOnClickListener(v -> {
            if (indiceTemaActual < temas.length - 1) {
                mostrarTema(++indiceTemaActual);
            }
        });

        // Escucha para detectar cambios de fragmento y mostrar u ocultar botones
        getSupportFragmentManager().addOnBackStackChangedListener(this::actualizarBotonesNavegacion);
    }

    // Método que muestra el tema correspondiente
    public void mostrarTema(int indice) {
        if (indice >= 0 && indice < temas.length) {
            indiceTemaActual = indice;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, temas[indice])
                    .addToBackStack(null)
                    .commit();
            actualizarBotonesNavegacion();
        }
    }

    // Mostrar/ocultar botones según fragmento activo
    private void actualizarBotonesNavegacion() {
        Fragment actual = obtenerFragmentoActual();
        boolean esTema = actual instanceof Tema1Fragment ||
                actual instanceof Tema2Fragment ||
                actual instanceof Tema3Fragment ||
                actual instanceof Tema4Fragment;

        botonesNavegacion.setVisibility(esTema ? View.VISIBLE : View.GONE);
    }

    private Fragment obtenerFragmentoActual() {
        FragmentManager fm = getSupportFragmentManager();
        return fm.findFragmentById(R.id.fragment_container);
    }
}