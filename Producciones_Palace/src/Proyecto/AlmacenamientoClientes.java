package Proyecto;

import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * Esta clase es para almacenar los clientes en una linkedlist
 * que extiende de la clase abstracta Almacenamientos
 * esta clase nos permitira registrar, autenticar, consultar, eliminar y verificar la existencia de clientes
 */
public class AlmacenamientoClientes extends Almacenamientos {
    /**Atributo LinkedList que almacena objetos de tipo Cliente*/
    private LinkedList<Cliente> clientes;

    /**
     * Constructor para iniciar la clase con el almacenamiento LinkedList para los clientes
     * crea la instancia de LinkedList para almacenar los clientes
     */
    public AlmacenamientoClientes(){
        clientes = new LinkedList<>();
    }

    /**
     * Metodos para registrar, iniciar sesion, consultar, eliminar y verificar si un usuario ya existe
     * @param nombreUsuario El objeto de tipo Cliente que sera registrado
     */
    public void registrarCliente(Cliente nombreUsuario) {
        clientes.add(nombreUsuario);
    }
    
    @Override
    public void consultarUsuario(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                JOptionPane.showMessageDialog(null,cliente.toString());
            }
        }
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                clientes.remove(cliente);
            }
        }
    }
    
    @Override
    public Cliente autenticarUsuario(String nombreUsuario, String password) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equals(nombreUsuario) && cliente.getPassword().equals(password)) {                
                cliente.setEstado(true);
                return cliente;
            }
        }
        return null; 
        
    }

    @Override
    public boolean verificarUsuarioExistente(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String nombreUsuario){
        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                return cliente;
            }
        }
        return null;
    }
}
