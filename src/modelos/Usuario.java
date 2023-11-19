package modelos;

public class Usuario {

    // Atributos 
    private String nombreUsuario;
    private String claveUsuario;
    private String rolUsuario;

    // Constructor
    public Usuario(String nombreUsuario, String claveUsuario, String rolUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
        this.rolUsuario = rolUsuario;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getClaveUsuario() {
        return this.claveUsuario;
    }
    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    public String getRolUsuario() {
        return this.rolUsuario;
    }
    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    // Metodo toString()
    @Override
    public String toString() {
        return "Usuario [nombreUsuario=" + nombreUsuario + 
                ", rolUsuario=" + rolUsuario + "}";
    }

    

}
