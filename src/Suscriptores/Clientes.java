package Suscriptores;

public class Clientes {
    
    private String codigo;
    private String apellido;
    
    public Clientes() {
        this.codigo = "";
        this.apellido = "";
    }
    
    public Clientes(String codigo, String apellido) {
        this.codigo = codigo;
        this.apellido = apellido;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getApellido() {
        return this.apellido;
    }
}
