package veterinaria;

public class Mascotas {
    static class Mascota {
        private final String nombre;
        private final String especie;
        private double peso;
        private int edad;

        public Mascota(String nombre, String especie,
                       double peso, int edad) {
            this.nombre = nombre;
            this.especie = especie;
            this.peso = peso;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEspecie() {
            return especie;
        }

        public double getPeso() {
            return peso;
        }

        public int getEdad() {
            return edad;
        }

        public void setPeso(double nuevoPeso) {
            if (nuevoPeso <= 0) {
                System.out.println(
                        "RECHAZADO: el peso debe ser mayor que cero."
                );
                return;
            }

            this.peso = nuevoPeso;
        }

        public void setEdad(int nuevaEdad) {
            if (nuevaEdad < 0) {
                System.out.println(
                        "RECHAZADO: la edad no puede ser negativa."
                );
                return;
            }

            this.edad = nuevaEdad;
        }

        public int valorConsulta() {
            int valor;

            if (peso > 25) {
                valor = 55000;
            } else if (peso > 10) {
                valor = 45000;
            } else {
                valor = 35000;
            }

            if (edad >= 8) {
                valor += 12000;
            }

            return valor;
        }

        public String descripcion() {
            return nombre + " (" + especie + ", "
                    + peso + " kg, " + edad + " anios)";
        }
    }

    public static void main(String[] args) {
        Mascota[] pacientes = new Mascota[4];

        pacientes[0] = new Mascota(
                "Luna", "Perro", 28.5, 9
        );

        pacientes[1] = new Mascota(
                "Michi", "Gato", 4.2, 3
        );

        pacientes[2] = new Mascota(
                "Rocky", "Perro", 12.0, 5
        );

        pacientes[3] = new Mascota(
                "Pepa", "Conejo", 2.1, 1
        );

        int totalRecaudado = 0;

        for (int i = 0; i < pacientes.length; i++) {
            Mascota mascota = pacientes[i];

            if (mascota != null) {
                System.out.println(mascota.descripcion());

                System.out.println(
                        "Valor de consulta: $"
                                + mascota.valorConsulta()
                );

                totalRecaudado += mascota.valorConsulta();
                System.out.println();
            }
        }

        System.out.println(
                "TOTAL RECAUDADO: $" + totalRecaudado
        );

        System.out.println();
        System.out.println("Prueba de validacion con Michi:");

        pacientes[1].setPeso(-3);

        System.out.println(pacientes[1].descripcion());
    }
}
