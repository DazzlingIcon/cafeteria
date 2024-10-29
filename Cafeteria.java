import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pedido {
    String nombreCliente;
    String[] productos;
    int[] cantidades;

    public Pedido(String nombreCliente, String[] productos, int[] cantidades) {
        this.nombreCliente = nombreCliente;
        this.productos = productos;
        this.cantidades = cantidades;
    }

    // Método para mostrar los detalles del pedido
    public void mostrarPedido() {
        System.out.println("Cliente: " + nombreCliente);
        for (int i = 0; i < productos.length; i++) {
            System.out.println("- " + productos[i] + ": " + cantidades[i]);
        }
    }
}

public class Cafeteria {
    static Queue<Pedido> colaPedidos = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Registrar pedido");
            System.out.println("2. Atender pedido");
            System.out.println("3. Ver pedidos pendientes");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarPedido(scanner);
                    break;
                case 2:
                    atenderPedido();
                    break;
                case 3:
                    verPedidosPendientes();
                    break;
            }
        } while (opcion != 0);
    }

    private static void registrarPedido(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.next();

        System.out.print("Número de productos: ");
        int numProductos = scanner.nextInt();

        String[] productos = new String[numProductos];
        int[] cantidades = new int[numProductos];

        for (int i = 0; i < numProductos; i++) {
            System.out.print("Producto " + (i+1) + ": ");
            productos[i] = scanner.next();
            System.out.print("Cantidad: ");
            cantidades[i] = scanner.nextInt();
        }

        Pedido nuevoPedido = new Pedido(nombre, productos, cantidades);
        colaPedidos.add(nuevoPedido);
        System.out.println("Pedido registrado correctamente.");
    }

    private static void atenderPedido() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            Pedido pedido = colaPedidos.poll();
            System.out.println("Atendiendo pedido:");
            pedido.mostrarPedido();
        }
    }

    private static void verPedidosPendientes() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Pedidos pendientes:");
            for (Pedido pedido : colaPedidos) {
                pedido.mostrarPedido();
            }
        }
    }
}