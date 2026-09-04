import java.util.ArrayList;
import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {

        
        String[] nombres = {
            "Ana", "Luis", "Carlos", "Maria", "Pedro",
            "Laura", "Jose", "Sofia", "Andres", "Camila"
        };

        Random random = new Random();
        ArrayList<Persona> personas = new ArrayList<>();

       
        for (int i = 0; i < nombres.length; i++) {
            int edad = random.nextInt(50) + 5; // edades entre 5 y 54
            String documento = "10" + (1000 + i);
            Persona p = new Persona(nombres[i], edad, documento);
            personas.add(p);
        }

        System.out.println("=== Lista de personas ===");

       
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


class Persona {
    private String nombre;
    private int edad;
    private String documento;

   
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

   
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad + " | Documento: " + documento);
    }

   
    public boolean esMayorDeEdad() {
        return edad > 18;
    }
}
