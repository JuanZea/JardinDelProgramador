package Modelo;

/**
 * La institucion en la que estan matriculados los estudiantes y en donde se pretende
 * que la aplicacion sea utilizada.
 * @author JuanZea
 * @version 1.0.1
 * @since Jardin 1.0.0
 */
public class Institucion {    
    private String nombre = "El jardín de los programadores";
    private String caracter;
    private String añoFundacion;
    private String direccion;
    private String nit;
    private int matriculados;

    public Institucion() {
    }

    public Institucion(String nombre, String caracter, String añoFundacion, String direccion, String nit, int matriculados) {
        this.nombre = nombre;
        this.caracter = caracter;
        this.añoFundacion = añoFundacion;
        this.direccion = direccion;
        this.nit = nit;
        this.matriculados = matriculados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getAñoFundacion() {
        return añoFundacion;
    }

    public void setAñoFundacion(String añoFundacion) {
        this.añoFundacion = añoFundacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(int matriculados) {
        this.matriculados = matriculados;
    }
    
    
}
