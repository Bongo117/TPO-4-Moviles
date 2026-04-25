package com.eskere.tpo4.ui.cargar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eskere.tpo4.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializamos el ViewModel y el ViewBinding
        viewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // OBSERVADOR 1: Escucha los mensajes y los muestra en un Toast
        viewModel.getMensajeToast().observe(getViewLifecycleOwner(), mensaje -> {
            if (mensaje != null) {
                Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        // OBSERVADOR 2: Escucha si debe vaciar los EditText tras una carga exitosa
        viewModel.getLimpiarCampos().observe(getViewLifecycleOwner(), limpiar -> {
            if (limpiar != null && limpiar) {
                binding.etCodigo.setText("");
                binding.etDescripcion.setText("");
                binding.etPrecio.setText("");
            }
        });

        // BOTÓN: Captura cruda de los datos y delegación absoluta al ViewModel
        binding.btnGuardar.setOnClickListener(v -> {
            String codigo = binding.etCodigo.getText().toString();
            String descripcion = binding.etDescripcion.getText().toString();
            String precio = binding.etPrecio.getText().toString();

            // Pasamos los strings directo, el ViewModel se encarga de la lógica
            viewModel.guardarProducto(codigo, descripcion, precio);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evita fugas de memoria con el binding
    }
}