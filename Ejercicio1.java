import java.util.ArrayList;
import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {

        // Array de nombres para generar personas aleatorias
        String[] nombres = {
            "Ana", "Luis", "Carlos", "Maria", "Pedro",
            "Laura", "Jose", "Sofia", "Andres", "Camila"
        };

        Random random = new Random();
        ArrayList<Persona> personas = new ArrayList<>();

        // Creamos 10 personas con edad aleatoria (RECORRIDO DE ARRAY)
        for (int i = 0; i < nombres.length; i++) {
            int edad = random.nextInt(50) + 5; // edades entre 5 y 54
            String documento = "10" + (1000 + i);
            Persona p = new Persona(nombres[i], edad, documento);
            personas.add(p);
        }

        System.out.println("=== Lista de personas ===");

        // Recorremos el ArrayList (RECORRIDO DE ARRAYLIST)
        for (Persona p : personas) {
            p.mostrarInformacion();

            if (p.esMayorDeEdad()) {
                System.out.println("Nombre: " + p.getNombre() + " Es mayor de edad");
            } else {
                System.out.println("Nombre: " + p.getNombre() + " No es mayor de edad");
            }
            System.out.println("-----------------------------------");
        }
    }
}

// Clase Persona: atributos privados = ENCAPSULAMIENTO
class Persona {
    private String nombre;
    private int edad;
    private String documento;

    // Constructor: inicializa los 3 atributos
    public Persona(String nombre, int edad, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        // Validacion de informacion: la edad no puede ser negativa
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad invalida, se asigna 0 por defecto.");
            this.edad = 0;
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // Muestra los datos de la persona
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad + " | Documento: " + documento);
    }

    // Retorna true si la persona es mayor de edad (edad > 18)
    public boolean esMayorDeEdad() {
        return edad > 18;
    }
}
