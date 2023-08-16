package Proyecto;

/**
 * Esta es una clase abstracta que no se permite ser instanciada con ella misma, solo con sus clases hijas
 * la cuales son administradores y clientes, contiene los atributos necesarios para estas clases
 */
public abstract class Users {
    private String nombre;
    private String apellido;
    private int edad;
    private String nombreUsuario;
    private String password;
    private String email;
    private boolean estado;

    /**
     * Constructor de los users con los siguientes parametros
     * @param nombre El nombre del usuario
     * @param apellido El apellido del usuario
     * @param edad La edad del usuario
     * @param nombreUsuario Nombre de usuario del usuario 
     * @param password Contraseña del usuario
     * @param email Correo del usuario
     */
    public Users(String nombre, String apellido,int edad, String nombreUsuario, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    //Aqui estan los getters que retornan la informacion y los setters que modifican el atributo
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * un metodo de tipo string que retorna la informacion del user creado
     * @return retorna en cadena la información del user
     */
    public String toString(){
        return "\nNombre: " + this.nombre + 
        "\nApellidos: " + this.apellido + 
        "\nNombre de Usuario: " + this.nombreUsuario + 
        "\nEdad: " + this.edad +
        "\nCorreo: " + this.email + 
        "\nEstado: " + this.estado;
    }
}
