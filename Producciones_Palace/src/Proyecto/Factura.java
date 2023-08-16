package Proyecto;

import java.util.Date;

import javax.swing.JOptionPane;
/**
 * Esta clase nos permite crear una factura de un evento para un cliente en específico
 */
public class Factura {
    private Eventos evento;
    private Cliente cliente;
    private int numeroAsiento;
    private Date fecha;
    private int cantidadFacturasVendidas;

    /**
     * Constructor para instanciar la clase Factura
     * @param evento Este es el evento al que se refiere la factura
     * @param cliente Este es el cliente que emite la factura
     * @param numeroAsiento Número de asiento asignado al cliente
     * @param fecha La fecha en que se emitió la factura
     */
    public Factura(Eventos evento,Cliente cliente, int numeroAsiento, Date fecha){
        this.evento = evento;
        this.cliente = cliente;
        this.numeroAsiento = numeroAsiento;
        this.fecha = fecha;
        evento.incrementarCantidadFacturasVendidas();
        cantidadFacturasVendidas = evento.getContadorFacturasVendidas();
    }

    //Metodos getter que obtienen los atributos
    public Cliente getCliente() {
        return cliente;
    }

    public Eventos getEvento() {
        return evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public int getCantidadFacturasVendidas() {
        return cantidadFacturasVendidas;
    }

    /**
     * Este metodo muetra en un JOptionPane la información de la factura
     */
    public void informacionFactura(){
        JOptionPane.showMessageDialog(null,
        "Factura hecha el: " + this.fecha + 
        "\nA nombre de " + cliente.getNombre() + " " + cliente.getApellido() + 
        "\n\n" + 
        "\nEl " + evento.agregarFecha(evento.getFecha()) +
        "\nA las " + evento.agregarHora(evento.getHora()) + 
        "\nEn " + evento.getCiudad() + "," + 
        "\n" + evento.getDireccion() +
        "\n" + 
        "\nPrecio: " + evento.getPrecio() + 
        "\nCategoria: " + evento.getCategoria() + 
        "\nAsiento numero: " + this.numeroAsiento + 
        "\n\n");
    }
}