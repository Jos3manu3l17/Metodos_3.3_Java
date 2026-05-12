import java.util.Scanner;

public class prueba {

    // inteligente de administración y monitoreo de empresas de fabricación de dispositivos médicos: 
    // Una compañía internacional de tecnología médica necesita implementar un sistema inteligente capaz de controlar 
    // líneas de producción, pruebas de calidad, distribución y mantenimiento de dispositivos médicos utilizados en 
    // hospitales y clínicas. El sistema debe registrar información sobre componentes electrónicos, procesos de ensamblaje, 
    // calibración de equipos y resultados de pruebas técnicas en tiempo real. La complejidad del problema radica en que los 
    // dispositivos médicos deben cumplir estrictas normas internacionales de calidad y cualquier falla podría poner en riesgo 
    // la vida de los pacientes. El programa debe analizar continuamente el funcionamiento de maquinaria industrial y resultados 
    // de pruebas técnicas para detectar defectos de fabricación, errores de calibración o inconsistencias en componentes 
    // electrónicos. Además, el sistema debe coordinar inventarios de piezas especializadas, proveedores internacionales y 
    // distribución de equipos médicos hacia diferentes países. También debe monitorear condiciones de almacenamiento y 
    // transporte para garantizar que los dispositivos lleguen en óptimas condiciones a hospitales y laboratorios. Otro desafío 
    // importante consiste en administrar mantenimientos preventivos y actualizaciones tecnológicas de los dispositivos después 
    // de ser vendidos. El sistema también debe detectar reportes de fallas clínicas y generar alertas automáticas cuando se 
    // identifiquen riesgos asociados a determinados modelos de equipos médicos. Asimismo, la plataforma debe generar reportes 
    // completos sobre productividad industrial, calidad de fabricación, costos operativos y cumplimiento de normas sanitarias 
    // internacionales. El diseño debe ser modular y escalable para permitir futuras integraciones con inteligencia artificial, 
    // robótica médica y sistemas avanzados de monitoreo clínico. 


        public String controlarProduccion(int ensamblados, int defectuosos) {
        if (defectuosos > 5) {
            return "Alta tasa de defectos en producción.";
        }
        return "Producción estable.";
    }

    public String verificarCalidad(boolean pruebaTecnica) {
        return pruebaTecnica ? "Pruebas técnicas aprobadas." : "⚠ Fallo en pruebas de calidad.";
    }

    public String gestionarInventario(int piezasDisponibles) {
        if (piezasDisponibles < 10) {
            return "Inventario bajo. Solicitar a proveedores.";
        }
        return "Inventario suficiente.";
    }

    public String monitorearTransporte(double temperatura) {
        if (temperatura > 30) {
            return "Riesgo en transporte por temperatura elevada.";
        }
        return "Condiciones de transporte adecuadas.";
    }

    public String gestionarMantenimiento(boolean mantenimientoVencido) {
        return mantenimientoVencido ? "Programar mantenimiento preventivo." : "Mantenimiento al día.";
    }

    public String generarReporte(String p, String c, String i, String t, String m) {
        return "\n--- REPORTE DISPOSITIVOS MÉDICOS ---" +
               "\nProducción: " + p +
               "\nCalidad: " + c +
               "\nInventario: " + i +
               "\nTransporte: " + t +
               "\nMantenimiento: " + m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        prueba sistema = new prueba();

        System.out.println("Cantidad ensamblados:");
        int ensamblados = sc.nextInt();

        System.out.println("Cantidad defectuosos:");
        int defectuosos = sc.nextInt();

        System.out.println("¿Prueba técnica aprobada? (true/false):");
        boolean prueba = sc.nextBoolean();

        System.out.println("Piezas disponibles en inventario:");
        int piezas = sc.nextInt();

        System.out.println("Temperatura de transporte:");
        double temp = sc.nextDouble();

        System.out.println("¿Mantenimiento vencido? (true/false):");
        boolean mantenimiento = sc.nextBoolean();

        String p = sistema.controlarProduccion(ensamblados, defectuosos);
        String c = sistema.verificarCalidad(prueba);
        String i = sistema.gestionarInventario(piezas);
        String t = sistema.monitorearTransporte(temp);
        String m = sistema.gestionarMantenimiento(mantenimiento);

        System.out.println(sistema.generarReporte(p, c, i, t, m));

    }
}

