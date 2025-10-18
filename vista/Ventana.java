package vista;

//Importo java AWT
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.ControladorPais;
import controlador.ControladorCiudad;
import controlador.ControladorIdioma;

import modelo.*;

//Definimos una clase publica llamada ventana que hereda de un Frame
public class Ventana extends Frame {

    // Definimos los componentes de la interfaz grafica
    private ControladorCiudad controladorCiudad;
    private ControladorPais controladorPais;
    private ControladorIdioma controladorIdioma;

    private Label lblTitulo, lblNombre, lblContinente, lbCodigo, lbPoblacion;
    private TextField txtNombre, txtContinente, txtCodigo, txtPoblacion;
    private Button btnAgregar, btnConsultar, btnModificar;
    private List listPaises;
    private Label lblContinenteFiltro;
    private Button btnPaisesPorIndependencia, btnCapitales, btnFiltrar;
    private JComboBox<String> comboContinentes;
    private Label lblTituloCiudad, lblNombreCiudad, lblPaisCiudad, lblDistritoCiudad, lblPoblacionCiudad;
    private TextField txtNombreCiudad, txtPaisCiudad, txtDistritoCiudad, txtPoblacionCiudad;
    private Button btnAgregarCiudad, btnConsultarCiudad, btnCiudadesDePais, btnCiudadesMasPobladas;
    private List listCiudades;
    private Label lblTituloIdioma, lblNombreIdioma, lblEsOficial, lblPorcentajeHablantes;
    private TextField txtNombreIdioma, txtPorcentajeHablantes;
    private Checkbox chkEsOficial;
    private Button btnAgregarIdioma, btnConsultarIdioma, btnIdiomasDePais, btnIdiomasMasHablados;
    private List listIdiomas;

    // Creamos un constructor de la clase ventana
    public Ventana() {
        // Instanciamos el controlador de paises
        this.controladorPais = new ControladorPais();
        this.controladorCiudad = new ControladorCiudad();
        this.controladorIdioma = new ControladorIdioma();
        // Definimos un titulo a la ventana

        setTitle("Sistema de Control Poblacional");
        // Definimos un tamaño de la ventana
        setSize(1200, 800);
        // Definimos el color de fondo de la ventana
        setBackground(Color.red);
        // Centramos la ventana al ejecutar
        setLocationRelativeTo(null);
        // Definimo el layout en null
        setLayout(null);

        // Invocamos los metodos de la interfaz grafica
        configurarTitulo();
        configurarCamposDeEntrada();
        configurarBotones();
        configurarLista();
        // Invocamos a los botones de evento
        configurarBotonesDeEventos();

    }

    // Definimos un metodo parar configurar el Titulo de la ventana
    private void configurarTitulo() {
        lblTitulo = new Label("Registro Poblacional Internacional");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(100, 30, 400, 30);
        add(lblTitulo);
    }

    // Definimos un metodo para configurar los campos de entrada
    private void configurarCamposDeEntrada() {
        lbCodigo = new Label("Código:");
        lbCodigo.setBounds(50, 80, 80, 20);
        add(lbCodigo);

        txtCodigo = new TextField();
        txtCodigo.setBounds(150, 80, 150, 20);
        add(txtCodigo);

        // Defino el campo de entrada de Continente
        lblNombre = new Label("Nombre:");
        lblNombre.setBounds(50, 110, 80, 20);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(150, 110, 150, 20);
        add(txtNombre);

        // Defino el campo de entrada de Nombre
        lblContinente = new Label("Continente:");
        lblContinente.setBounds(50, 140, 80, 20);
        add(lblContinente);

        txtContinente = new TextField();
        txtContinente.setBounds(150, 140, 150, 20);
        add(txtContinente);

        // Defino el campo de entrada de Continente
        lbPoblacion = new Label("Población:");
        lbPoblacion.setBounds(50, 170, 80, 20);
        add(lbPoblacion);

        txtPoblacion = new TextField();
        txtPoblacion.setBounds(150, 170, 150, 20);
        add(txtPoblacion);

    }

    // Defino un metodo para configurar los botones
    private void configurarBotones() {
        // Agrego el boton de Agregar
        btnAgregar = new Button("Agregar");
        btnAgregar.setBounds(50, 210, 80, 30);
        add(btnAgregar);

        // Agrego el boton de Consultar
        btnConsultar = new Button("Consultar");
        btnConsultar.setBounds(140, 210, 80, 30);
        add(btnConsultar);

        // Agrego el boton de Modificar
        btnModificar = new Button("Modificar");
        btnModificar.setBounds(230, 210, 80, 30);
        add(btnModificar);
    }

    // Defino un metodo para configurar la lista
    private void configurarLista() {
        // Agrego la lista de paises
        listPaises = new List();
        listPaises.setBounds(320, 80, 400, 200);
        add(listPaises);

        // Cargar países iniciales en la lista
        for (Pais pais : controladorPais.getListaPaises()) {
            listPaises.add("Código: " + pais.getCodigo() + " || Nombre: " + pais.getNombre() + " || Continente: "
                    + pais.getContinente() + " || Poblacion: " + pais.getPoblacion());
        }
    }

    // Metodo Limpiar
    private void limpiarCampos() {
        // Limpia los campos de texto para que el usuario pueda ingresar nuevos datos
        txtNombre.setText("");
        txtContinente.setText("");
        txtCodigo.setText("");
        txtPoblacion.setText("");
        txtNombreCiudad.setText("");
        txtPaisCiudad.setText("");
        txtDistritoCiudad.setText("");
        txtPoblacionCiudad.setText("");
    }

    // Metodos para botones de Evento
    private void configurarBotonesDeEventos() {
        // Agregar un ActionListener al botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            // Sobrescribir el método actionPerformed que se ejecuta cuando se presiona el
            // botón
            public void actionPerformed(ActionEvent e) {

                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                String continente = txtContinente.getText();
                int poblacion = Integer.parseInt(txtPoblacion.getText());

                controladorPais.agregarPais(codigo, nombre, continente, poblacion, "", 0, 0, 0, 0, "", "", null);

                String datosPais = "Código: " + codigo +
                        " || Nombre: " + nombre +
                        " || Continente: " + continente +
                        " || Poblacion: " + poblacion;
                listPaises.add(datosPais);

            }

        });

        // Método para el botón Consultar
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice del elemento seleccionado en la lista
                int FilaIndice = listPaises.getSelectedIndex();
                // Verificar si se ha seleccionado un elemento en la lista
                if (FilaIndice != -1) {
                    // Obtener la cadena completa del elemento seleccionado
                    String datosSeleccionados = listPaises.getItem(FilaIndice);

                    // Mostrar la cadena completa en la consola o donde sea necesario
                    System.out.println("Datos seleccionados: " + datosSeleccionados);
                } else {
                    // Si no se selecciona ningún elemento
                    System.out.println("Por favor seleccione una fila de la lista para consultar.");
                }
            }
        });

        // Método para el botón Modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice del elemento seleccionado en la lista
                int selectedIndex = listPaises.getSelectedIndex();
                // Si se seleccionó un elemento (índice no es -1)
                if (selectedIndex != -1) {
                    // Se crea una cadena concatenando los datos modificados
                    String datosModificados = "Código: " + txtCodigo.getText() +
                            " || Nombre: " + txtNombre.getText() +
                            " || Continente: " + txtContinente.getText() +
                            " || Poblacion: " + txtPoblacion.getText();

                    // Reemplaza el elemento seleccionado en la lista con los datos modificados
                    listPaises.replaceItem(datosModificados, selectedIndex);
                    // Muestro un mensaje en consola del título para indicar que los datos fueron
                    // modificados
                    System.out.println("Datos Modificados");
                    limpiarCampos();
                }
            }
        });

        // Agrega un WindowListener para manejar el evento de cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Imprimir en la consola que la ventana se está cerrando
                System.out.println("Cerrando la ventana...");
                // Llama al método dispose() para cerrar la ventana y liberar recursos
                dispose();
                // Termina el programa completamente
                System.exit(0);
            }
        });
        //Nuevos componentes para filtrar y ordenar
        lblContinenteFiltro = new Label("Filtrar por Continente:");
        lblContinenteFiltro.setBounds(300, 280, 150, 20);
        add(lblContinenteFiltro);
        String[] continentes = { "Todos", "América del Sur", "Europa", "Asia", "África" };
        comboContinentes = new JComboBox<>(continentes);
        comboContinentes.setBounds(460, 280, 150, 20);
        add(comboContinentes);
        btnFiltrar = new Button("Filtrar");
        btnFiltrar.setBounds(600, 280, 60, 20);
        add(btnFiltrar);
        btnPaisesPorIndependencia = new Button("Paises por Independencia");
        btnPaisesPorIndependencia.setBounds(300, 310, 150, 20);
        add(btnPaisesPorIndependencia);
        btnCapitales = new Button("Capitales de Continentes");
        btnCapitales.setBounds(460, 310, 150, 20);
        add(btnCapitales);

        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String continenteSeleccionado = (String) comboContinentes.getSelectedItem();
                listPaises.removeAll();
                ArrayList<Pais> paises;
                if (continenteSeleccionado.equals("Todos")) {
                    paises = controladorPais.getListaPaises();
                } else {
                    paises = controladorPais.getPaisesPorContinente(continenteSeleccionado);
                }
                for (Pais pais : paises) {
                    listPaises.add("Código: " + pais.getCodigo() + " || Nombre: " + pais.getNombre()
                            + " || Continente: " + pais.getContinente() + " || Poblacion: " + pais.getPoblacion());
                }
            }
        });
        // Evento para el botón Paises por Independencia
        btnPaisesPorIndependencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPaises.removeAll();
                ArrayList<Pais> paisesOrdenados = controladorPais.getPaisesOrdenadosPorAnoIndependencia();
                for (Pais pais : paisesOrdenados) {
                    listPaises.add("Año de Ind.: " + pais.getAnoIndependencia() + " || Nombre: " + pais.getNombre());
                }
            }
        });

        btnCapitales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPaises.removeAll();
                ArrayList<String> capitales = controladorPais.getCapitalesPorContinente();
                for (String capital : capitales) {
                    listPaises.add(capital);
                }
            }
        });

        // --- Sección de Ciudades ---
        lblTituloCiudad = new Label("Gestión de Ciudades");
        lblTituloCiudad.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloCiudad.setBounds(800, 40, 200, 30);
        add(lblTituloCiudad);
        lblNombreCiudad = new Label("Nombre:");
        lblNombreCiudad.setBounds(800, 80, 80, 20);
        add(lblNombreCiudad);
        txtNombreCiudad = new TextField();
        txtNombreCiudad.setBounds(890, 80, 150, 20);
        add(txtNombreCiudad);

        lblPaisCiudad = new Label("País:");
        lblPaisCiudad.setBounds(800, 110, 80, 20);
        add(lblPaisCiudad);
        txtPaisCiudad = new TextField();
        txtPaisCiudad.setBounds(890, 110, 150, 20);
        add(txtPaisCiudad);
        lblDistritoCiudad = new Label("Distrito:");
        lblDistritoCiudad.setBounds(800, 140, 80, 20);
        add(lblDistritoCiudad);
        txtDistritoCiudad = new TextField();
        txtDistritoCiudad.setBounds(890, 140, 150, 20);
        add(txtDistritoCiudad);
        lblPoblacionCiudad = new Label("Población:");
        lblPoblacionCiudad.setBounds(800, 170, 80, 20);
        add(lblPoblacionCiudad);
        txtPoblacionCiudad = new TextField();
        txtPoblacionCiudad.setBounds(890, 170, 150, 20);
        add(txtPoblacionCiudad);
        btnAgregarCiudad = new Button("Agregar Ciudad");
        btnAgregarCiudad.setBounds(800, 220, 100, 30);
        add(btnAgregarCiudad);
        btnConsultarCiudad = new Button("Consultar Ciudad");
        btnConsultarCiudad.setBounds(910, 220, 110, 30);
        add(btnConsultarCiudad);
        btnCiudadesDePais = new Button("Ciudades de País");
        btnCiudadesDePais.setBounds(800, 260, 110, 30);
        add(btnCiudadesDePais);
        btnCiudadesMasPobladas = new Button("Ciudades más Pobladas");
        btnCiudadesMasPobladas.setBounds(920, 260, 150, 30);
        add(btnCiudadesMasPobladas);
        listCiudades = new List(10);
        listCiudades.setBounds(800, 300, 380, 120);
        add(listCiudades);

        btnAgregarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCiudad = txtNombreCiudad.getText();
                    String nombrePais = txtPaisCiudad.getText();
                    String distrito = txtDistritoCiudad.getText();
                    int poblacionCiudad = Integer.parseInt(txtPoblacionCiudad.getText());
                    Pais paisEncontrado = controladorPais.buscarPais(nombrePais);
                    if (paisEncontrado != null) {
                        controladorCiudad.agregarCiudad(nombreCiudad, paisEncontrado, distrito, poblacionCiudad);
                        listCiudades.add("Nombre: " + nombreCiudad + " || País: " + nombrePais + " || Distrito: "
                                + distrito + " || Población: " + poblacionCiudad);

                        limpiarCampos();
                    } else {
                        System.out.println("País no encontrado para la ciudad.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, ingrese un número válido para la población de la ciudad.");
                }
            }
        });

        btnConsultarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listCiudades.getSelectedIndex();
                if (selectedIndex != -1) {
                    String datosSeleccionados = listCiudades.getItem(selectedIndex);
                    String nombreCiudad = datosSeleccionados.split(" \\|\\| ")[0].replace("Nombre: ", "").trim();

                    Ciudad ciudadEncontrada = controladorCiudad.buscarCiudad(nombreCiudad);
                    if (ciudadEncontrada != null) {
                        txtNombreCiudad.setText(ciudadEncontrada.getNombre());
                        txtPaisCiudad.setText(ciudadEncontrada.getPais().getNombre());
                        txtDistritoCiudad.setText(ciudadEncontrada.getDistrito());
                        txtPoblacionCiudad.setText(String.valueOf(ciudadEncontrada.getPoblacion()));
                    }
                } else {
                    System.out.println("Por favor seleccione una ciudad para consultar.");
                }
            }
        });

        btnCiudadesDePais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaIndice = listPaises.getSelectedIndex();
                if (FilaIndice != -1) {
                    String datosSeleccionados = listPaises.getItem(FilaIndice);
                    String[] partes = datosSeleccionados.split(" \\|\\| ");
                    String nombrePais = partes[1].replace("Nombre: ", "").trim();

                    listCiudades.removeAll();
                    ArrayList<Ciudad> ciudades = controladorCiudad.getCiudadesPorPais(nombrePais);
                    if (ciudades.isEmpty()) {
                        listCiudades.add("No hay ciudades para este país.");
                    } else {
                        for (Ciudad ciudad : ciudades) {
                            listCiudades.add("Nombre: " + ciudad.getNombre() + " || Distrito: " + ciudad.getDistrito()
                                    + " || Población: " + ciudad.getPoblacion());
                        }
                    }
                } else {
                    System.out.println("Por favor, seleccione un país para ver sus ciudades.");
                }
            }
        });

        btnCiudadesMasPobladas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCiudades.removeAll();
                ArrayList<Ciudad> ciudades = controladorCiudad.getCiudadesMasPobladas(5);
                for (Ciudad ciudad : ciudades) {
                    listCiudades.add("Nombre: " + ciudad.getNombre() + " || País: " + ciudad.getPais().getNombre()
                            + " || Población: " + ciudad.getPoblacion());
                }
            }
        });

        // --- Sección de Idiomas ---
        lblTituloIdioma = new Label("Gestión de Idiomas");
        lblTituloIdioma.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloIdioma.setBounds(20, 350, 200, 30);
        add(lblTituloIdioma);
        lblNombreIdioma = new Label("Idioma:");
        lblNombreIdioma.setBounds(20, 390, 80, 20);
        add(lblNombreIdioma);
        txtNombreIdioma = new TextField();
        txtNombreIdioma.setBounds(110, 390, 150, 20);
        add(txtNombreIdioma);
        lblEsOficial = new Label("Es Oficial:");
        lblEsOficial.setBounds(20, 420, 80, 20);
        add(lblEsOficial);
        chkEsOficial = new Checkbox();
        chkEsOficial.setBounds(110, 420, 20, 20);
        add(chkEsOficial);
        lblPorcentajeHablantes = new Label("% Hablantes:");
        lblPorcentajeHablantes.setBounds(20, 450, 80, 20);
        add(lblPorcentajeHablantes);
        txtPorcentajeHablantes = new TextField();
        txtPorcentajeHablantes.setBounds(110, 450, 150, 20);
        add(txtPorcentajeHablantes);
        btnAgregarIdioma = new Button("Agregar Idioma");
        btnAgregarIdioma.setBounds(20, 500, 100, 30);
        add(btnAgregarIdioma);
        btnConsultarIdioma = new Button("Consultar Idioma");
        btnConsultarIdioma.setBounds(130, 500, 110, 30);
        add(btnConsultarIdioma);
        btnIdiomasDePais = new Button("Idiomas de País");
        btnIdiomasDePais.setBounds(250, 500, 110, 30);
        add(btnIdiomasDePais);
        btnIdiomasMasHablados = new Button("Idiomas más Hablados");
        btnIdiomasMasHablados.setBounds(370, 500, 150, 30);
        add(btnIdiomasMasHablados);
        listIdiomas = new List(10);
        listIdiomas.setBounds(20, 540, 500, 180);
        add(listIdiomas);

        // Evento para el botón Agregar Idioma
        btnAgregarIdioma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreIdioma = txtNombreIdioma.getText();
                    boolean esOficial = chkEsOficial.getState();
                    double porcentaje = Double.parseDouble(txtPorcentajeHablantes.getText());
                    controladorIdioma.agregarIdioma(nombreIdioma, esOficial, porcentaje);
                    listIdiomas.add(
                            "Idioma: " + nombreIdioma + " || Oficial: " + esOficial + " || % Hablantes: " + porcentaje);
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, ingrese un número válido para el porcentaje.");
                }
            }
        });

        // Evento para el botón Consultar Idioma
        btnConsultarIdioma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listIdiomas.getSelectedIndex();
                if (selectedIndex != -1) {
                    String datosSeleccionados = listIdiomas.getItem(selectedIndex);
                    String nombreIdioma = datosSeleccionados.split(" \\|\\| ")[0].replace("Idioma: ",
                            "").trim();
                    Idioma idiomaEncontrado = controladorIdioma.buscarIdioma(nombreIdioma);
                    if (idiomaEncontrado != null) {
                        txtNombreIdioma.setText(idiomaEncontrado.getIdioma());
                        chkEsOficial.setState(idiomaEncontrado.isEsOficial());
                        txtPorcentajeHablantes.setText(String.valueOf(idiomaEncontrado.getPorcentajeHablantes()));
                    }
                } else {
                    System.out.println("Por favor seleccione un idioma para consultar.");
                }
            }
        });

        btnIdiomasDePais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaIndice = listPaises.getSelectedIndex();
                if (FilaIndice != -1) {
                    String datosSeleccionados = listPaises.getItem(FilaIndice);
                    String[] partes = datosSeleccionados.split(" \\|\\| ");
                    String nombrePais = partes[1].replace("Nombre: ", "").trim();
                    listIdiomas.removeAll();
                    ArrayList<Idioma> idiomas = controladorIdioma.getIdiomasPorPais(nombrePais);
                    if (idiomas.isEmpty()) {
                        listIdiomas.add("No hay idiomas para este país.");
                    } else {
                        for (Idioma idioma : idiomas) {
                            listIdiomas.add("Idioma: " + idioma.getIdioma() + " || Oficial: " + idioma.isEsOficial()
                                    + " || % Hablantes: " + idioma.getPorcentajeHablantes());
                        }
                    }
                } else {
                    System.out.println("Por favor, seleccione un país para ver sus idiomas.");
                }
            }
        });

        btnIdiomasMasHablados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listIdiomas.removeAll();
                ArrayList<Idioma> idiomas = controladorIdioma.getIdiomasMasHablados(5);
                for (Idioma idioma : idiomas) {
                    listIdiomas.add("Idioma: " + idioma.getIdioma() + " || % Hablantes: " +
                            idioma.getPorcentajeHablantes());
                }
            }
        });

    }

}
