# TPO 4 - Móviles

Aplicación Android desarrollada para la gestión de una lista de productos almacenada en memoria, con funcionalidades de validación y ordenamiento.

## Funcionalidades principales

* **Carga de datos:** Formulario para el ingreso de código, descripción y precio. Incluye validaciones para campos obligatorios y control de códigos duplicados.
* **Visualización:** Listado de productos ordenado alfabéticamente por descripción mediante un RecyclerView y MaterialCardView.
* **Control de navegación:** Implementación de un cuadro de diálogo (AlertDialog) para confirmar la salida de la aplicación.

## Arquitectura (MVVM)

El proyecto sigue el patrón arquitectónico Model-View-ViewModel:

* **Modelo:** Clase de datos `Producto` y persistencia temporal mediante una lista estática.
* **Vistas:** * `CargarFragment`: Captura de datos y retroalimentación mediante Toasts.
  * `ListarFragment`: Renderizado de la lista de productos.
  * `MainActivity`: Gestión del menú y control de cierre.
* **ViewModels:**
  * `CargarViewModel`: Lógica de validación, parseo y almacenamiento.
  * `ListarViewModel`: Lógica de obtención y ordenamiento de datos.
* **Comunicación:** Uso de `LiveData` para el envío de información desde los ViewModels hacia las Vistas.

## Integrantes

* Soto Vela Luciano Ezequiel - DNI: 42799718
* Grippo Federico - DNI: 44752589
