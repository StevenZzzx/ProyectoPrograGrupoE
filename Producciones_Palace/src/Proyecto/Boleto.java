package Proyecto;

/**
 * Esta clase llamada Boleto nos permitira crear los boletos de los eventos para poder comprar como usuario cliente
 */
public class Boleto {
    /**
     * Estos atributos tendra el boleto 
     */
    private Eventos evento;
    private Cliente cliente;
    private int numeroAsiento;

    /**
     * Se inicia el constructor boleto con los siguientes parametros
     * @param evento de tipo Eventos para obtener el evento al que compras
     * @param cliente de tipo Cliente para obtener el cliente que esta comprando
     * @param numeroAsiento de tipo int para saber que asiento esta comprando
     */
    public Boleto(Eventos evento,Cliente cliente, int numeroAsiento){
        this.evento = evento;
        this.cliente = cliente;
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Aqui estan los metodos getter, que obtienen la informacion de los atributos
     * @return retorna el atributo
     */
    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public Eventos getEvento() {
        return evento;
    }

}