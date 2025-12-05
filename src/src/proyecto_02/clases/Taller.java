package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;
import proyecto_02.exceptions.VehiculoNoEncontrado;
import recursos.MyScanner;

import java.security.cert.TrustAnchor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<proyecto_02.clases.Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    Map<proyecto_02.clases.Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor principal de la clase Taller
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

    public ArrayList<proyecto_02.clases.Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<proyecto_02.clases.Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    public Map<proyecto_02.clases.Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(Map<proyecto_02.clases.Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    public void registrarVehiculo() {
        String matricula ;
        do {
            matricula = sc.pideTexto("Introduce la matrícula del vehículo: ");
            String mensaje = matricula.length() == 7 ? "Matrícula correcta" : "La matrícula debe tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\n5. Todoterreno" +
                    "\n6. VMP" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_genero) {
                case 1:
                    tipoVehiculo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                case 5:
                    tipoVehiculo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipoVehiculo = TipoVehiculo.VMP;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo(matricula, matricula, tipoVehiculo));
        System.out.println("Vehiculo registrado correctamente!");
    }

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce una descripción del motivo del servicio: ");
        String nombreMecanico = sc.pideTexto("Introduce el nombre del mecánico: ");
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\n6. Chapa" +
                    "\nIntroduce el tipo de servicio: ");
            switch (opcion_genero) {
                case 1:
                    tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipoServicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipoServicio = TipoServicio.PINTURA;
                    break;
                case 4:
                    tipoServicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                case 6:
                    tipoServicio = TipoServicio.CHAPA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        Servicio servicio = new Servicio(descripcion, nombreMecanico, tipoServicio);
        catalogoServicios.add(servicio);
    }

    public String asignarServicio() {
        String matricula = sc.pideTexto("Introduce la matrícula del vehículo: ");
        proyecto_02.clases.Vehiculo vehiculo;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            mostrarTrabajos();
            String titulo = sc.pideTexto("Introduce una descripción del servicio: ");
            servicio = buscarServicio(titulo);
            if (servicio != null) {
                catalogoServicios.remove(servicio);
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Fecha del trabajo: %s del servicio: %s", fecha_formateada, servicio.getDescripcion());
            } else {
                System.out.println("No hay ningun servicio con esa descripción disponible!");
            }

        } else {
            System.out.println("No existe un vehículo con esa matrícula!");
        }
        return (vehiculo != null && servicio != null) ? "Servicio asignado correctamente" : "Error en el proceso.";
    }

    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (proyecto_02.clases.Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por el tipo de vehículo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroTipoVehiculo();
                        correcto = true;
                        break;
                    case 'N':
                    case 'n':
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        } else {
            System.out.println("No hay vehículos disponibles");
            return false;
        }
    }

    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\n5. Todoterreno" +
                    "\n6. VMP" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_genero) {
                case 1:
                    tipoVehiculo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                case 5:
                    tipoVehiculo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipoVehiculo = TipoVehiculo.VMP;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo);
            }
        }
    }

    public boolean mostrarTrabajos() {
        if (trabajosRealizados.isEmpty()) {
            System.out.println("No hay trabajos que mostrar");
            return false;
        }
        for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
            Servicio servicio = trabajosRealizados.get(vehiculo);
            System.out.printf(
                    "Trabajo: Matrícula del vehículo: %s, Trabajo realizado: %s", vehiculo.getMatricula(), servicio.getDescripcion()
            );
        }
        return true;
    }

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehículo no encontrado");
    }

    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(servicio)) {
                return servicio;
            }
        }
        return null;
    }
}
