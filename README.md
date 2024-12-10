### Descripción del proyecto

Este proyecto implementa una aplicación para gestionar las reservas de una sala de ensayos, optimizando la selección de ofertas para maximizar las ganancias de la empresa. Las reservas se realizan por horas completas, y cada día se reciben ofertas para el día siguiente, especificando el horario deseado y el monto ofertado. 

La aplicación se encarga de:
- Seleccionar las ofertas de forma que no se superpongan en el tiempo y maximicen las ganancias.
- Almacenar la información de las ofertas en un archivo serializado para su recuperación en sesiones futuras.
- Proveer una interfaz gráfica de usuario para facilitar la interacción.

#### Funcionalidades adicionales:
1. Registrar datos adicionales como nombre del oferente y equipamiento solicitado.
2. Mostrar las ofertas recibidas y adjudicadas en un calendario gráfico.
3. Implementar y comparar algoritmos para resolver el problema de maximización de ganancias: uno en tiempo polinomial y otro utilizando una heurística golosa.
