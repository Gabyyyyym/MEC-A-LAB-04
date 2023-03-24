import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EPS {
    static class Paciente {
        String nombre;
        int edad;
        String afiliacion;
        boolean condicionEspecial;
        
        public Paciente(String nombre, int edad, String afiliacion, boolean condicionEspecial) {
            this.nombre = nombre;
            this.edad = edad;
            this.afiliacion = afiliacion;
            this.condicionEspecial = condicionEspecial;
        }
        
        public String toString() {
            return this.nombre + " (" + this.edad + ")";
        }
    }
    
    static Queue<Paciente> colaEspera = new LinkedList<>();
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        int turnoActual = 1;
        
        while (true) {
            System.out.println("Ingrese los datos del paciente:");
            System.out.print("Nombre y apellidos: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Afiliación (POS o PC): ");
            String afiliacion = scanner.nextLine();
            System.out.print("¿Tiene alguna condición especial? (S/N): ");
            boolean condicionEspecial = scanner.nextLine().equalsIgnoreCase("S");
            
            Paciente nuevoPaciente = new Paciente(nombre, edad, afiliacion, condicionEspecial);
            
            if (esPrioritario(nuevoPaciente)) {
                colaEspera.add(nuevoPaciente);
                System.out.println("El paciente " + nuevoPaciente + " es prioritario y ha sido agregado a la cola de espera.");
            } else {
                colaEspera.add(nuevoPaciente);
                System.out.println("El paciente " + nuevoPaciente + " ha sido agregado a la cola de espera.");
            }
            
            System.out.println("Turno actual: " + turnoActual);
            System.out.println("Pacientes en espera: " + colaEspera.size());
            
            while (!colaEspera.isEmpty()) {
                Paciente pacienteActual = colaEspera.poll();
                System.out.println("Turno " + turnoActual + ": " + pacienteActual);
                
                int tiempoEspera = 5; // tiempo en segundos
                while (tiempoEspera > 0) {
                    System.out.println("Tiempo restante: " + tiempoEspera + " segundos.");
                    Thread.sleep(1000);
                    tiempoEspera--;
                }
                
                turnoActual++;
            }
        }
    }
    
    static boolean esPrioritario(Paciente paciente) {
        return paciente.edad <= 12 || paciente.edad >= 60 || paciente.condicionEspecial || paciente.afiliacion.equalsIgnoreCase("PC");
    }
}