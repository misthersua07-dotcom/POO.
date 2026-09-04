public class Ejercicio3 {

    static double sumar(double a, double b) {
        return a + b;
    }

    static double restar(double a, double b) {
        return a - b;
    }

    static double multiplicar(double a, double b) {
        return a * b;
    }

    static double dividir(double a, double b) {
        
        if (b == 0) {
            System.out.println("Error: no se puede dividir por cero");
            return 0;
        }
        return a / b;
    }

    static void mostrarResultado(String operacion, double resultado) {
        System.out.println("Operacion: " + operacion + " -> Resultado: " + resultado);
    }

    public static void main(String[] args) {
        double a = 20, b = 30;

        double resultadoSuma = sumar(a, b);
        mostrarResultado("Suma", resultadoSuma);

        double resultadoResta = restar(a, b);
        mostrarResultado("Resta", resultadoResta);

        double resultadoMultiplicacion = multiplicar(a, b);
        mostrarResultado("Multiplicacion", resultadoMultiplicacion);

        double resultadoDivision = dividir(a, b);
        mostrarResultado("Division", resultadoDivision);

        mostrarResultado("Division por cero", dividir(a, 0));
    }
}
