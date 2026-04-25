package com.eskere.tpo4.ui.Listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eskere.tpo4.R;
import com.eskere.tpo4.modelo.Producto;

import java.util.List;

// La clase extiende de RecyclerView.Adapter e indica que usará nuestro ViewHolder interno
public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> listaProductos;

    // El constructor recibe la lista de productos que le va a mandar el Fragment
    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Acá "inflamos" (dibujamos) el archivo XML de la tarjetita que creaste
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Acá conectamos los datos del producto actual con los TextView de la tarjeta
        Producto producto = listaProductos.get(position);

        holder.tvDescripcion.setText(producto.getDescripcion());
        holder.tvCodigo.setText("Código: " + producto.getCodigo());
        holder.tvPrecio.setText("Precio: $" + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        // Le avisa al RecyclerView cuántas tarjetas tiene que dibujar en total
        return listaProductos.size();
    }

    // Clase interna ViewHolder que "sostiene" los componentes visuales de la tarjeta
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescripcion, tvCodigo, tvPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Buscamos los IDs exactos que pusiste en tu item_producto.xml
            tvDescripcion = itemView.findViewById(R.id.tvItemDescripcion);
            tvCodigo = itemView.findViewById(R.id.tvItemCodigo);
            tvPrecio = itemView.findViewById(R.id.tvItemPrecio);
        }
    }
}