package Proyecto;

import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * Esta clase es para almacenar los administradores en una linkedlist
 * que extiende de la clase abstracta Almacenamientos
 * esta clase nos permitira registrar, autenticar, consultar, eliminar y verificar la existencia de administradores
 */
public class AlmacenamientoAdministradores extends Almacenamientos {
    /**Atributo LinkedList que almacena objetos de tipo Administrador*/ 
    private LinkedList<Administrador> administradores;

    /**
     * Constructor para iniciar la clase con el almacenamiento LinkedList para los administradores
     * crea la instancia de LinkedList para almacenar los administradores
     */
    public AlmacenamientoAdministradores(){
        administradores = new LinkedList<>();
    }

    /**
     * Metodos para registrar, iniciar sesion, consultar, eliminar y verificar si un usuario ya existe
     * @param nombreUsuario El objeto de tipo Administrador que sera registrado
     */
    public void registrarAdministrador(Administrador nombreUsuario) {
        administradores.add(nombreUsuario);
    }

    @Override
    public void consultarUsuario(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getNombreUsuario().equals(nombreUsuario)) {
                JOptionPane.showMessageDialog(null,admin.toString());
            }
        }
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getNombreUsuario().equals(nombreUsuario)) {
                administradores.remove(admin);
            }
        }
    }
    
    @Override
    public Administrador autenticarUsuario(String nombreUsuario, String password) {
        for (Administrador admin : administradores) {
            if (admin.getNombreUsuario().equals(nombreUsuario) && admin.getPassword().equals(password)) {                
                admin.setEstado(true);
                return admin;
            }
        }
        return null; 
        
    }

    @Override
    public boolean verificarUsuarioExistente(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

}
