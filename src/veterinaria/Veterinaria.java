package veterinaria;

public class Veterinaria {

    public static void main(String[] args) {

        Mascota[] pacientes = new Mascota[4];

        pacientes[0] = new Mascota("Luna", "Perro", 28.5, 9);
        pacientes[1] = new Mascota("Michi", "Gato", 4.2, 3);
        pacientes[2] = new Mascota("Rocky", "Perro", 12.0, 5);
        pacientes[3] = new Mascota("Pepa", "Conejo", 2.1, 1);

        int totalRecaudado = 0;

        for (int i = 0; i < pacientes.length; i++) {
            Mascota m = pacientes[i];
            int valor = m.valorConsulta();

            System.out.println(m.descripcion() + " -> consulta: " + valor);

            totalRecaudado = totalRecaudado + valor;
        }

        System.out.println("TOTAL RECAUDADO: " + totalRecaudado);
        System.out.println();
        System.out.println("Intentando poner a Michi en -3 kg...");
        pacientes[1].setPeso(-3);
        System.out.println(pacientes[1].descripcion());
    }
}