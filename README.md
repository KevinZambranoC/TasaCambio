# Gestión de Operaciones Cambiarias - TasaCambio

Este proyecto en Java está diseñado para gestionar las operaciones cambiarias realizadas por clientes entre monedas colombianas (COP) y venezolanas (Bs). La aplicación permite calcular los montos de monedas cambiadas, generar reportes detallados de las transacciones, y listar los clientes con mayor y menor cantidad de COP movilizados.

## Características Principales

- **Interfaz `DatosClientes`:** Define las tasas de cambio y métodos necesarios para separar y procesar los datos de las operaciones de los clientes.

- **Clase `Clientes`:** Almacena la información básica de los clientes, como su código y apellido.

- **Clase `Compra`:** Calcula el monto de COP obtenidos al comprar con Bs.

- **Clase `Venta`:** Calcula el monto de Bs obtenidos al vender COP.

- **Clase `OperacionesPorCliente`:** Almacena todas las operaciones realizadas por un cliente y facilita el cálculo de las monedas movilizadas.

- **Clase `Principal`:** Carga los datos de los clientes, calcula los Bs comprados y vendidos, y lista los clientes con mayor y menor cantidad de COP movilizados.

## Contexto Académico

Este proyecto fue desarrollado como parte de un parcial de la materia **Programación I** en la Universidad Experimental del Táchira (UNET). Su propósito es aplicar conceptos fundamentales de Programación Orientada a Objetos (POO) para resolver un problema real en el contexto de operaciones cambiarias.
