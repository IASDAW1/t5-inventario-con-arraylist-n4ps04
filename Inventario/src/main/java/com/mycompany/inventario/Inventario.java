/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario;

/**
 *
 * @author beltr
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {


    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    agregarProducto(nombres, precios, cantidades, scanner);
                    break;
                case 2:
                    actualizarInventario(nombres, precios, cantidades, scanner);
                    break;
                case 3:
                    buscarProducto(nombres, precios, cantidades, scanner);
                    break;
                case 4:
                    mostrarInventario(nombres, precios, cantidades);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void agregarProducto(
            ArrayList<String> nombres, ArrayList<Double> precios, ArrayList<Integer> cantidades, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = scanner.nextInt();

        nombres.add(nombre);
        precios.add(precio);
        cantidades.add(cantidad);

        System.out.println("Producto agregado con éxito.");
    }

    private static void actualizarInventario(
            ArrayList<String> nombres, ArrayList<Double> precios, ArrayList<Integer> cantidades, Scanner scanner) {
        mostrarInventario(nombres, precios, cantidades);

        System.out.print("Ingrese el índice del producto que desea actualizar: ");
        int indice = scanner.nextInt();

        if (indice >= 0 && indice < nombres.size()) {
            System.out.print("Ingrese la nueva cantidad en stock: ");
            int nuevaCantidad = scanner.nextInt();

            cantidades.set(indice, nuevaCantidad);

            System.out.println("Inventario actualizado con éxito.");
        } else {
            System.out.println("Índice no válido. No se pudo actualizar el inventario.");
        }
    }

    private static void buscarProducto(
            ArrayList<String> nombres, ArrayList<Double> precios, ArrayList<Integer> cantidades, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto que desea buscar: ");
        String nombreBusqueda = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < nombres.size(); i++) {
            if (nombreBusqueda.equalsIgnoreCase(nombres.get(i))) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + nombres.get(i));
                System.out.println("Precio: " + precios.get(i));
                System.out.println("Cantidad en stock: " + cantidades.get(i));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarInventario(
            ArrayList<String> nombres, ArrayList<Double> precios, ArrayList<Integer> cantidades) {
        System.out.println("Inventario actual:");

        for (int i = 0; i < nombres.size(); i++) {
            System.out.println((i + 1) + ". " + nombres.get(i) +
                    " - Precio: " + precios.get(i) +
                    ", Cantidad en stock: " + cantidades.get(i));
        }
    }
}

