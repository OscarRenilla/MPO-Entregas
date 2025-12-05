package proyecto_02.clases;

import proyecto_02.enums.TipoVehiculo;

/**
 * Clase Vehiculo
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;

    /**
     * Constructor vacío
     * @param matricula La matrícula del vehiculo
     * @param tipoVehiculo Enumeración del tipo de vehículo
     */
    public Vehiculo(String matricula, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Constructor principal de la clase Vehiculo
     * @param matricula La matrícula del vehículo
     * @param modelo Modelo del vehículo
     * @param tipoVehiculo Enumeración de los tipos de vehículos
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Getter del atributo matricula
     * @return la matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo matricula
     * @param matricula La matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo modelo
     * @return el moelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo modelo
     * @param modelo El modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo tipoVehiculo
     * @return el tipo de vehículo
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Setter del atributo tipoVehiculo
     * @param tipoVehiculo Enmuracion de tipos de vehículo
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Metodo para mostrar en texto formateado los datos del vehículo
     * @return los datos del vehículo
     */
    @Override
    public String toString() {
        String format = String.format("Vehículo: %nMatrícula: %s, Modelo: %s, Tipo de vehículo: %s.", this.getMatricula(), this.getModelo(), this.getTipoVehiculo());
        return format;
    }

    /**
     * Metodo para controlar la matrícula
     * @param o   the reference object with which to compare.
     * @return la matrícula
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;
        return this.getMatricula() != null ? this.getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;

    }

    /**
     * Metodo para el Map
     * @return Map
     */
    @Override
    public int hashCode() {
        return this.getMatricula() != null ? this.getMatricula().hashCode() : 0;
    }
}

