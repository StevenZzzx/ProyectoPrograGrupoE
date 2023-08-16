package Proyecto;

/* Clase que extiende de Users que es una clase abstracta para poder iniciar nuestro Admin*/
public class Administrador extends Users{

    /**
     * Constructor para iniciar la clase con los siguientes parametros
     * @param nombre Parametro de tipo String 
     * @param apellido Parametro de tipo String
     * @param edad Parametro de tipo int
     * @param nombreUsuario Parametro de tipo String
     * @param password Parametro de tipo String
     * @param email Parametro de tipo String 
     * El super nos permite obtener los atributos de la clase Padre Users y asi ser instanciada
     */
    public Administrador(String nombre, String apellido, int edad, String nombreUsuario, String password, String email) {
        super(nombre, apellido, edad, nombreUsuario, password, email);
    }   
}
