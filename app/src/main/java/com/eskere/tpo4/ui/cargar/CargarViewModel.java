package com.eskere.tpo4.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eskere.tpo4.MainActivity;
import com.eskere.tpo4.modelo.Producto;

public class CargarViewModel extends ViewModel {

    // LiveData para avisarle a la vista qué Toast mostrar
    private MutableLiveData<String> mensajeToast = new MutableLiveData<>();
    // LiveData para avisarle a la vista si debe limpiar las cajas de texto tras un éxito
    private MutableLiveData<Boolean> limpiarCampos = new MutableLiveData<>();

    public LiveData<String> getMensajeToast() {
        return mensajeToast;
    }

    public LiveData<Boolean> getLimpiarCampos() {
        return limpiarCampos;
    }

    // Método que recibe los datos CRUDOS desde la vista
    public void guardarProducto(String codigoStr, String descripcion, String precioStr) {

        // 1. Validar que no haya campos vacíos
        if (codigoStr.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty()) {
            mensajeToast.setValue("Error: Todos los campos son obligatorios.");
            return; // Corta la ejecución, sin usar un return que devuelva datos
        }

        try {
            int codigo = Integer.parseInt(codigoStr);
            double precio = Double.parseDouble(precioStr);

            // 2. Validar que el código no esté repetido
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
                // 3. Si todo está perfecto, crear el producto y guardarlo
                Producto nuevoProducto = new Producto(codigo, descripcion, precio);
                MainActivity.listaProductos.add(nuevoProducto);

                // Avisar a la vista del éxito y pedirle que limpie los campos
                mensajeToast.setValue("Producto guardado correctamente");
                limpiarCampos.setValue(true);
            }

        } catch (NumberFormatException e) {
            mensajeToast.setValue("Error: El código y el precio deben ser valores numéricos.");
        }
    }
}