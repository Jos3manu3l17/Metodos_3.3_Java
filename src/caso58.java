import java.util.Scanner;

public class caso58 {

    // Caso 58: Peritaje Forense - Sistema de Control de Acceso Binario "Secure-Gate";  El informe de auditoría forense 
    // tras la brecha de seguridad en el centro de datos "Titan" revela vulnerabilidades críticas en el módulo de validación 
    // de identidad multibiométrica. Se requiere que el nuevo software procese la tasa de coincidencia de minucias dactilares 
    // y el tiempo de respuesta del servidor de autenticación en milisegundos. El protocolo de seguridad de la compañía establece 
    // que el "Umbral de Falso Rechazo" es una constante criptográfica inamovible para todos los dispositivos periféricos de la 
    // red global, por lo cual el cálculo de la probabilidad de intrusión no debe ser una variable local, sino una regla general 
    // del sistema. La lógica de decisión debe evaluar si el acceso es concedido, si se requiere un segundo factor de autenticación 
    // o si se debe bloquear la terminal de inmediato por sospecha de ataque de presentación. Un hallazgo clave del peritaje es 
    // que el sistema anterior no validaba la integridad de los datos de entrada; por lo tanto, la nueva versión debe garantizar 
    // que si la tasa de coincidencia se reporta como un valor negativo o si el tiempo de respuesta excede el límite físico de la 
    // red (más de 10,000 ms), el software bloquee el puerto de comunicación y genere un reporte de "Intento de Evasión de Protocolo" 
    // que devuelva un objeto con la tasa detectada, el tiempo registrado y el ID del sensor afectado. El aprendiz debe estructurar 
    // métodos donde la validación de estos límites sea la primera línea de defensa, asegurando que ningún cálculo de acceso se ejecute 
    // si los parámetros de entrada no superan un riguroso examen de veracidad lógica, protegiendo así los activos digitales más 
    // críticos de la infraestructura contra manipulaciones externas. 

    static final double UMBRAL_FALSO_RECHAZO = 0.75;

    // Validar datos de entrada (primera línea de defensa)
    public String validarDatos(double tasaCoincidencia, int tiempoRespuesta) {
        if (tasaCoincidencia < 0 || tiempoRespuesta > 10000) {
            return "EVASION";
        }
        return "OK";
    }

    public double calcularProbabilidad(double tasaCoincidencia, int tiempoRespuesta) {
        return (1 - tasaCoincidencia) * UMBRAL_FALSO_RECHAZO + (tiempoRespuesta / 10000.0);
    }

    public String decidirAcceso(double probabilidad) {
        if (probabilidad < 0.3) {
            return "Acceso concedido.";
        } else if (probabilidad < 0.6) {
            return "Solicitar segundo factor de autenticación.";
        } else {
            return "Bloquear terminal por sospecha de ataque.";
        }
    }

    public String generarEvasion(double tasa, int tiempo, String sensorID) {
        return "\n--- INTENTO DE EVASIÓN DE PROTOCOLO ---" +
               "\nTasa detectada: " + tasa +
               "\nTiempo registrado: " + tiempo +
               "\nSensor afectado: " + sensorID +
               "\nPuerto de comunicación bloqueado.";
    }

    public String generarReporte(double probabilidad, String decision) {
        return "\n--- REPORTE SECURE-GATE ---" +
               "\nProbabilidad de intrusión: " + probabilidad +
               "\nDecisión del sistema: " + decision;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         caso58 sistema = new caso58();

        System.out.println("Tasa de coincidencia de huella (0 a 1): ");
        double tasa = sc.nextDouble();

        System.out.println("Tiempo de respuesta del servidor (ms): ");
        int tiempo = sc.nextInt();

        System.out.println("ID del sensor: ");
        String sensorID = sc.next();

        String estado = sistema.validarDatos(tasa, tiempo);

        if (estado.equals("EVASION")) {
            System.out.println(sistema.generarEvasion(tasa, tiempo, sensorID));
        } else {
            double probabilidad = sistema.calcularProbabilidad(tasa, tiempo);
            String decision = sistema.decidirAcceso(probabilidad);
            System.out.println(sistema.generarReporte(probabilidad, decision));
        }
    }
}
