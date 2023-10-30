import java.util.InputMismatchException;
import java.util.Scanner;

public class Sc {

    public static int scInt(){

        int x = 0;
        Scanner sc = new Scanner(System.in);

        try{

            x = sc.nextInt();

        }catch (InputMismatchException e){
            System.out.println("Dato Invatido!");
        }

        return x;
    }

    public static double scDouble(){

        double x = 0;
        Scanner sc = new Scanner(System.in);

        try{

            x = sc.nextDouble();

        }catch (InputMismatchException e){
            System.out.println("Dato Invatido!");
        }

        return x;
    }

    public static String scString(){

        String x = "";
        Scanner sc = new Scanner(System.in);

        try{

            x = sc.nextLine();

        }catch (InputMismatchException e){
            System.out.println("Dato Invatido!");
        }

        return x;
    }
}
