package controlador;

import java.util.ArrayList;
import java.util.Comparator;

import modelo.Ciudad;
import modelo.Pais;

public class ControladorCiudad {
    private ArrayList<Ciudad> listaCiudades;

    public ControladorCiudad() {
        this.listaCiudades = new ArrayList<>();
        // Datos de ejemplo
        Pais chile = new Pais("CHI", "Chile", "América del Sur", 19000000, "América del Sur", 756102.0, 1818, 79.5,
                301.0, "República", "Gabriel Boric", new Ciudad("Santiago", null, "Metropolitana", 6000000));
        Pais argentina = new Pais("ARG", "Argentina", "América del Sur", 45000000, "América del Sur", 2780400.0, 1816,
                76.5, 487.0, "República Federal", "Javier Milei",
                new Ciudad("Buenos Aires", null, "Capital Federal", 3000000));
        listaCiudades.add(new Ciudad("Santiago", chile, "Santiago", 6000000));
        listaCiudades.add(new Ciudad("Buenos Aires", argentina, "Capital Federal", 3000000));
        listaCiudades.add(new Ciudad("Valparaíso", chile, "Valparaíso", 300000));
    }

    public void agregarCiudad(String nombre, Pais pais, String distrito, int poblacion) {
        Ciudad nuevaCiudad = new Ciudad(nombre, pais, distrito, poblacion);
        listaCiudades.add(nuevaCiudad);
    }

    public Ciudad buscarCiudad(String nombre) {
        for (Ciudad ciudad : listaCiudades) {
            if (ciudad.getNombre().equalsIgnoreCase(nombre)) {
                return ciudad;
            }
        }
        return null;
    }

    public ArrayList<Ciudad> getCiudadesPorPais(String nombrePais) {
        ArrayList<Ciudad> ciudadesDelPais = new ArrayList<>();
        for (Ciudad ciudad : listaCiudades) {
            if (ciudad.getPais().getNombre().equalsIgnoreCase(nombrePais)) {
                ciudadesDelPais.add(ciudad);
            }
        }
        return ciudadesDelPais;
    }
    public ArrayList<Ciudad> getCiudadesMasPobladas(int topN) {
        ArrayList<Ciudad> ciudadesOrdenadas = new ArrayList<>(listaCiudades);
        ciudadesOrdenadas.sort(Comparator.comparingInt(Ciudad::getPoblacion).reversed());
        return new ArrayList<>(ciudadesOrdenadas.subList(0, Math.min(topN, ciudadesOrdenadas.size())));
    }


}
