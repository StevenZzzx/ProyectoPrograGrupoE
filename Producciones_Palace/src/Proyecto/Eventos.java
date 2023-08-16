package Proyecto;

import java.util.Date;

/**
 * Esta clase Eventos nos permitira crear los eventos del sistema
 */
public class Eventos {
    private String nombreEvento;
    private String ciudad;
    private String direccion;
    private String categoria;
    private boolean restriccionEdad;
    private Date fecha;
    private Date hora;
    private int capacidadEvento;
    private int capacidadDisponible;
    private double precio;
    private int [] Sillas; 
    private int contadorFacturasVendidas = 0;

    /**
     * Este es el constructor para poder instanciar y crear el evento
     * @param nombreEvento Nombre del evento
     * @param ciudad Ciudad donde sera el evento
     * @param direccion Dirección del evento
     * @param categoria Categoría del evento
     * @param fecha Fecha en la que sera el evento
     * @param hora Hora a la que sera el evento
     * @param restriccionEdad Indica si hay restricción de edad 
     * @param capacidadEvento Capacidad total de asistentes 
     * @param precio Precio de entrada al evento
     */
    public Eventos(String nombreEvento, String ciudad, String direccion, String categoria, Date fecha,Date hora, boolean restriccionEdad, int capacidadEvento, double precio) {
        this.nombreEvento = nombreEvento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.restriccionEdad = restriccionEdad;
        this.capacidadEvento = capacidadEvento;
        this.capacidadDisponible = capacidadEvento;
        this.precio = precio;
        this.Sillas = new int[this.capacidadEvento];
    }

    // Metodos getter y setter para obtnenr y modificar los atributos
    public int getContadorFacturasVendidas() {
        return contadorFacturasVendidas;
    }
    
    public String getnombreEvento(){
        return nombreEvento;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public Date getHora() {
        return hora;
    }
    
    public boolean getRestriccionEdad() {
        return restriccionEdad;
    }
    
    public int getCapacidadEvento() {
        return capacidadEvento;
    }
    
    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public int[] getSillas() {
        return Sillas;
    }
    
    public void setFecha(Date nuevaFecha) {
        this.fecha = nuevaFecha;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setCapacidadEvento(int capacidadEvento) {
        this.capacidadEvento = capacidadEvento;
    }
    
    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setRestriccionEdad(boolean restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setSillas(int[] sillas) {
        Sillas = sillas;
    }
    
    /**
     * Incrementa el contador de facturas vendidas
     *
     * @return Contador de facturas vendidas
     */
    public int incrementarCantidadFacturasVendidas() {
        return this.contadorFacturasVendidas++;
    }

    /**
     * Hace la fecha en formato legible 
     * @param fecha fecha de tipo Date que se quiere formatear
     * @return Retorna en formato "Día del Mes del Año"
     */
    public String agregarFecha(Date fecha){
        String fechaString = fecha.getDay()+" del "+fecha.getMonth()+" del "+fecha.getYear();
        return fechaString;
    }

    /**
     * Hace la hora en formato legible
     * @param hora hora de tipo Date que se quiere formatear
     * @return retorna en formato "Horas:Minutos"
     */
    public String agregarHora(Date hora){
        String horaString = hora.getHours() + ":" + hora.getMinutes();
        return horaString;
    }

    /**
     * Retorna un mensaje indicando si el evento es apto para todas las edades o si tiene restricción de edad
     * @param Mayor este parametro indica si el evento tiene restricción de edad
     * @return retorna un mensaje de si el evento es apto o no para todo publico
     */
    private String esMayor(boolean Mayor){
        String esMas18;
        return esMas18 = (Mayor) ? "Mayores de edad" : "Apto para todo publico";
    }
    
    /**
     * Crea un String de la información del evento
     * @return retorna la cadena de la info deletorna un mensaje indicando si el evento es apto para todas las edades o si tiene restricción de edad evento
     */
    public String toString(){
        return this.nombreEvento +
            "\nEn " + this.ciudad + "," +
            "\n" + this.direccion +
            "\nEl " + agregarFecha(this.fecha) +
            "\nA las " + agregarHora(this.hora) + 
            "\n\n" + "Restriccion de edad: " + esMayor(this.restriccionEdad) +
            "\nPrecio: " + this.precio + 
            "\nCategoria: " + this.categoria + 
            "\nEspacios disponibles: " + this.capacidadDisponible + "\n\n";
    }
}