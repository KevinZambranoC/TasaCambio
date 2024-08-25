package Cambios;

public abstract class Operaciones {

    private double montoACambiar;
    private double montoCambiado;
    

    public Operaciones() {
        this.montoACambiar = 0.0;
        this.montoCambiado = 0.0;
    }
    

    public Operaciones(double montoACambiar) {
        this.montoACambiar = montoACambiar;
        this.montoCambiado = 0.0;
    }
    

    public void setMontoACambiar(double montoACambiar) {
        this.montoACambiar = montoACambiar;
    }
    
    public double getMontoACambiar() {
        return this.montoACambiar;
    }
    
    public void setMontoCambiado(double montoCambiado) {
        this.montoCambiado = montoCambiado;
    }
    
    public double getMontoCambiado() {
        return this.montoCambiado;
    }
    

    public abstract void calcular_cambio();
}
