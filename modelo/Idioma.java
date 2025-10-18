package modelo;

public class Idioma {
    
    //Definimos los atributos
    private String idioma;
    private boolean esOficial;
    private double porcentajeHablantes;

    public Idioma(String idioma, boolean esOficial, double porcentajeHablantes) {
        this.idioma = idioma;
        this.esOficial = esOficial;
        this.porcentajeHablantes = porcentajeHablantes;
    }
    
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEsOficial() {
        return esOficial;
    }

    public void setEsOficial(boolean esOficial) {
        this.esOficial = esOficial;
    }

    public double getPorcentajeHablantes() {
        return porcentajeHablantes;
    }

    public void setPorcentajeHablantes(double porcentajeHablantes) {
        this.porcentajeHablantes = porcentajeHablantes;
    }

   
}

