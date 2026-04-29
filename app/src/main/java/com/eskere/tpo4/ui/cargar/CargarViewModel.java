package com.eskere.tpo4.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eskere.tpo4.MainActivity;
import com.eskere.tpo4.modelo.Producto;

public class CargarViewModel extends ViewModel {

    private MutableLiveData<String> mensajeToast = new MutableLiveData<>();

    private MutableLiveData<Boolean> limpiarCampos = new MutableLiveData<>();

    public LiveData<String> getMensajeToast() {
        return mensajeToast;
    }

    public LiveData<Boolean> getLimpiarCampos() {
        return limpiarCampos;
    }

    // Método que recibe los datos CRUDOS desde la vista
    public void guardarProducto(String codigoStr, String descripcion, String precioStr) {


        if (codigoStr.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty()) {
            mensajeToast.setValue("Error: Todos los campos son obligatorios.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoStr);
            double precio = Double.parseDouble(precioStr);

            boolean codigoRepetido = false;
            for (Producto p : MainActivity.listaProductos) {
                if (p.getCodigo() == codigo) {
                    codigoRepetido = true;
                    break;
                }
            }

            if (codigoRepetido) {
                mensajeToast.setValue("Error: El código ya existe.");
            } else {

                Producto nuevoProducto = new Producto(codigo, descripcion, precio);
                MainActivity.listaProductos.add(nuevoProducto);


                mensajeToast.setValue("Producto guardado correctamente");
                limpiarCampos.setValue(true);
            }

        } catch (NumberFormatException e) {
            mensajeToast.setValue("Error: El código y el precio deben ser valores numéricos.");
        }
    }
}