package javaapplication9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JavaApplication9 {

    public static void main(String[] args) {
        numerosaleatorios();
        ordenarnumeros();
    }

    public static void numerosaleatorios() {
        try (BufferedWriter puntero = new BufferedWriter(new FileWriter("numeros.txt"))) {
            Random random = new Random();
            for (int i = 0; i < 1000000; i++) {
                int numero = random.nextInt(20000001) - 10000000; 
                puntero.write(String.valueOf(numero));
                puntero.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void ordenarnumeros() {
    try {
        ArrayList<Integer> numeros = new ArrayList<>();
        java.nio.file.Files.lines(java.nio.file.Paths.get("numeros.txt"))
                .map(Integer::parseInt)  // Convertir cada línea a entero
                .forEach(numeros::add);

        Collections.sort(numeros);

        try (BufferedWriter puntero = new BufferedWriter(new FileWriter("numeros_ordenados.txt"))) {
            for (int numero : numeros) {
                puntero.write(String.valueOf(numero));
                puntero.newLine();
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer/escribir en el archivo: " + e.getMessage());
    }
}

}
