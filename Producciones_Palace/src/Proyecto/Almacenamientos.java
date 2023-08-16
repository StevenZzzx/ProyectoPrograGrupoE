package Proyecto;


/**
 * Esta es una clase abstracta que no es permitida ser iniciada y contiene unicamente los metodos vacios necesarios
 * para usarlos en las clases almacenamientos de administradores y clientes
 */
public abstract class Almacenamientos {
    /**
     * 
     * @param nombreUsuario Este parametro de tipo String sera buscado en la LinkedList del tipo de User
     * y hara un print con JOptionPane y toString del nombre de usuario que ingresaste  
     */
    public abstract void consultarUsuario(String nombreUsuario);

    /**
     * 
     * @param nombreUsuario El parametro tipo String sera buscado en la LinkedList del tipo User y si el nombre es igual a uno existente lo eliminara
     */
    public abstract void eliminarUsuario(String nombreUsuario);
    
    /**
     * Este metodo de tipo Users hara un recorrido en la LinkedList y buscara que el nombre de usuario y password sean iguales a los que ingresaste 
     * @param nombreUsuario Este parametro de tipo String sera buscado y comparado para poder hacer login
     * @param password Este parametro de tipo String sera buscado y comparado para poder hacer login
     * @return se hara un return del tipo de User si se encontraron los parametros y sino retornara null
     */
    public abstract Users autenticarUsuario(String nombreUsuario, String password);

    /**
     * Este metodo de tipo boolean hara un recorrido en la LinkedList y buscara que el nombre de usuario sea existente en ese almacenamiento
     * @param nombreUsuario Este parametro de tipo String se compara con los de la LinkedList para saber si existe
     * @return Si el parametro existe se retornara true y sino false
     */
    public abstract boolean verificarUsuarioExistente(String nombreUsuario);
}
