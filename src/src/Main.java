// Entre los primeros 667 mil números cuadrados, ¿cuál es la suma de todos los cuadrados impares?

public class Main {
    public static void main(String[] args) {
        long suma = 0;
        for (int i = 1; i <= 415000; i += 2) {
            long cuadrado = (long) i * i;
            suma += cuadrado;
        }
        System.out.println("La suma es: " + suma);
    }
}

//Encuentra la suma de todos los múltiplos de 3 o 5 a continuación de 1000.
