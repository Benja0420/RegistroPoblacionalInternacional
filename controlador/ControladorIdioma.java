package controlador;

import modelo.Idioma;
import java.util.ArrayList;
import java.util.Comparator;

public class ControladorIdioma {

    private ArrayList<Idioma> listaIdiomas;

    public ControladorIdioma() {
        this.listaIdiomas = new ArrayList<>();
        // Datos de ejemplo
        listaIdiomas.add(new Idioma("Español", true, 4.85));
        listaIdiomas.add(new Idioma("Inglés", true, 1.35));
        listaIdiomas.add(new Idioma("Mandarín", false, 1.11));
        listaIdiomas.add(new Idioma("Árabe", false, 3.8));
    }

    // El objetivo del método es crear un nuevo idioma y agregarlo a la lista de
    // idiomas del sistema.
    public void agregarIdioma(String idioma, boolean esOficial, double porcentaje) {
        Idioma nuevoIdioma = new Idioma(idioma, esOficial, porcentaje);
        listaIdiomas.add(nuevoIdioma);
    }

    public Idioma buscarIdioma(String idioma) {
        for (Idioma i : listaIdiomas) {
            if (i.getIdioma().equalsIgnoreCase(idioma)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Idioma> getIdiomasPorPais(String nombrePais) {
        ArrayList<Idioma> idiomasDelPais = new ArrayList<>();
        if (nombrePais.equalsIgnoreCase("Chile")) {
            idiomasDelPais.add(new Idioma("Español", true, 99.0));
        } else if (nombrePais.equalsIgnoreCase("Japón")) {
            idiomasDelPais.add(new Idioma("Japonés", true, 99.0));
        }
        return idiomasDelPais;
    }

    public ArrayList<Idioma> getIdiomasMasHablados(int topN) {
        ArrayList<Idioma> idiomasOrdenados = new ArrayList<>(listaIdiomas);
        idiomasOrdenados.sort(Comparator.comparingDouble(Idioma::getPorcentajeHablantes).reversed());
        return new ArrayList<>(idiomasOrdenados.subList(0, Math.min(topN,
                idiomasOrdenados.size())));
    }

}
