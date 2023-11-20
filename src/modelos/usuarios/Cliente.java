package modelos.usuarios;

public class Cliente extends UsuarioBase{
    
    // Atributo 
    private double saldo;

    // Constructor de la clase Cliente que hereda el super() de la clase padre Usuario
    public Cliente(String nombreUsuario, String claveUsuario, double saldo) {
        super(nombreUsuario, claveUsuario);
        this.saldo = saldo;
    }

    // Getters y Setters de la clase Cliente
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

   // Implementación del método getRol para Cliente
   @Override
   public String getTipoUsuario() {
       return "Cliente";
   }

    
}
