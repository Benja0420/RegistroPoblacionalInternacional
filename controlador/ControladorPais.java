package controlador;

import modelo.Pais;
import modelo.Ciudad;
import java.util.ArrayList;
import java.util.Comparator;

public class ControladorPais {

    private ArrayList<Pais> listaPaises;

public ControladorPais() {
        this.listaPaises = new ArrayList<>();
        // Datos de ejemplo para poblar la lista de países
        listaPaises.add(new Pais("CHI", "Chile", "América del Sur", 19000000, "América del Sur", 756102.0, 1818, 79.5, 301.0, "República", "Gabriel Boric", new Ciudad("Santiago", null, "Metropolitana", 6000000)));
        listaPaises.add(new Pais("ARG", "Argentina", "América del Sur", 45000000, "América del Sur", 2780400.0, 1816, 76.5, 487.0, "República Federal", "Javier Milei", new Ciudad("Buenos Aires", null, "Capital Federal", 3000000)));
        listaPaises.add(new Pais("ESP", "España", "Europa", 47000000, "Europa", 505990.0, 1492, 83.5, 1400.0, "Monarquía Parlamentaria", "Pedro Sánchez", new Ciudad("Madrid", null, "Madrid", 3300000)));
        listaPaises.add(new Pais("FRA", "Francia", "Europa", 65000000, "Europa Occidental", 643801.0, 1789, 82.5, 2900.0, "República", "Emmanuel Macron", new Ciudad("París", null, "Île-de-France", 2100000)));
        listaPaises.add(new Pais("EGY", "Egipto", "África", 102000000, "África del Norte", 1010408.0, 1922, 72.0, 404.0, "República", "Abdel Fatah El-Sisi", new Ciudad("El Cairo", null, "El Cairo", 9800000)));
        listaPaises.add(new Pais("JPN", "Japón", "Asia", 125000000, "Asia Oriental", 377975.0, 1952, 84.6, 5100.0, "Monarquía Constitucional", "Fumio Kishida", new Ciudad("Tokio", null, "Tokio", 14000000)));
    }

    

    //Este método  se encarga de crear un nuevo país y guardarlo en la lista de países del sistema.
    public void agregarPais(String codigo, String nombre, String continente, int poblacion, String region, double superficie, int anoIndependencia, double expectativaVida, double pib, String formaGobierno, String jefeDeEstado, Ciudad ciudadCapital) {
        Pais nuevoPais = new Pais(codigo, nombre, continente, poblacion, region, superficie, anoIndependencia, expectativaVida, pib, formaGobierno, jefeDeEstado, ciudadCapital);
        listaPaises.add(nuevoPais);
    }

    //El método tiene como objetivo encontrar y devolver un objeto Pais de la lista,utilizando el nombre como criterio de búsqueda.
    //.equalsIgnoreCase() hace que la comparación no distinga entre mayusculas y minusculas.
    public Pais buscarPais(String nombre) {
        for (Pais pais : listaPaises) {
            if (pais.getNombre().equalsIgnoreCase(nombre)) {
                return pais;
            }
        }
        return null;
    }

    //El método se usa para actualizar los datos de un país que ya existe en la lista, utilizando su código como identificador único.
    //.equalsIgnoreCase(codigo) Compara el código del país actual con el código que se le pasó al método
    public void modificarPais(String codigo, String nombre, String continente, int poblacion) {
        for (Pais pais : listaPaises) {
            if (pais.getCodigo().equalsIgnoreCase(codigo)) {
                pais.setNombre(nombre);
                pais.setContinente(continente);
                pais.setPoblacion(poblacion);
                break;
            }
        }
    }
    
    //Obtiene una lista de paises
    public ArrayList<Pais> getListaPaises() {
        return this.listaPaises;
    }

    
    
    //Obtiene todos los paises segun el continente.
    public ArrayList<Pais> getPaisesPorContinente(String continente) {
        ArrayList<Pais> paisesPorContinente = new ArrayList<>();
        for (Pais pais : listaPaises) {
            if (pais.getContinente().equalsIgnoreCase(continente)) {
                paisesPorContinente.add(pais);
            }
        }
        return paisesPorContinente;
    }

    //El metodo tiene como objetivo crear un resumen de la comparación entre dos paises y devolverlo como una cadena de texto. 
    //Recibe dos objetos de tipo Pais y genera un reporte legible de sus diferencias en métricas clave.
    public String compararPaises(Pais pais1, Pais pais2) {
    // Creamos una cadena de texto vacia para ir construyendo el resultado.
    String resultado = "";

    // Le vamos añadiendo cada línea del reporte con el operador de suma (+).
    resultado = resultado + "Comparación entre " + pais1.getNombre() + " y " + pais2.getNombre() + ":\n";
    resultado = resultado + "Población: " + pais1.getPoblacion() + " vs " + pais2.getPoblacion() + "\n";
    resultado = resultado + "Superficie: " + pais1.getSuperficie() + " km² vs " + pais2.getSuperficie() + " km²\n";
    resultado = resultado + "Expectativa de Vida: " + pais1.getExpectativaVida() + " años vs " + pais2.getExpectativaVida() + " años\n";

    // Devolvemos el resultado final.
    return resultado;
}
    
    public ArrayList<Pais> getPaisesOrdenadosPorAnoIndependencia() {
        ArrayList<Pais> paisesOrdenados = new ArrayList<>(listaPaises);
        paisesOrdenados.sort(Comparator.comparingInt(Pais::getAnoIndependencia)); 
        return paisesOrdenados;
    }

    //Este método tiene como objetivo crear una lista de países ordenada 
    //de manera ascendente por su año de independencia y devolverla.
    public ArrayList<String> getCapitalesPorContinente() {
        ArrayList<String> capitales = new ArrayList<>();
        for (Pais pais : listaPaises) {
            if (pais.getCiudadCapital() != null) {
                capitales.add("Capital: " + pais.getCiudadCapital().getNombre() + " || País: " + pais.getNombre() + " || Continente: " + pais.getContinente());
            }
        }
        return capitales;
    }
}