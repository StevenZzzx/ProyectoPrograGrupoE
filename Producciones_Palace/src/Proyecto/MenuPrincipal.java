package Proyecto;

import java.sql.Time;
import java.util.Date;
import javax.swing.*;


/**
 * Esta clase MenuPrincipal es el menú de interacción con los usuarios y la gestión de eventos, usuarios y facturación
 */
public class MenuPrincipal {
    //Aqui se instancian los almacenamientos para los usuarios, eventos, boletos y facturas
    AlmacenamientoAdministradores admins = new AlmacenamientoAdministradores();
    AlmacenamientoClientes clientes = new AlmacenamientoClientes();
    AlmacenamientoEventos eventos = new AlmacenamientoEventos();
    GestionEntradas entradas = new GestionEntradas();
    
    /**
     * Aqui se muestra el Menu de los administradores con las siguientes opciones
     * Control de usuarios, Control de eventos, Control de facturas y reportes
     */
    public void MenuPrincipalAdmin(){
        Object[] options = { 
        "Control Usuarios",
        "Control Eventos",
        "Control Facturas y reportes",
        "Salir"};

        while (true) {
            int elegir = JOptionPane.showOptionDialog(null, "Seleccione que opcion quieres", "Menu Administrador",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (elegir == 0) {
                ControlUsuarios();
                break;
            }else if (elegir == 1){
                ControlEventos();
                break;
            }else if (elegir == 2){
                ControlFacturasReportes(); 
                break;
            }else{
                Main();
                break;
            }
        }
    }

    /**
     * Este es el menu para el control de eventos 
     */
    public void ControlEventos(){
        Object[] options = {"Agregar Evento", "Editar evento","Ver eventos","Inactivar Evento","Salir"};

        while (true) {
            int elegir = JOptionPane.showOptionDialog(null, "Seleccione que opcion quieres", "Menu Administrador",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
             if (elegir == 0) {
                RegistrarEvento();
                break;
            }else if (elegir == 1) {
                String nombreEvento = JOptionPane.showInputDialog(null, "Escribe el nombre del evento que deseas editar");
                eventos.editarEvento(nombreEvento);
            }else if (elegir == 2){
                eventos.verEventos();
            }else if (elegir == 3){
                String eliminarEvento = JOptionPane.showInputDialog(null, "Escribe el nombre del evento que deseas inactivar");
                eventos.inactivarEvento(eliminarEvento);
            }else{
                MenuPrincipalAdmin();
                break;
            }
        }
    }

    /**
     * Este es el menu para el control de usuarios 
     */
    public void ControlUsuarios(){
        Object[] options = {"Consultar Administrador", "Consultar Cliente","Eliminar Cliente", "Eliminar Administrador","Salir"};

        while (true) {
            int elegir = JOptionPane.showOptionDialog(null, "Seleccione que opcion quieres", "Menu Administrador",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
             if (elegir == 0) {
                String nombreAdmin = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario que deseas consultar");
                admins.consultarUsuario(nombreAdmin);
            }else if (elegir == 1) {
                String nombreCliente = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario que deseas consultar");
                clientes.consultarUsuario(nombreCliente);
            }else if (elegir == 2){
                String eliminarCliente = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario que deseas eliminar");
                clientes.eliminarUsuario(eliminarCliente);
            }else if (elegir == 3){
                String eliminarAdmin = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario que deseas eliminar");
                admins.eliminarUsuario(eliminarAdmin);
            }else{
                MenuPrincipalAdmin();
                break;
            }
        }
    }

    /**
     * Este es el menu para el control de facturas y reportes
     */
    public void ControlFacturasReportes(){
        Object[] options = {"Hacer Factura","Ver Facturas","Anular Factura","Reporte de mas ventas del dia","Reporte de mas ganancia de la semana","Salir"};

        while (true) {
            int elegir = JOptionPane.showOptionDialog(null, "Seleccione que opcion quieres", "Menu Administrador",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
             if (elegir == 0) {
                crearFactura();
                break;
            }else if (elegir == 1) {
                entradas.mostrarFacturas();
            }else if (elegir == 2){
                anularFactura();
                break;
            }else if (elegir == 3){
                entradas.masVentasDelDia();
            }else if (elegir == 4){
                entradas.masGananciaDeLaSemana();
            }else{
                MenuPrincipalAdmin();
                break;
            }
        }
    }
    
    /**
     * Este es el menu principal cuando inicias sesión como usuario cliente
     */
    public void MenuPrincipalCliente(){
        Object[] options = { "Comprar Entrada","Ver Eventos", "Salir"};

        while (true) {
            int elegir = JOptionPane.showOptionDialog(null, "Seleccione que opcion quieres", "Menu Boleteria",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (elegir == 0) {
                ComprarBoleto();
            }else if (elegir == 1) {
                eventos.verEventos();
            }else{
                Main();
                break;   
            }
        }

    }

    /**
     * Este metodo es para comprar el boleto y hacer las comparaciones de la gestion de entradas 
     */
    public void ComprarBoleto(){

        String nombreEvento = JOptionPane.showInputDialog(null, "Escribe el nombre del evento para comprar un boleto:");

        Eventos eventoSeleccionado = eventos.buscarEvento(nombreEvento);

        if (eventoSeleccionado != null) {
  
            int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de asiento que desea reservar:"));

            String nombreCliente = JOptionPane.showInputDialog(null, "Escribe el nombre de tu usuario:");
            Cliente cliente = clientes.buscarCliente(nombreCliente);

            boolean comprado = entradas.venderBoleto(eventoSeleccionado, cliente, numeroAsiento);

            if (comprado) {
                JOptionPane.showMessageDialog(null, "Compra de boleto exitosa. Disfruta el evento!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la compra del boleto. Verifica la disponibilidad y restricciones del evento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El evento ingresado no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Este metodo es para crear las facturas y asi hacer las comparaciones de la gestion de entradas
     */
    public void crearFactura(){
        while(true){
            try{
                String nombreEvento = JOptionPane.showInputDialog(null, "Escribe el nombre del evento");
                String nombreCliente = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario del cliente a facturar:");
                int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de asiento que compro el cliente:"));

                Cliente cliente = clientes.buscarCliente(nombreCliente);
                Eventos evento = eventos.buscarEvento(nombreEvento);
                
                if (entradas.buscarBoleto(evento,cliente,numeroAsiento)) {
                    entradas.facturarEvento(evento,cliente, numeroAsiento);
                    JOptionPane.showMessageDialog(null, "Factura exitosa");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Aun no has comprado el boleto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error en el formato numérico. Favor que sean numéricos");
                ControlFacturasReportes();
                break;
            }
        }
    }

    /**
     * Este metodo sera para anular las facturas que hace las comparaciones que se utilizo en gestión de entradas 
     */
    public void anularFactura(){
        while(true){
            try {
                String nombreCliente = JOptionPane.showInputDialog(null, "Escribe el nombre de usuario del cliente a facturar:");
                int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de asiento que compro el cliente:")); 

                Cliente cliente = clientes.buscarCliente(nombreCliente);
                Factura factura = entradas.buscarFactura(cliente,numeroAsiento);

            
                if (factura != null) {
                    entradas.anularFactura(factura);
                    JOptionPane.showMessageDialog(null, "Factura anulada exitosamente.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "La factura no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Error en el formato numérico. Favor que sean numéricos");
                    ControlFacturasReportes();
                }
        }
    }

    /**
     * Este es el metodo para poder registrar los eventos que queramos  
     */
    public void RegistrarEvento(){
        Object[] options = { "Registrar Evento", "Volver" };

        JTextField nombreField = new JTextField(10);
        JTextField ciudadField = new JTextField(10);
        JTextField direccionField = new JTextField(10);
        JTextField categoriaField = new JTextField(10);
        JTextField capacidadField = new JTextField(10);
        JTextField precioField = new JTextField(10);
        JTextField YearField = new JTextField(10);
        JTextField MonthField = new JTextField(10);
        JTextField DayField = new JTextField(10);
        JTextField HoraField = new JTextField(10);
        JTextField MinutoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Nombre del evento"));
        panel.add(nombreField);
        panel.add(new JLabel("Ciudad"));
        panel.add(ciudadField);
        panel.add(new JLabel("Direccion"));
        panel.add(direccionField);
        panel.add(new JLabel("Categoria"));
        panel.add(categoriaField);
        panel.add(new JLabel("Capacidad del evento"));
        panel.add(capacidadField);
        panel.add(new JLabel("Precio del evento"));
        panel.add(precioField);
        panel.add(new JLabel("Año del evento"));
        panel.add(YearField);
        panel.add(new JLabel("Mes del evento"));
        panel.add(MonthField);
        panel.add(new JLabel("Dia del evento"));
        panel.add(DayField);
        panel.add(new JLabel("Hora del evento"));
        panel.add(HoraField);
        panel.add(new JLabel("Minuto del evento"));
        panel.add(MinutoField);

        
        while(true){
            int opcion = JOptionPane.showOptionDialog(null, panel, "Inicio de sesion como administrador",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if(opcion == 0){
                String nombreEvento = nombreField.getText();
                String ciudadEvento = ciudadField.getText();
                String direccionEvento = direccionField.getText();
                String categoriaEvento = categoriaField.getText();
                
                int Restriccion = (JOptionPane.showOptionDialog(null,
                "Edite si el evento es apto para todo publico o solo mayores de edad",
                "Mayores de edad o Apto para todo publico",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Mayores de edad", "Apto para todo publico"},
                "Apto para todo publico"));
            
                boolean RestriccionEdad = (Restriccion == JOptionPane.YES_OPTION);

                try {
                    int capacidadEvento = Integer.parseInt(capacidadField.getText());
                    int precioEvento = Integer.parseInt(precioField.getText());
                    int Year = Integer.parseInt(YearField.getText());
                    int Month = Integer.parseInt(MonthField.getText());
                    int Day =  Integer.parseInt(DayField.getText());
                    int Hora = Integer.parseInt(HoraField.getText());
                    int Minuto =  Integer.parseInt(MinutoField.getText());
            
                    Date fecha = new Date(Year, Month, Day);
                    Date hora = new Time(Hora, Minuto, 0);
            
                    if (!nombreEvento.equals("") && !ciudadEvento.equals("") && !direccionEvento.equals("") && !categoriaEvento.equals("")) {
                        if (capacidadEvento > 0 && precioEvento > 0 && Year > 0 && Month > 0 && Day > 0 && Hora >= 0 && Minuto >= 0) {
                            Eventos nuevoEvento = new Eventos(nombreEvento, ciudadEvento, direccionEvento, categoriaEvento, fecha, hora, RestriccionEdad, capacidadEvento, precioEvento);
                            eventos.registrarEvento(nuevoEvento);
                            JOptionPane.showMessageDialog(null, "Evento registrado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Campos numéricos deben ser mayores a cero");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dejaste un espacio vacío");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error en el formato numérico. Favor que sean numéricos");
                }

            }else if(opcion == 1){
                MenuPrincipalAdmin();
                break;
            }
        }
        
    }

    /**
     * Este es el menu para iniciar sesión como administrador
     */
    public void InicioAdmin() {
        Object[] options = { "Iniciar", "Volver" };

        JTextField nombreUsuarioField = new JTextField(10);
        JTextField passwordField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Nombre de usuario"));
        panel.add(nombreUsuarioField);
        panel.add(new JLabel("Contraseña"));
        panel.add(passwordField);

        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, panel, "Inicio de sesion como administrador",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcion == 0) {
                String nombreUsuario = nombreUsuarioField.getText();
                String password = passwordField.getText();

                if (admins.autenticarUsuario(nombreUsuario, password) == null) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Usuario o contraseña incorrectos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
                    MenuPrincipalAdmin();
                    break;
                }

            } else if (opcion == 1) {
                Main();
                break;
            }
        }
    }

    /**
     * Este es el menu para iniciar sesión como cliente
     */
    public void InicioCliente() {
        Object[] options = { "Iniciar", "Volver" };

        JTextField nombreUsuarioField = new JTextField(10);
        JTextField passwordField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Nombre de usuario"));
        panel.add(nombreUsuarioField);
        panel.add(new JLabel("Contraseña"));
        panel.add(passwordField);

        boolean validar_menu = true;

        while (validar_menu) {
            int opcion = JOptionPane.showOptionDialog(null, panel, "Inicio de sesion como cliente",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcion == 0) {
                String nombreUsuario = nombreUsuarioField.getText();
                String password = passwordField.getText();

                if (clientes.autenticarUsuario(nombreUsuario, password) == null) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Usuario o contraseña incorrectos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"Bienvenido a la boleteria eventos");
                    MenuPrincipalCliente();
                    break;
                }

            } else if (opcion == 1) {
                Main();
                break;
            }
        }
    }

    /**
     * Este es el menu para poder registrar un administrador
     */
    public void RegistroAdmin() {
        Object[] options = { "Registrarse", "Volver" };

        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField edadField = new JTextField(10);
        JTextField nombreUsuarioField = new JTextField(10);
        JTextField passwordField = new JTextField(10);
        JTextField correoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Nombre"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido"));
        panel.add(apellidoField);
        panel.add(new JLabel("Edad"));
        panel.add(edadField);
        panel.add(new JLabel("Nombre de usuario"));
        panel.add(nombreUsuarioField);
        panel.add(new JLabel("Contraseña"));
        panel.add(passwordField);
        panel.add(new JLabel("Correo electronico"));
        panel.add(correoField);

        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, panel, "Registrarse como cliente",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcion == 0) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String nombreUsuario = nombreUsuarioField.getText();
                String password = passwordField.getText();
                String correo = correoField.getText();

                if (admins.verificarUsuarioExistente(nombreUsuario)) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, elige otro", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }else if(!nombre.equals("") && !apellido.equals("") && !nombreUsuario.equals("") && !password.equals("") && !correo.equals("")){
                    Administrador nuevAdministrador = new Administrador(nombre, apellido, edad, nombreUsuario, password,correo);
                    admins.registrarAdministrador(nuevAdministrador);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente");
                }else {
                    JOptionPane.showMessageDialog(null, "Dejaste un espacio vacio", "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

            } else if (opcion == 1) {
                Main();
                break;
            }
        }
    }

    /**
     * Este es el menu para poder registrar un cliente
     */
    public void RegistroCliente() {
        Object[] options = { "Registrarse", "Volver" };

        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField edadField = new JTextField(10);
        JTextField nombreUsuarioField = new JTextField(10);
        JTextField passwordField = new JTextField(10);
        JTextField correoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Nombre"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido"));
        panel.add(apellidoField);
        panel.add(new JLabel("Edad"));
        panel.add(edadField);
        panel.add(new JLabel("Nombre de usuario"));
        panel.add(nombreUsuarioField);
        panel.add(new JLabel("Contraseña"));
        panel.add(passwordField);
        panel.add(new JLabel("Correo electronico"));
        panel.add(correoField);

        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, panel, "Registrarse como cliente",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcion == 0) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String nombreUsuario = nombreUsuarioField.getText();
                String password = passwordField.getText();
                String correo = correoField.getText();

                if (clientes.verificarUsuarioExistente(nombreUsuario)) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, elige otro", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if(!nombre.equals("") && !apellido.equals("") && !nombreUsuario.equals("") && !password.equals("") && !correo.equals("")){
                    Cliente nuevoCliente = new Cliente(nombre, apellido, edad, nombreUsuario, password, correo);
                    clientes.registrarCliente(nuevoCliente);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Dejaste un espacio vacio", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else if (opcion == 1) {
                Main();
                break;
            }
        }
    }

    /**
     * Este es el menu principal cada vez que iniciamos el sistema nos saldra si queremos iniciar sesión
     * o si queremos registrar un cliente o administrador
     */
    public void Main() {

        Administrador admin1 = new Administrador("Steven", "rod", 20, "zzz", "hola", "steven@1gmail.com");
        Cliente cliente1 = new Cliente("pedro", "rod", 15, "zzz", "hola", "steven@1gmail.com");
        Cliente cliente2 = new Cliente("juan", "rod", 20, "rrr", "iii", "steven@1gmail.com");
        admins.registrarAdministrador(admin1);
        clientes.registrarCliente(cliente1);
        clientes.registrarCliente(cliente2);

        Object[] options = { "Iniciar Sesion", "Registrarse", "Salir" };
        Object[] eleccion = { "Administrador", "Cliente" };

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Elige si deseas hacer login o registrarte",
                "Menu inicio Producciones Palace",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        while (true) {
            if (seleccion == 0) {

                int opcion = JOptionPane.showOptionDialog(null, "Elige si deseas hacer login como admin o como cliente",
                        "Inicio de sesion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, eleccion,
                        eleccion[0]);
                if (opcion == 0) {
                    InicioAdmin();
                } else if (opcion == 1) {
                    InicioCliente();
                }
                break;
            } else if (seleccion == 1) {
                int opcion = JOptionPane.showOptionDialog(null, "Elige si deseas hacer login como admin o como cliente",
                        "Inicio de sesion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, eleccion,
                        eleccion[0]);
                if (opcion == 0) {
                    RegistroAdmin();
                } else if (opcion == 1) {
                    RegistroCliente();
                }
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Saliste del sistema");
                break;
            }
        }
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.Main();
    }
}