package com.eskere.tpo4.ui.Listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.eskere.tpo4.databinding.FragmentListarBinding;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel viewModel;
    private ProductoAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 1. Configuramos el RecyclerView (LayoutManager vertical es obligatorio)
        binding.rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        // 2. Observamos la lista que preparó el ViewModel
        viewModel.getListaOrdenada().observe(getViewLifecycleOwner(), listaProductos -> {
            if (listaProductos != null) {
                // 3. Cuando llegan los datos ordenados, creamos el Adapter y lo unimos
                adapter = new ProductoAdapter(listaProductos);
                binding.rvProductos.setAdapter(adapter);
            }
        });

        // 4. Le damos la orden al ViewModel para que empiece a trabajar
        viewModel.cargarYOrdenarProductos();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Liberamos la memoria del ViewBinding
    }
}