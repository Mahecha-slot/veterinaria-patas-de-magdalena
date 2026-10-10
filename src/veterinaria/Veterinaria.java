package veterinaria;

public class Veterinaria {

        // ===== Clase Mascota =====
        static class Mascota {
            // 1. Atributos privados
            private String nombre;
            private String especie;
            private double peso;   // en kilos
            private int edad;      // en años

            // 1. Constructor
            public Mascota(String nombre, String especie, double peso, int edad) {
                this.nombre = nombre;
                this.especie = especie;
                this.peso = peso;
                this.edad = edad;
            }

            // 2. Un get por cada atributo
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

            // 3. setPeso con validación
            public void setPeso(double nuevoPeso) {
                if (nuevoPeso <= 0) {
                    System.out.println("RECHAZADO: el peso no puede ser " + nuevoPeso + " kg");
                    return;
                }
                this.peso = nuevoPeso;
            }

            // 3. setEdad con validación
            public void setEdad(int nuevaEdad) {
                if (nuevaEdad < 0) {
                    System.out.println("RECHAZADO: la edad no puede ser " + nuevaEdad + " anios");
                    return;
                }
                this.edad = nuevaEdad;
            }

            // 4. valorConsulta()
            public int valorConsulta() {
                int valor;
                if (peso > 25) {
                    valor = 55000;
                } else if (peso > 10) {
                    valor = 45000;
                } else {
                    valor = 35000;
                }

                // Si además tiene 8 años o más, se le suman 12000
                if (edad >= 8) {
                    valor = valor + 12000;
                }
                return valor;
            }

            // 5. descripcion()
            public String descripcion() {
                return nombre + " (" + especie + ", " + peso + " kg, " + edad + " anios)";
            }
        }

        // ===== main =====
        public static void main(String[] args) {

            // 6. Arreglo de 4 Mascota
            Mascota[] pacientes = new Mascota[4];
            pacientes[0] = new Mascota("Luna", "Perro", 28.5, 9);
            pacientes[1] = new Mascota("Michi", "Gato", 4.2, 3);
            pacientes[2] = new Mascota("Rocky", "Perro", 12.0, 5);
            pacientes[3] = new Mascota("Copito", "Conejo", 2.1, 8);

            // 7. Recorrer con un for e ir acumulando el total
            int total = 0;
            for (int i = 0; i < pacientes.length; i++) {
                Mascota m = pacientes[i];
                System.out.println(m.descripcion() + " -> $" + m.valorConsulta());
                total = total + m.valorConsulta();
            }
            System.out.println("TOTAL RECAUDADO: $" + total);

            // 8. Intento de dejar a Michi en -3 kg
            System.out.println("--- Intento de cambiar el peso de Michi ---");
            pacientes[1].setPeso(-3);
            System.out.println(pacientes[1].descripcion());
        }
    }