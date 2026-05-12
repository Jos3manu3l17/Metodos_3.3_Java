import java.util.Scanner;

public class caso109 {
    
    // Caso 109: Protocolo de Bioseguridad - Ciclo de Esterilización en Autoclave: En el taller de simulación clínica, 
    // el aprendiz debe programar el módulo de control de un autoclave digital. El software debe procesar dos variables 
    // críticas: la temperatura interna de la cámara (°C) y la presión de vapor (psi). Según las normas de esterilización 
    // en salud, la "Constante de Muerte Térmica" para esporas bacterianas es un estándar técnico inamovible 
    // (generalmente 121°C a 15 psi durante 20 minutos), por lo que el inicio del conteo de tiempo no debe ser manual, 
    // sino una regla global del sistema. La lógica debe decidir si el ciclo es válido, si debe aumentar el calor o si 
    // debe abortar el proceso por una caída de presión que comprometa la esterilidad del instrumental. La seguridad del 
    // paciente es el requisito absoluto; por tanto, si la temperatura se reporta por encima de los 140°C 
    // (riesgo de daño al instrumental) o si la presión se registra como un valor negativo, el software debe bloquear la 
    // apertura de la puerta y genere un reporte de "Fallo de Ciclo Crítico" que devuelva un objeto con la temperatura 
    // detectada, la presión y el estado del agua destilada. El aprendiz debe estructurar el código de modo que la validación 
    // de estos parámetros sea la barrera de entrada para la certificación del paquete estéril, asegurando que no se utilicen 
    // herramientas contaminadas debido a un sensor de presión defectuoso. 

    //Constante global de esterilización
    static final double CONSTANTE_MUERTE_TERMICA_TEMP = 121.0;
    static final double CONSTANTE_MUERTE_TERMICA_PRES = 15.0;

    // 1) Validar sensores (barrera de seguridad)
    public String validarParametros(double temperatura, double presion) {
        if (temperatura > 140 || presion < 0) {
            return "FALLO";
        }
        return "OK";
    }

    // Evaluar si se cumplen condiciones base de esterilización
    public boolean condicionesEsteriles(double temperatura, double presion) {
        return (temperatura >= CONSTANTE_MUERTE_TERMICA_TEMP &&
                presion >= CONSTANTE_MUERTE_TERMICA_PRES);
    }

    // Decidir acción del sistema
    public String decidirAccion(boolean esteril) {
        if (esteril) {
            return "Ciclo válido. Iniciar conteo automático de 20 minutos.";
        } else {
            return "Aumentar calor hasta alcanzar parámetros de esterilización.";
        }
    }

    // Reporte de fallo crítico
    public String generarFallo(double temperatura, double presion, String estadoAgua) {
        return "\n--- FALLO DE CICLO CRÍTICO ---" +
               "\nTemperatura detectada: " + temperatura +
               "\nPresión detectada: " + presion +
               "\nEstado del agua destilada: " + estadoAgua +
               "\nPuerta bloqueada por seguridad.";
    }

    // Reporte normal
    public String generarReporte(String decision) {
        return "\n--- REPORTE AUTOCLAVE ---" +
               "\nDecisión del sistema: " + decision;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        caso109 sistema = new caso109();

        System.out.println("Temperatura de la cámara (°C): ");
        double temperatura = sc.nextDouble();

        System.out.println("Presión de vapor (psi): ");
        double presion = sc.nextDouble();

        System.out.println("Estado del agua destilada: ");
        String agua = sc.next();

        String estado = sistema.validarParametros(temperatura, presion);

        if (estado.equals("FALLO")) {
            System.out.println(sistema.generarFallo(temperatura, presion, agua));
        } else {
            boolean esteril = sistema.condicionesEsteriles(temperatura, presion);
            String decision = sistema.decidirAccion(esteril);
            System.out.println(sistema.generarReporte(decision));
        }
    }

}
