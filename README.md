
# Sistema de Administración de Bibliotecas - Proyecto Final

Este proyecto tiene como objetivo desarrollar un sistema de administración de libros para las bibliotecas de la Universidad Pedagógica y Tecnológica de Colombia (UPTC).

## Integrantes del Proyecto

- Luis Alfonso Rojas Martinez
- Yesid Alejandro Martinez Guerrero

## Requisitos del Sistema

- JDK 17 o superior

## Funcionalidades Clave

### Crear Libros

- Permite agregar libros al sistema.
- Los libros se almacenan en una estructura de árbol AVL para una gestión eficiente.
- Se recopilan datos como título, ISBN, volumen, editorial, información de la biblioteca y datos del autor.

### Eliminar Libro

- Posibilidad de eliminar uno o varios libros utilizando el ISBN y la sede correspondiente.

### Buscar Libro

- Búsqueda por nombre o ISBN del libro, con la opción de especificar la sede.
- Retorna información sobre el libro y la cantidad de copias disponibles.
- Posibilidad de buscar sin especificar la sede, mostrando la información para todas las sedes.

### Listar Libros

- Lista todos los libros en todas las sedes de la universidad.
- Permite listar todos los libros en una sede específica.

## Requisitos No Funcionales

- Los libros se almacenan en una estructura de árbol AVL para un acceso eficiente.
- Se aplican rotaciones para balancear el árbol si se desequilibra al agregar o eliminar libros.
- Si la cantidad de copias de un libro llega a cero, se elimina del árbol y se aplican rotaciones para mantener el equilibrio.
- Se manejan excepciones y se proporcionan mensajes informativos al usuario en caso de errores.

---

_Proyecto desarrollado como parte de la asignatura de Programación 3 - Proyecto Final_

