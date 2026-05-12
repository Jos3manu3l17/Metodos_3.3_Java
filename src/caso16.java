import java.util.Scanner;

public class caso16 {

    // Caso 16: El Protocolo de Acoplamiento de la Estación Hidropónica "Nemo-1": La estación de investigación submarina "Nemo-1" requiere un nuevo software 
    // para gestionar el acoplamiento de cápsulas de suministros. Usted debe desarrollar el componente lógico que procesa el acercamiento de estas unidades 
    // bajo condiciones de presión extrema. El sistema recibe como datos de entrada la velocidad de aproximación de la cápsula en nudos y la presión hidrostática 
    // externa medida en atmósferas. A partir de estos valores, el programa debe calcular un "Índice de Integridad de Escotilla". Existe una constante física denominada 
    // "Coeficiente de Resistencia del Titanio" que es idéntica para todas las esclusas de la estación, por lo que el cálculo de fatiga del metal debe estar 
    // disponible de forma global sin depender de una cápsula específica. Tras procesar el índice de integridad, el software debe emitir una orden crítica: 
    // si la integridad es óptima, se inicia la succión neumática; si es inestable, se activan los propulsores de frenado; y si es crítica, se aborta el 
    // acoplamiento sellando los compartimentos internos. El desafío aumenta porque el sistema de seguridad debe ser infalible: si los sensores de presión 
    // reportan un valor negativo o la velocidad de aproximación excede los límites de seguridad estructural (más de 15 nudos), el software debe bloquear 
    // todos los servomotores de la esclusa y generar un reporte de "Alerta de Colisión" que contenga la velocidad exacta, la presión detectada y el tiempo 
    // restante para el impacto. El aprendiz deberá estructurar la solución de modo que el veredicto final sea un mensaje de texto claro para el capitán, 
    // pero internamente el sistema debe manejar los cálculos con alta precisión decimal para evitar errores de redondeo que comprometan la vida de la tripulación 
    // en el fondo del océano. 

    // Constante global
    static final double COEFICIENTE_TITANIO = 1.37;

    public String validarSensores(double velocidad, double presion) {
        if (presion < 0 || velocidad > 15) {
            return "⚠ ALERTA DE COLISIÓN: Sensores fuera de rango. Servomotores bloqueados.";
        }
        return "Sensores operando dentro de parámetros seguros.";
    }

    public double calcularIndice(double velocidad, double presion) {
        return (presion * COEFICIENTE_TITANIO) / velocidad;
    }

    public String evaluarIntegridad(double indice) {
        if (indice >= 1.5) {
            return "Integridad ÓPTIMA → Iniciar succión neumática.";
        } else if (indice >= 1.0) {
            return "Integridad INESTABLE → Activar propulsores de frenado.";
        } else {
            return "Integridad CRÍTICA → Abortando acoplamiento y sellando compartimentos.";
        }
    }

    public String generarAlerta(double velocidad, double presion) {
        double tiempo = 100 / velocidad;
        return "REPORTE DE ALERTA\nVelocidad: " + velocidad +
               "\nPresión: " + presion +
               "\nTiempo estimado para impacto: " + tiempo + " segundos.";
    }

    public String generarReporte(String sensores, String decision, double indice) {
        return "\n--- REPORTE NEMO-1 ---" +
               "\nEstado Sensores: " + sensores +
               "\nÍndice de Integridad: " + indice +
               "\nDecisión del sistema: " + decision;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        caso16 sistema = new caso16();

        System.out.println("Velocidad de aproximación (nudos): ");
        double velocidad = sc.nextDouble();

        System.out.println("Presión hidrostática (atmósferas): ");
        double presion = sc.nextDouble();

        String estadoSensores = sistema.validarSensores(velocidad, presion);

        if (estadoSensores.contains("ALERTA")) {
            System.out.println(sistema.generarAlerta(velocidad, presion));
        } else {
            double indice = sistema.calcularIndice(velocidad, presion);
            String decision = sistema.evaluarIntegridad(indice);
            System.out.println(sistema.generarReporte(estadoSensores, decision, indice));
        }
    }
}


