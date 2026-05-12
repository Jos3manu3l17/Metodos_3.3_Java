import  java.util.Scanner;

public class caso37 {

    // Caso 37: Informe de Auditoría - Sistema de Control de Criogenia "Ice-Core": Durante la revisión anual del banco 
    // de muestras biológicas de alta seguridad, se detectó que el sistema de monitoreo de los tanques de nitrógeno líquido 
    // requiere una reestructuración total de su lógica de control. El auditor técnico ha señalado que el programa debe procesar 
    // el nivel de evaporación del gas y la presión interna del contenedor al vacío. Un punto crítico de la auditoría es que la 
    // "Tasa de Expansión Térmica del Nitrógeno" es una constante física inalterable para todos los depósitos del complejo, lo 
    // que implica que el cálculo de riesgo de sobrepresión debe ser una función estandarizada accesible para cualquier unidad 
    // de monitoreo sin depender de la antigüedad del tanque. La lógica de decisión debe ser capaz de determinar si el sistema 
    // activa las válvulas de purga lenta o si debe iniciar un enfriamiento forzado mediante el intercambio de calor. Si los 
    // sensores de entrada reportan una presión de 0 pascales (lo que indicaría una ruptura del sello de vacío) o una tasa de 
    // evaporación negativa, el software debe interrumpir el proceso de inmediato, sellar las compuertas de seguridad y generar 
    // un reporte de "Fallo de Integridad de Vacío" que devuelva un diagnóstico completo con los niveles de gas restantes. El 
    // aprendiz debe diseñar métodos que aseguren que la salida de la validación sea el motor de las acciones físicas de la planta, 
    // evitando que errores de redondeo en los decimales de la presión comprometan décadas de investigación científica. 
    
    
    //Constante global para todos los tanques
    static final double TASA_EXPANSION_NITROGENO = 1.25;

    // Validar sensores
    public String validarSensores(double evaporacion, double presion) {
        if (presion == 0 || evaporacion < 0) {
            return "FALLO";
        }
        return "OK";
    }

    // Calcular riesgo de sobrepresión
    public double calcularRiesgo(double evaporacion, double presion) {
        return (evaporacion * TASA_EXPANSION_NITROGENO) + presion;
    }

    // Decidir acción física del sistema
    public String decidirAccion(double riesgo) {
        if (riesgo > 150) {
            return "Activar válvulas de purga lenta.";
        } else {
            return "Iniciar enfriamiento forzado por intercambio de calor.";
        }
    }

    // Generar reporte de fallo crítico
    public String generarFallo(double evaporacion, double presion) {
        return "\n--- FALLO DE INTEGRIDAD DE VACÍO ---" +
               "\nEvaporación detectada: " + evaporacion +
               "\nPresión interna: " + presion +
               "\nCompuertas de seguridad selladas.";
    }

    // Generar reporte normal
    public String generarReporte(double riesgo, String accion) {
        return "\n--- REPORTE ICE-CORE ---" +
               "\nRiesgo de sobrepresión: " + riesgo +
               "\nAcción ejecutada: " + accion;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        caso37 sistema = new caso37();

        System.out.println("Tasa de evaporación del nitrógeno: ");
        double evaporacion = sc.nextDouble();

        System.out.println("Presión interna del tanque (Pa): ");
        double presion = sc.nextDouble();

        String estado = sistema.validarSensores(evaporacion, presion);

        if (estado.equals("FALLO")) {
            System.out.println(sistema.generarFallo(evaporacion, presion));
        } else {
            double riesgo = sistema.calcularRiesgo(evaporacion, presion);
            String accion = sistema.decidirAccion(riesgo);
            System.out.println(sistema.generarReporte(riesgo, accion));
        }
    }

}
