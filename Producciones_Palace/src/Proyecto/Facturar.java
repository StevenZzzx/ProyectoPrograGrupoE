package Proyecto;

/**
 * Esta interfaz nos permite definir los métodos para poder gestionar las facturaciones de los eventos
 * y tambien nos permite gestionar más ventas del dia y más ganancia de la semana
 */
public interface Facturar {

    /**
     * Este metodo factura un evento para un cliente y un número de asiento específico
     * @param evento Evento al que se va a facturar
     * @param cliente El cliente que emitirá la factura
     * @param numeroAsiento Numero de haciento que registro el cliente a la hora de la compra
     */
    void facturarEvento(Eventos evento, Cliente cliente, int numeroAsiento);

    /**
     * Este metodo anulara una factura
     * @param factura este parametro sera la factura que deseas anular
     */
    void anularFactura(Factura factura);

    /**
     * Este metodo muestra la lista de facturas
     */
    void mostrarFacturas();

    /**
     * Muestra las ventas con mayor cantidad de ventas en el día
     */
    void masVentasDelDia();

    /**
     * Muestra sobre la venta con mayor ganancia en la semana
     */
    void masGananciaDeLaSemana();
}
