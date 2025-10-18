package modelo;

import java.util.ArrayList;

public class Pais {
    private String codigo;
    private String nombre;
    private String continente;
    private int poblacion;
    private String region;
    private double superficie;
    private int anoIndependencia;
    private double expectativaVida;
    private double pib;
    private String formaGobierno;
    private String jefeDeEstado;
    private Ciudad ciudadCapital;
    private ArrayList<Idioma> idiomas;
    private ArrayList<Ciudad> ciudades;

    public Pais() {
        this.idiomas = new ArrayList<>();
        this.ciudades = new ArrayList<>();
    }

    public Pais(String codigo, String nombre, String continente, int poblacion, String region, double superficie, int anoIndependencia, double expectativaVida, double pib, String formaGobierno, String jefeDeEstado, Ciudad ciudadCapital) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.region = region;
        this.superficie = superficie;
        this.anoIndependencia = anoIndependencia;
        this.expectativaVida = expectativaVida;
        this.pib = pib;
        this.formaGobierno = formaGobierno;
        this.jefeDeEstado = jefeDeEstado;
        this.ciudadCapital = ciudadCapital;
        this.idiomas = new ArrayList<>();
        this.ciudades = new ArrayList<>();
    }

    // Getters y Setters
    public String getCodigo() { 
        return codigo; 
    }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getContinente() { return continente; }
    public void setContinente(String continente) { this.continente = continente; }

    public int getPoblacion() { return poblacion; }
    public void setPoblacion(int poblacion) { this.poblacion = poblacion; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public double getSuperficie() { return superficie; }
    public void setSuperficie(double superficie) { this.superficie = superficie; }

    public int getAnoIndependencia() { return anoIndependencia; }
    public void setAnoIndependencia(int anoIndependencia) { this.anoIndependencia = anoIndependencia; }

    public double getExpectativaVida() { return expectativaVida; }
    public void setExpectativaVida(double expectativaVida) { this.expectativaVida = expectativaVida; }

    public double getPib() { return pib; }
    public void setPib(double pib) { this.pib = pib; }

    public String getFormaGobierno() { return formaGobierno; }
    public void setFormaGobierno(String formaGobierno) { this.formaGobierno = formaGobierno; }

    public String getJefeDeEstado() { return jefeDeEstado; }
    public void setJefeDeEstado(String jefeDeEstado) { this.jefeDeEstado = jefeDeEstado; }

    public Ciudad getCiudadCapital() { return ciudadCapital; }
    public void setCiudadCapital(Ciudad ciudadCapital) { this.ciudadCapital = ciudadCapital; }

    public ArrayList<Idioma> getIdiomas() { return idiomas; }
    public void setIdiomas(ArrayList<Idioma> idiomas) { this.idiomas = idiomas; }
    public void agregarIdioma(Idioma idioma) { this.idiomas.add(idioma); }

    public ArrayList<Ciudad> getCiudades() { return ciudades; }
    public void setCiudades(ArrayList<Ciudad> ciudades) { this.ciudades = ciudades; }
    public void agregarCiudad(Ciudad ciudad) { this.ciudades.add(ciudad); }
}