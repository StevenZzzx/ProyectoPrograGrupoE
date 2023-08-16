package Proyecto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;
/**
 * La clase GestionEntradas implementa las interfaces Facturar y VentaEntradas para poder gestionar la venta de boletos y facturación de eventos
 */
public class GestionEntradas implements Facturar, VentaEntradas{
    
    private LinkedList<Factura> facturas;
    private LinkedList<Boleto> boletos;

    /**
     * Constructor que inicializa las listas de facturas y boletos
     */
    public GestionEntradas() {
        facturas = new LinkedList<>();
        boletos = new LinkedList<>();
    }

    @Override
    public boolean venderBoleto(Eventos evento, Cliente cliente, int numeroAsiento) {
        if (validarCapacidadEvento(evento) && validarAsientoDisponible(evento, numeroAsiento) && validarEdad(evento, cliente)) {
            
            if(!boletos.contains(new Boleto(evento,cliente, numeroAsiento))){
                evento.setCapacidadDisponible(evento.getCapacidadDisponible() - 1);
                evento.getSillas()[numeroAsiento - 1] = 1;

                Boleto boleto = new Boleto(evento, cliente, numeroAsiento);
                boletos.add(boleto);
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Ya has comprado un boleto para este asiento en otro evento.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            return false;
        }    
    }

    @Override
    public boolean validarCapacidadEvento(Eventos evento) {
        if(evento.getCapacidadDisponible() > 0){
            return true;
        }
        JOptionPane.showMessageDialog(null,"Asientos agotados","Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public boolean validarAsientoDisponible(Eventos evento, int numeroAsiento) {
        if (numeroAsiento > 0 && numeroAsiento <= evento.getCapacidadEvento()) {
            return evento.getSillas()[numeroAsiento - 1] == 0;
        } else {
            JOptionPane.showMessageDialog(null,"Asiento ocupado","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean validarEdad(Eventos evento, Cliente cliente) {
        if (evento.getRestriccionEdad()) {
            return cliente.getEdad() >= 18;
        } else {
            JOptionPane.showMessageDialog(null,"El evento es solo para mayores de edad","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public void facturarEvento(Eventos evento,Cliente cliente, int numeroAsiento) {
        Date fechaFactura = new Date();
        Factura factura = new Factura(evento, cliente, numeroAsiento, fechaFactura);
        facturas.add(factura);
        factura.informacionFactura();
    }

    @Override
    public void anularFactura(Factura nombreFactura) {
        for(Factura factura : facturas){
            if(factura.equals(nombreFactura)){
                Eventos evento = factura.getEvento();
                evento.getSillas()[factura.getNumeroAsiento() - 1] = 0;
                evento.setCapacidadDisponible(evento.getCapacidadDisponible() + 1);
                facturas.remove(factura);
            }
        }
    }

    @Override
    public void mostrarFacturas() {
        for(Factura factura : facturas){
            factura.informacionFactura();
        }
    }
    
    
    @Override
    public void masVentasDelDia() {
        LocalDate fechaActual = LocalDate.now();
        int maxFacturasVendidas = 0;
        Eventos eventoMasVendido = null;
        
        for(Factura factura : facturas){
            LocalDate fechaFactura = factura.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(fechaFactura.isEqual(fechaActual)){
                int masVendidosHoy = factura.getCantidadFacturasVendidas();
                if(masVendidosHoy > maxFacturasVendidas){
                    maxFacturasVendidas = masVendidosHoy;
                    eventoMasVendido = factura.getEvento();
                }
            }
        }
        
        if (eventoMasVendido != null) {
                    JOptionPane.showMessageDialog(null, "El evento con más ventas del día fue: " + eventoMasVendido.getnombreEvento() +
                    "\nCantidad de entradas vendidas fue de: " + maxFacturasVendidas + " entradas");
                } else {
                    JOptionPane.showMessageDialog(null, "No se han realizado ventas en el día.");
                }
    }

    @Override
    public void masGananciaDeLaSemana() {
        Date fechaActual = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date fechaSemanaPasada = calendar.getTime();
        
        double maxGanancia = 0;
        Eventos eventoMayorGanancia = null;
        
        for (Factura factura : facturas) {
            Date fechaFactura = factura.getFecha();
            
            if (fechaFactura.after(fechaSemanaPasada) && fechaFactura.before(fechaActual)) {
                double ganancia = factura.getCantidadFacturasVendidas() * factura.getEvento().getPrecio();
                if (ganancia > maxGanancia) {
                    maxGanancia = ganancia;
                    eventoMayorGanancia = factura.getEvento();
                }
            }
        }
        
        if (eventoMayorGanancia != null) {
            JOptionPane.showMessageDialog(null, "El evento con mayor ganancia de la semana fue: " + eventoMayorGanancia.getnombreEvento() +
                    "\nUna Ganancia total de: " + maxGanancia + "$");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha generado ganancia en la semana.");
        }
    }

    /**
     * Este metodo busca un boleto en la lista de boletos
     * @param evento evento al que se compro el boleto
     * @param cliente cliente que compro el boleto
     * @param numeroAsiento número de asiento del boleto
     * @return retorna true si el boleto si existe y sino retornara false
     */
    public boolean buscarBoleto(Eventos evento,Cliente cliente, int numeroAsiento){
        for (Boleto boleto : boletos) {
            if (boleto.getEvento().equals(evento) && boleto.getCliente().equals(cliente) && boleto.getNumeroAsiento() == numeroAsiento) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Este metodo busca una factura en la lista de facturas
     * @param cliente cliente que emitio la factura
     * @param numeroAsiento número de asiento al que se facturó
     * @return
     */
    public Factura buscarFactura(Cliente cliente, int numeroAsiento){
        for (Factura factura : facturas) {
            if (factura.getNumeroAsiento() == numeroAsiento && factura.getCliente().equals(cliente)) {
                return factura;
            }
        }
        return null;
    }

}
