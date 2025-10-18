package modelo;

public class Ciudad {
    
    //Definimos los atributos
    private String nombre;
    private Pais pais;
    private String distrito;
    private int poblacion;

    public Ciudad(String nombre, Pais pais, String distrito, int poblacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.distrito = distrito;
        this.poblacion = poblacion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }


}

