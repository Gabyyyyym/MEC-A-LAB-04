
package javaapplication13;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
        

public class EPS {

   
    public static void main(String[] args) {
        Queue<Paciente> cola=new LinkedList<>();
        int numturno=1;
        while(true){
            Scanner sc= new Scanner(System.in);
            System.out.print("NOMBRE Y APELLIDO: ");
            String nombre=sc.nextLine();
            System.out.print("EDAD: ");
            int edad=sc.nextInt();
            sc.nextLine();
            System.out.print("AFiILIACION(POS/PC): ");
            String afi=sc.nextLine();
            System.out.print("CONDICION ESPECIAL(E/LM): ");
            String limi=sc.nextLine();
            
            
        }
      
    }
    
}
