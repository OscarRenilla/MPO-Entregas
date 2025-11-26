// Entre los primeros 667 mil números cuadrados, ¿cuál es la suma de todos los cuadrados impares?

public class Main {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i <= 20; i++){
            int cuadrado = i * i;
            if (i % 2 != 0){
                suma = suma + cuadrado;
            }
        }
        System.out.println("La suma es: " + suma);
    }
}
