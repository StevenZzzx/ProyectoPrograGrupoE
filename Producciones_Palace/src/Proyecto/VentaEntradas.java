package Proyecto;

/**
 * Esta interfaz VentaEntradas nos permite definir los métodos para gestionar la venta de boletos de los eventos
 */
public interface VentaEntradas {
    
    /**
     * Este metodo nos funciona para vender un boleto para un evento en específico con un cliente y su número de asiento 
     * @param evento El evento el cual se vendera el boleto
     * @param cliente El cliente que va comprar el boleto
     * @param numeroAsiento El número de asiento que desea comprar el cliente
     * @return si el boleto se vende retornara true y sino retornara false
     */
    boolean venderBoleto(Eventos evento, Cliente cliente, int numeroAsiento);

    /**
     * Este metodo valida si aún hay capacidad disponible en un evento para vender boletos
     * @param evento El evento que se quiere validar
     * @return retornara true si hay capacidad disponible y sino retornara false
     */
    boolean validarCapacidadEvento(Eventos evento);

    /**
     * Este metodo validara si un asiento en un evento está disponible para poder comprar ese boleto
     * @param evento El evento en que se quiere validar el asiento
     * @param numeroAsiento El número de asiento que se quiere validar
     * @return retornara true si el asiento esta disponible y sino retornara false
     */
    boolean validarAsientoDisponible(Eventos evento, int numeroAsiento);
    
    /**
     * Este metodo valida si un cliente cumple con la restricción de edad para el evento
     * @param evento El evento que se quiere validar
     * @param cliente El cliente que se quiere validar si cumple la restricción
     * @return retornara true si el cliente cumple con la restricción y sino retornara false
     */
    boolean validarEdad(Eventos evento, Cliente cliente);
}