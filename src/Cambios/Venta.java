package Cambios;

import Data.DatosClientes;

public class Venta extends Operaciones {

    public Venta(double montoACambiar) {
        super(montoACambiar);
    }

    @Override
    public void calcular_cambio() {
        double montoCambiado = getMontoACambiar() / DatosClientes.tasaVenta;
        setMontoCambiado(montoCambiado);
    }
}
