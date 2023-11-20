package modelos.usuarios;

public class Empleado extends Usuario {
    
    // Constructor de la clase Empleado que herada el super() de la clase padre Usuario
    public Empleado(String nombreUsuario, String claveUsuario, String rolUsuario) {
        super(nombreUsuario, claveUsuario, rolUsuario);
    }
}
