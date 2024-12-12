import java.time.Year;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu (){
        Scanner in= new Scanner(System.in);
        boolean salirPrograma=false;
        while(salirPrograma==false) {
            System.out.println(

                    "-----------MENU-----------\n" +
                            "a -> Mayores de edad\n" +
                            "b -> Calculadora de ingresos de canal de Youtube\n" +
                            "c -> Cálculo horario\n" +
                            "d -> Salir\n" +
                            "--------------------------"
            );
            System.out.println("Dime la opcione que deseas");
            String opcion = in.nextLine().toLowerCase();


            while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") &&
                    !opcion.equals("d")){
                System.out.println(

                        "-----------MENU-----------\n" +
                                "a -> Mayores de edad\n" +
                                "b -> Calculadora de ingresos de canal de Youtube\n" +
                                "c -> Cálculo horario\n" +
                                "d -> Salir\n" +
                                "--------------------------"
                );
                System.out.println("Dime la opcione que deseas");
                opcion = in.nextLine().toLowerCase();
            }


            System.out.println(opcion);


            switch (opcion) {

                case "a" -> {
                    System.out.println("Dime cuantas personas debo de comprobar");
                    int n = in.nextInt();
                    System.out.println(mayorEdad(n));
                }

                case "b" -> {
                    System.out.println(youTube());
                }

                case "c" -> {
                    System.out.println("Dime la hora de 01 a 12");
                    int hora = in.nextInt();
                    while (hora < 1 || hora > 12) {
                        System.out.println("Dime la hora de 01 a 12");
                        hora = in.nextInt();
                    }
                    System.out.println("Dime los minutos de 00 a 59");
                    int minutos = in.nextInt();
                    while (minutos > 59 || minutos < 0) {
                        System.out.println("Dime los minutos de 00 a 59");
                        minutos = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Dime si es AM o PM");
                    String letra = in.nextLine().toUpperCase();
                    while (!letra.equals("AM") && !letra.equals("PM")) {
                        System.out.println("Dime si es AM o PM");
                        letra = in.nextLine().toUpperCase();
                    }
                    System.out.println("Dime el huso horario");
                    int huso = in.nextInt();
                    while (huso < -11 || huso > 12) {
                        System.out.println("Dime el huso horario");
                        huso = in.nextInt();
                    }

                    int horaNueva = calculoHorario(hora, huso);

                    while (horaNueva > 12) {
                        horaNueva -= 12;
                    }
                    if (letra == "AM") {
                        letra = "PM";
                    } else {
                        letra = "AM";
                    }
                    System.out.println(horaNueva + ":" + minutos + " " + letra);
                }

                case "d" -> {
                    salirPrograma=true;
                    System.out.println("Adios");
                }

            }
        }
    }
    public static int mayorEdad(int n){
        Scanner in= new Scanner(System.in);

        int mayor=0;


        for (int i=1; i<=n; i++){
            System.out.println("En que año naciste");
            int ano= in.nextInt();
            int mayorEdad=Year.now().getValue()-ano;
            if (mayorEdad>=18){
                mayor++;
            }
        }

        return mayor;
    }
    public static double youTube (){

        Scanner in= new Scanner(System.in);
        boolean salir=false;
        double ingresosVideo=0;
        double ingresosCanal=0;


        while (salir==false) {
            System.out.println("Dime de que tematica es el video\n" +
                    "1 -> ASMR\n" +
                    "2 -> Deportes\n" +
                    "3-> Animales\n" +
                    "4-> Tecnología\n" +
                    "5-> Bebés ");
            int tematica = in.nextInt();

            while (tematica!=1 && tematica!=2 && tematica!=3 && tematica!=4 && tematica!=5 ) {
                System.out.println("Dime de que tematica es el video\n" +
                        "1 -> ASMR\n" +
                        "2 -> Deportes\n" +
                        "3-> Animales\n" +
                        "4-> Tecnología\n" +
                        "5-> Bebés ");
                tematica = in.nextInt();
            }

            System.out.println("¿Cuantas visitas tiene?");
            int visitas= in.nextInt();
            while (visitas<0){
                System.out.println("Tu numero no es valido debe de ser almenos 0");
                System.out.println("¿Cuantas visitas tiene?");
                visitas= in.nextInt();
            }

            switch (tematica){
                case 1 ->{
                    ingresosVideo=(0.1*visitas)/1000;
                }
                case 2-> {
                    ingresosVideo=(1.0*visitas)/1000;
                }
                case 3 ->{
                    ingresosVideo=(0.2*visitas)/1000;
                }
                case 4, 5 ->{
                    ingresosVideo=(0.5*visitas)/1000;
                }
            }
            ingresosCanal=ingresosCanal+ingresosVideo;
            System.out.println("Quieres seguir?");
            System.out.println("1-> Sí\n" +
                    "2-> No");
            int numSalir= in.nextInt();
            while (numSalir!=1 && numSalir!= 2){
                System.out.println("Quieres seguir?");
                System.out.println("1-> Sí\n" +
                        "2-> No");
                numSalir= in.nextInt();
            }
            if (numSalir==1){
                salir=true;
            }
        }
        return ingresosCanal;
    }
    public static int calculoHorario(int hora, int huso){
        int horanueva=hora;
        horanueva=horanueva+(huso);

        return horanueva;
    }
}


