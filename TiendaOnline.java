import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String nombre, String descripcion, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;


        // Getters y setters
    }
    public String getNombre() {
        return nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Categoría: " + categoria);
        System.out.println();
    }

    public void restarStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock disponible.");
        }
    }
}

public class TiendaOnline {
    private List<Producto> productos;
    private Scanner scanner;

    public TiendaOnline() {
        productos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }

    public void buscarProducto(String filtro) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(filtro) || producto.getCategoria().equalsIgnoreCase(filtro)) {
                producto.mostrarInformacion();
            }
        }
    }

    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción:");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio:");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese el stock:");
        int stock = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la categoría:");
        String categoria = scanner.nextLine();

        Producto nuevoProducto = new Producto(nombre, descripcion, precio, stock, categoria);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    public void modificarProducto() {
        System.out.println("Ingrese el nombre del producto a modificar:");
        String nombre = scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ingrese la nueva descripción:");
                producto.setDescripcion(scanner.nextLine());
                System.out.println("Ingrese el nuevo precio:");
                producto.setPrecio(Double.parseDouble(scanner.nextLine()));
                System.out.println("Ingrese el nuevo stock:");
                producto.setStock(Integer.parseInt(scanner.nextLine()));
                System.out.println("Ingrese la nueva categoría:");
                producto.setCategoria(scanner.nextLine());

                System.out.println("Producto modificado con éxito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto() {
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String nombre = scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(producto);
                System.out.println("Producto eliminado con éxito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    public void realizarCompra() {
        System.out.println("Ingrese el nombre del producto a comprar:");
        String nombre = scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ingrese la cantidad a comprar:");
                int cantidad = Integer.parseInt(scanner.nextLine());

                producto.restarStock(cantidad);

                System.out.println("Compra realizada con éxito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("---- Menú ----");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Buscar producto");
            System.out.println("3. Agregar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Realizar compra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre o categoría a buscar:");
                    String filtro = scanner.nextLine();
                    buscarProducto(filtro);
                    break;
                case 3:
                    agregarProducto();
                    break;
                case 4:
                    modificarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    realizarCompra();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        TiendaOnline tienda = new TiendaOnline();
        tienda.mostrarMenu();
    }
}