package Proyecto;

import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * Esta clase nos servira para almacenar los eventos en una LinkedList
 * la clase nos permitira registrar, editar, ver, inactivar y buscar eventos
 */
public class AlmacenamientoEventos{
    /**Atributo LinkedList que almacena objetos de tipo Eventos*/
    private LinkedList<Eventos> eventos;

    /**
     * Constructor para iniciar la clase con el almacenamiento LinkedList para los eventos
     * crea la instancia de LinkedList para almacenar los eventos
     */
    public AlmacenamientoEventos(){
        eventos = new LinkedList<>();
    }

    /**
     * 
     * @param nombreEvento El objeto de tipo Eventos sera registrado
     */
    public void registrarEvento(Eventos nombreEvento){
        eventos.add(nombreEvento);
    }

    /**
     * 
     * @param nombreEvento El parametro de tipo String sera buscado en la LinkedList eventos para editarlo
     */
    public void editarEvento(String nombreEvento){
        for(Eventos evento : eventos){

            if(evento.getnombreEvento().equals(nombreEvento)){
                String nombre = JOptionPane.showInputDialog(null, "Edite el nombre del evento:");
                String ciudad = JOptionPane.showInputDialog(null, "Edite el nombre de la ciudad del evento: ");
                String direccion = JOptionPane.showInputDialog(null, "Edite la direccion del evento: ");
                String categoria = JOptionPane.showInputDialog(null, "Edite la categoria del evento: ");
                int capacidadDelEvento = Integer.parseInt(JOptionPane.showInputDialog(null, "Edite la capacidad del evento: "));

                int Restriccion = (JOptionPane.showOptionDialog(null,
                "Edite si el evento es apto para todo publico o solo mayores de edad",
                "Mayores de edad o Apto para todo publico",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Mayores de edad", "Apto para todo publico"},
                "Apto para todo publico"));
                
                boolean RestriccionEdad = (Restriccion == JOptionPane.YES_OPTION);

                int Year = Integer.parseInt(JOptionPane.showInputDialog(null, "Edite el año del evento: "));
                int Month = Integer.parseInt(JOptionPane.showInputDialog(null, "Edite el mes del evento: "));
                int Day = Integer.parseInt(JOptionPane.showInputDialog(null, "Edite el dia del evento: "));
                
                Date fecha = new Date(Year, Month, Day); 
                

                evento.setNombreEvento(nombre);
                evento.setCiudad(ciudad);
                evento.setDireccion(direccion);
                evento.setCategoria(categoria);
                evento.setCapacidadEvento(capacidadDelEvento);
                evento.setRestriccionEdad(RestriccionEdad);
                evento.setFecha(fecha);
            }
        }
    }

    /**
     * En este metodo se llamara y recorrera la LinkedList de eventos y hara un print con JOptionPane del toString de Eventos
     */
    public void verEventos(){
        for(Eventos evento : eventos){
            JOptionPane.showMessageDialog(null,evento.toString());
        }
    }

    /**
     * 
     * @param nombreEvento El parametro de tipo String sera buscado en la LinkedList eventos para inacitvar ese evento en específico
     */
    public void inactivarEvento(String nombreEvento){
        for(Eventos evento : eventos){
            if(evento.getnombreEvento().equals(nombreEvento)){
                eventos.remove(evento);
            }
        }
    }

    /**
     * 
     * @param nombreEvento El parametro de tipo String sera buscado en la LinkedList eventos para obtener ese evento en específico
     * @return y retornara el evento si lo encuentra y sino retornara null
     */
    public Eventos buscarEvento(String nombreEvento){
        for (Eventos evento : eventos) {
            if (evento.getnombreEvento().equals(nombreEvento)) {
                return evento;
            }
        }
        return null;
    }
}
