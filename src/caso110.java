import java.util.Scanner;

public class caso110 {
    // Caso 110: Gestión de Materiales - Mezclador Automático de Alginato y Yeso: Como parte de su práctica de laboratorio, 
    // el aprendiz desarrolla el software para un mezclador centrífugo de materiales de impresión. El sistema debe procesar 
    // el peso del polvo (gramos) y el volumen de agua (mililitros). El manual del fabricante define que la "Relación Polvo-Líquido 
    // Estándar" es una constante física fija para garantizar la estabilidad dimensional del modelo, permitiendo que el cálculo del 
    // tiempo de fraguado sea una función global compartida por todos los puestos de trabajo. El método debe determinar si la mezcla 
    // tendrá la consistencia óptima, si se requiere ajustar la velocidad de rotación o si debe detenerse para evitar la incorporación 
    // de burbujas de aire. El rigor en la técnica dental exige precisión; si el peso del polvo es menor a 5 g o si el volumen de agua 
    // se registra como un valor negativo, el programa debe disparar un protocolo de "Error de Dosificación", impidiendo el arranque 
    // del motor y generando un informe que detalle las cantidades registradas. El aprendiz enfrentará el desafío de programar métodos 
    // que no solo realicen cálculos de proporciones, sino que actúen como un filtro de calidad, garantizando que el software ignore 
    // cualquier dato inconsistente y priorice la fidelidad de la impresión dental frente a errores en la medición de los insumos 

        public static final double CONSTANTE_EVAPORACION = 2.5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el peso de la muestra (g): ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese el tiempo programado (min): ");
        double tiempo = sc.nextDouble();

        if (!validarParametros(peso, tiempo)) {
            generarError(peso, tiempo);
            return;
        }

        double indice = calcularIndiceEvaporacion(peso, tiempo);
        double tiempoReal = calcularTiempoReal(indice);

        evaluarMuestra(indice, tiempoReal);
    }

    public static boolean validarParametros(double peso, double tiempo) {
        return peso >= 10 && tiempo > 0;
    }

    public static double calcularIndiceEvaporacion(double peso, double tiempo) {
        return peso / tiempo;
    }

    public static double calcularTiempoReal(double indice) {
        return 15 + (indice * 3);
    }

    public static void evaluarMuestra(double indice, double tiempoReal) {

        System.out.println("\n--- RESULTADO DEL PROCESO ---");
        System.out.println("Índice de evaporación: " + indice);
        System.out.println("Tiempo real estimado: " + tiempoReal + " min");

        if (indice == CONSTANTE_EVAPORACION) {
            System.out.println("Estado: Secado optimo.");
        } else if (indice > CONSTANTE_EVAPORACION) {
            System.out.println("Estado: Muestra sobreexpuesta. Reducir temperatura.");
        } else {
            System.out.println("Estado: Muestra húmeda. Aumentar tiempo de secado.");
        }
    }

    public static void generarError(double peso, double tiempo) {
        System.out.println("\n*** ERROR DE PARAMETROS ***");
        System.out.println("Peso registrado: " + peso + " g");
        System.out.println("Tiempo registrado: " + tiempo + " min");
        System.out.println("Proceso detenido por valores inválidos.");
    }
}
