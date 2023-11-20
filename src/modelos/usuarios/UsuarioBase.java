package modelos.usuarios;

import interfaces.Usuario;

public abstract class UsuarioBase implements Usuario {

    // Atributos
    private String nombreUsuario;
    private String claveUsuario;

    // Constructor
    public UsuarioBase(String nombreUsuario, String claveUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }

    // Setters
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    // Metodos de la interfaz
    public String getNombreUsuario(){
        return this.nombreUsuario;
    };

    public String getClaveUsuario(){
        return this.claveUsuario;
    };

    // Este meotdo sera implementado por las clases hijas
    public abstract String getTipoUsuario();

    // Metodo toString()
    @Override
    public String toString() {
        return "Usuario [nombreUsuario=" + this.nombreUsuario +
                ", rolUsuario=" + this.getTipoUsuario() + "}";
    }

}
