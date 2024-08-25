package Programa;

import Data.DatosClientes;
import Suscriptores.Clientes;
import Cambios.*;
import java.text.DecimalFormat;

public class Principal implements DatosClientes {

    private String[] clientes;
    private Clientes[] vectorClientes;
    private OperacionesPorCliente[] vectorOperacionesPorCliente;
    
    private static final DecimalFormat df = new DecimalFormat("#,###.00");

    @Override
    public void separar() {
        vectorClientes = new Clientes[clientes.length];
        vectorOperacionesPorCliente = new OperacionesPorCliente[clientes.length];
        
        for (int i = 0; i < clientes.length; i++) {
            String[] datosCliente = clientes[i].split("-");
            String apellido = datosCliente[0];
            String codigo = datosCliente[1];
            int cantOperaciones = Integer.parseInt(datosCliente[2]);
            
            Clientes cliente = new Clientes(codigo, apellido);
            Operaciones[] operaciones = new Operaciones[cantOperaciones];
            
            String[] operacionesArray = datosCliente[3].split("/");
            
            for (int j = 0; j < cantOperaciones; j++) {
                String[] datosOperacion = operacionesArray[j].split(",");
                int tipoOperacion = Integer.parseInt(datosOperacion[0]);
                double monto = Double.parseDouble(datosOperacion[1]);
                
                if (tipoOperacion == 1) {
                    operaciones[j] = new Compra(monto);
                } else {
                    operaciones[j] = new Venta(monto);
                }
                operaciones[j].calcular_cambio();
            }
            
            vectorClientes[i] = cliente;
            vectorOperacionesPorCliente[i] = new OperacionesPorCliente(cliente, cantOperaciones, operaciones);
        }
    }

    @Override
    public void imprimir() {
        int count1 = 1;
        
        for (OperacionesPorCliente opCliente : vectorOperacionesPorCliente) {
            double totalBsComprados = 0;
            double totalBsVendidos = 0;
            
            for (Operaciones operacion : opCliente.getOperaciones()) {
                if (operacion instanceof Compra) {
                    totalBsVendidos += operacion.getMontoACambiar();
                } else if (operacion instanceof Venta) {
                    totalBsComprados += operacion.getMontoCambiado();
                }
            }
            
            String totalBsCompradosFormatted = totalBsComprados == 0 ? "0,00" : df.format(totalBsComprados);
            String totalBsVendidosFormatted = totalBsVendidos == 0 ? "0,00" : df.format(totalBsVendidos);
            
            System.out.println("A. Cliente " + count1 + ": " + opCliente.getCliente().getApellido() +
                           " (Código: " + opCliente.getCliente().getCodigo() + ")" +
                           " - Total de Operaciones: " + opCliente.getCantOperaciones() +
                           " - Total Bs Comprados: " + totalBsCompradosFormatted + 
                           " - Total Bs Vendidos: " + totalBsVendidosFormatted);
        
            count1++;
        }
    }

    public void mayor_operacion() {
        int totalCompras = 0;
        int totalVentas = 0;
        
        for (OperacionesPorCliente opCliente : vectorOperacionesPorCliente) {
            for (Operaciones operacion : opCliente.getOperaciones()) {
                if (operacion instanceof Compra) {
                    totalCompras++;
                } else if (operacion instanceof Venta) {
                    totalVentas++;
                }
            }
        }
        
        if (totalCompras > totalVentas) {
            System.out.println("B. La operación con mayor cantidad es: Compras");
        } else if (totalVentas > totalCompras) {
            System.out.println("B. La operación con mayor cantidad es: Ventas");
        } else {
            System.out.println("B. Ambas operaciones (Compras y Ventas) tienen la misma cantidad de transacciones");
        }
    }

    public void menor_operacion() {
        double menorCOP = Double.MAX_VALUE;
        String[] clientesMenores = new String[vectorOperacionesPorCliente.length];
        int count = 0;
    
        for (OperacionesPorCliente opCliente : vectorOperacionesPorCliente) {
            double totalCOPComprados = 0;
            double totalCOPVendidos = 0;
        
            for (Operaciones operacion : opCliente.getOperaciones()) {
                if (operacion instanceof Compra) {
                    totalCOPComprados += operacion.getMontoCambiado();
                } else if (operacion instanceof Venta) {
                    totalCOPVendidos += operacion.getMontoACambiar();
                }
            }
        
            double totalCOPMovilizados = totalCOPComprados + totalCOPVendidos;
        
            if (totalCOPMovilizados < menorCOP) {
                menorCOP = totalCOPMovilizados;
                count = 0;
                clientesMenores[count++] = opCliente.getCliente().getApellido();
            } else if (totalCOPMovilizados == menorCOP) {
                clientesMenores[count++] = opCliente.getCliente().getApellido();
            }
        }
    
        StringBuilder resultado = new StringBuilder("C. El(los) cliente(s) con menor cantidad de COP movilizados es(son): ");
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                resultado.append(", ");
            }
            resultado.append(clientesMenores[i]);
        }
    
        System.out.println(resultado.toString());
    }

    public static void main(String[] args) {
        Principal programa = new Principal();
        
        programa.clientes = new String[]{
            "Perez-123-5-1,1000000/2,50000000/2,80000000/1,25000000/1,100000000/",
            "Avalos-456-1-1,175000000/",
            "Cote-789-4-1,100000/1,600000/2,43000000/2,350000000/",
            "Castillo-159-2-1,300000/2,700000/"
        };
        
        programa.separar();
        programa.imprimir();
        programa.mayor_operacion();
        programa.menor_operacion();
    }
}