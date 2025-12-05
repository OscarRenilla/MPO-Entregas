package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;

/**
 *Clase Servicio
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor principal de la clase Servicio
     */
    public Servicio() {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Constructor vacío
     * @param descripcion Descripción del servicio
     * @param nombreMecanico Nombre del mecánico del servicio
     * @param tipoServicio Tipo del servicio
     */
    public Servicio(String descripcion, String nombreMecanico, TipoServicio tipoServicio) {
    }

    /**
     * Getter del atributo descripcion
     * @return la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descripcion
     * @param descripcion La descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo mecanico
     * @return el mecanico
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     * @param mecanico el mecánico
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo tipo
     * @return el tipo de servicio
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     * @param tipo Enumeración de los tipos de servicio
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para mostrar en texto formateado los datos del servicio
     * @return los datos del Servicio
     */
    @Override
    public String toString() {
        return String.format("Servicio: %Descripción: %s, Mecánico: %s, Tipo de Servicio: %s", this.descripcion, this.mecanico, this.tipo);
    }
}
