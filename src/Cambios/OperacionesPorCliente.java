package Cambios;

import Suscriptores.Clientes;

public class OperacionesPorCliente {

    private Clientes cliente;
    private int cantOperaciones;
    private Operaciones[] operaciones;
    

    public OperacionesPorCliente() {
        this.cliente = new Clientes();
        this.cantOperaciones = 0;
        this.operaciones = new Operaciones[0];
    }
    

    public OperacionesPorCliente(Clientes cliente, int cantOperaciones, Operaciones[] operaciones) {
        this.cliente = cliente;
        this.cantOperaciones = cantOperaciones;
        this.operaciones = operaciones;
    }
    

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    public Clientes getCliente() {
        return this.cliente;
    }
    
    public void setCantOperaciones(int cantOperaciones) {
        this.cantOperaciones = cantOperaciones;
    }
    
    public int getCantOperaciones() {
        return this.cantOperaciones;
    }
    
    public void setOperaciones(Operaciones[] operaciones) {
        this.operaciones = operaciones;
    }
    
    public Operaciones[] getOperaciones() {
        return this.operaciones;
    }
}