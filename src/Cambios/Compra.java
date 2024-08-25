package Cambios;

import Data.DatosClientes;

public class Compra extends Operaciones {
    

    public Compra() {
        super();
    }
    

    public Compra(double montoACambiar) {
        super(montoACambiar);
    }
    

    @Override
    public void calcular_cambio() {
        double montoCambiado = getMontoACambiar() * DatosClientes.tasaCompra;
        setMontoCambiado(montoCambiado);
    }
}