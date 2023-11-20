package modelos.usuarios;

public class Cliente extends Usuario{
    
    // Atributo 
    private double saldo;

    // Constructor de la clase Cliente que hereda el super() de la clase padre Usuario
    public Cliente(String nombreUsuario, String claveUsuario, String rolUsuario, double saldo) {
        super(nombreUsuario, claveUsuario, rolUsuario);
        this.saldo = saldo;
    }

    // Getters y Setters de la clase Cliente
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    

    
}
