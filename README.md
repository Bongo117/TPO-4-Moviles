# TPO 4 - Móviles

Esta es una aplicación para Android que permite cargar productos en una lista estática en memoria y mostrarlos ordenados alfabéticamente.

## Funcionalidad

*   **Cargar:** Tiene un formulario para ingresar el código, descripción y precio de un producto. Valida que no dejes campos vacíos y que no repitas el código de un producto que ya existe.
*   **Listar:** Muestra todos los productos cargados usando un `RecyclerView` con tarjetas personalizadas (`MaterialCardView`). La lista ya se muestra ordenada alfabéticamente por la descripción.
*   **Salir:** Interceptamos el botón de salir del menú para que no cambie de pantalla, sino que levante un cuadro de confirmación nativo (`AlertDialog`) preguntando si estás seguro de cerrar la app.

## Usa la arquitectura MVVM

*   **Modelo:** La clase `Producto` define la estructura de los datos. El almacenamiento en memoria se maneja a través de una lista estática ubicada en `MainActivity`.
*   **Vistas (Views):** 
    *   `CargarFragment`: Se utiliza para capturar los textos ingresados por el usuario en el formulario y delegarlos al ViewModel. También observa los resultados para mostrar alertas (`Toast`).
    *   `ListarFragment`: Renderiza los datos en pantalla utilizando un `RecyclerView` conectado a `ProductoAdapter`.
    *   `MainActivity`: Gestiona los menús de navegación y maneja la intercepción del botón salir.
*   **ViewModels:** 
    *   `CargarViewModel`: Realiza toda la lógica de validación de campos vacíos, verificación de códigos repetidos, parseo de datos y guardado del nuevo producto.
    *   `ListarViewModel`: Se encarga de la lógica de negocio para obtener los productos y ordenarlos alfabéticamente.
*   **Comunicación:** Los ViewModels procesan la información y exponen los resultados utilizando `LiveData`. Las Vistas simplemente observan estos contenedores y reaccionan a los cambios.
## Integrantes del grupo

*   Soto Vela Luciano Ezequiel - DNI: 42799718
*   Grippo Federico - DNI: 44752589
