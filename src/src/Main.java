import clases.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        boolean correcto = false;
        do {
            System.out.println("\n====== MENÚ EJERCICIOS ======");
            int opcion = sc.pedirNumero("Introduce el número del ejercicio" +
                    "\nIntroduce 0 para salir"+
                    "\nOpcion: ");

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!correcto);
    }


    public static void ejercicio1() {
        System.out.println("Ejecutando Ejercicio 1...");
        // Entre los primeros 667 mil números cuadrados, ¿cuál es la suma de todos los cuadrados impares?

        long suma = 0;
        for (int i = 1; i <= 928000; i += 2) {
            long cuadrado = (long) i * i;
            suma += cuadrado;
        }
        System.out.println("La suma es: " + suma);
    }

    public static void ejercicio2() {
        System.out.println("Ejecutando Ejercicio 2...");
        //Encuentra la suma de todos los múltiplos de 3 o 5 a hasta 1000.
        long suma = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                suma += i;
            }
        }
        System.out.println("La suma es: " + suma);
    }

    public static void ejercicio3() {
        System.out.println("Ejecutando Ejercicio 3...");
        //Considerando los términos de la secuencia de Fibonacci cuyos valores no superan los cuatro millones, encuentre la suma de los términos de valor par.
        long suma = 0;
        for (int i = 1; i < 4000000; i++) {
            if (i % 2 == 0) {}
        }
    }
}
