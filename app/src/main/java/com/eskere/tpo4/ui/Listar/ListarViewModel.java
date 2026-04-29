package com.eskere.tpo4.ui.Listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eskere.tpo4.MainActivity;
import com.eskere.tpo4.modelo.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<List<Producto>> listaOrdenada = new MutableLiveData<>();

    public LiveData<List<Producto>> getListaOrdenada() {
        return listaOrdenada;
    }

    public void cargarYOrdenarProductos() {

        List<Producto> productos = new ArrayList<>(MainActivity.listaProductos);

        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion());
            }
        });

        listaOrdenada.setValue(productos);
    }
}