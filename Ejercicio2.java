import java.util.ArrayList;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {

        String[] nombres = {
            "Pepito Perez", "Ana Gomez", "Luis Diaz", "Marta Ruiz", "Carlos Leon",
            "Sofia Vera", "Andres Paz", "Laura Cruz", "Diego Sosa", "Camila Rey"
        };

        Random random = new Random();
        ArrayList<Empleado> empleados = new ArrayList<>();

       
        for (int i = 0; i < nombres.length; i++) {
            if (i % 2 == 0) {
                long salario = 1000000 + random.nextInt(500000);
                long bonificacion = 100000 + random.nextInt(200000);
                empleados.add(new EmpleadoTiempoCompleto(nombres[i], salario, bonificacion));
            } else {
                int horas = 20 + random.nextInt(21); // entre 20 y 40 horas
                long valorHora = 60000;
                empleados.add(new EmpleadoPorHoras(nombres[i], horas, valorHora));
            }
        }

        int contador = 1;
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoPorHoras eh) {
                System.out.println("Empleado " + contador + ": \"" + e.getNombre() +
                        "\", Salario Actual: \"" + eh.calcularSalario() +
                        "\", Cantidad horas trabajadas: " + eh.getHorasTrabajadas() +
                        ". Valor de la hora: " + eh.getValorHora());
            } else {
                System.out.println("Empleado " + contador + ": \"" + e.getNombre() +
                        "\", Salario Actual: \"" + e.calcularSalario() + "\"");
            }
            contador++;
        }
    }
}

// Clase padre
class Empleado {
    protected String nombre;
    protected long salario;

    public Empleado(String nombre, long salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public long getSalario() {
        return salario;
    }

    public long calcularSalario() {
        return salario;
    }
}

class EmpleadoTiempoCompleto extends Empleado {
    private long bonificacion;

    public EmpleadoTiempoCompleto(String nombre, long salario, long bonificacion) {
        super(nombre, salario); 
        this.bonificacion = bonificacion;
    }

    public long getBonificacion() {
        return bonificacion;
    }

    // SOBREESCRITURA (override) del metodo del padre
    @Override
    public long calcularSalario() {
        return salario + bonificacion;
    }
}

class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private long valorHora;

    public EmpleadoPorHoras(String nombre, int horasTrabajadas, long valorHora) {
        super(nombre, 0);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public long getValorHora() {
        return valorHora;
    }

    @Override
    public long calcularSalario() {
        return horasTrabajadas * valorHora;
    }
}
