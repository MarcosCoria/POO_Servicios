/* Ejercicio_03: Realizar una clase llamada Persona en el paquete de entidades que
tengan los siguientes atributos: nombre, edad, sexo (‘H’ para hombre, ‘M’
para mujer, ‘O’ para otro), peso y altura. Si desea añadir algún otro
atributo, puede hacerlo. Agregar constructores, getters y setters.
En el paquete Servicios crear PersonaServicio con los siguientes 3
métodos:
a) Método esMayorDeEdad(): indica si la persona es mayor de edad. La
función devuelve un booleano.
b) Metodo crearPersona(): el método crear persona, le pide los valores
de los atributos al usuario y después se le asignan a sus respectivos
atributos para llenar el objeto Persona. Además, comprueba que el
sexo introducido sea correcto, es decir, H, M o O. Si no es correcto se
deberá mostrar un mensaje
3
c) Método calcularIMC(): calculara si la persona está en su peso ideal
(peso en kg/(altura^2 en mt2)). Si esta fórmula da por resultado un
valor menor que 20, significa que la persona está por debajo de su
peso ideal y la función devuelve un -1. Si la fórmula da por resultado
un número entre 20 y 25 (incluidos), significa que la persona está en
su peso ideal y la función devuelve un 0. Finalmente, si el resultado
de la fórmula es un valor mayor que 25 significa que la persona tiene
sobrepeso, y la función devuelve un 1.
A continuación, en la clase main hacer lo siguiente:
● Crear 4 objetos de tipo Persona con distintos valores, a continuación,
llamaremos todos los métodos para cada objeto, deberá comprobar si la
persona está en su peso ideal, tiene sobrepeso o está por debajo de su
peso ideal e indicar para cada objeto si la persona es mayor de edad.
● Por último, guardaremos los resultados de los métodos calcularIMC y
esMayorDeEdad en distintas variables(arrays), para después calcular un
porcentaje de esas 4 personas cuantas están por debajo de su peso,
cuantas en su peso ideal y cuantos, por encima, y también calcularemos
un porcentaje de cuantos son mayores de edad y cuantos menores. Para
esto, podemos crear unos métodos adicionales */
package Servicio;

import Entidad.Persona;
import java.util.Scanner;

/* @author G96xyFast */
public class PersonaServicio {

    public Persona CrearPersona() {
        Scanner leer = new Scanner(System.in);
        Persona pers = new Persona();
        System.out.println("Ingrese nombre de la persona: ");
        pers.setNombre(ComprobarString());
        System.out.println("Ingrese edad: ");
        pers.setEdad(ComprobarInt());
        System.out.println("Ingrese sexo(M/F/O): ");
        pers.setSexo(ComprobarChar()); // Verificar char
        System.out.println("Ingrese peso: ");
        pers.setPeso(ComprobarFloat());
        System.out.println("Ingrese altura: ");
        pers.setAltura(ComprobarFloat());
        return pers;
    }

    public int EsMayor(Persona pers) {
        int var;
        if (pers.getEdad() >= 18) {
            return 1;
        } else {
            return 0;
        }
    }

    // (peso en kg/(altura^2 en mt2))
    public int CalcularIMC(Persona pers) {
        double imc = pers.getPeso() / Math.pow(pers.getAltura(), 2);
        System.out.println("El IMC de la persona es: " + imc);
        if (imc < 20) {
            return -1;
        } else if (imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public String ComprobarString() {
        Scanner leer = new Scanner(System.in);
        String nombre = leer.nextLine();
        boolean var = false;
        while (var == false) {
            boolean aux = false;
            for (int i = 0; i < nombre.length(); i++) {
                if (nombre.substring(i, i + 1).equals(" ")) {
                    aux = true;
                }
            }
            if (nombre.isEmpty() || aux == true) {
                System.out.println("Error. Ingrese un nombre válido: ");
                nombre = leer.nextLine();
            } else {
                var = true; // Rompemos el bucle principal
            }
        }
        return nombre;
    }
    
    public char ComprobarChar(){
        Scanner leer = new Scanner(System.in);
        char aux= leer.next().charAt(0);
        boolean var= false;
        while (var==false){
            if ((aux!='M' && aux!='O' && aux!='F' && aux!='m' && aux!='o' && aux!='f')) {
                System.out.println("Error. Ingrese un caráter válido: ");
                aux= leer.next().charAt(0);
            } else {
                var= true;
            }
        }
        return aux;
    }

    public int ComprobarInt() {
        Scanner leer = new Scanner(System.in);
        int aux = leer.nextInt();
        while (aux <= 0) {
            System.out.println("Error. Ingrese un dato válido: ");
            aux = leer.nextInt();
        }
        return aux;
    }

    public float ComprobarFloat() {
        Scanner leer = new Scanner(System.in);
        float aux = leer.nextFloat();
        while (aux <= 0) {
            System.out.println("Error. Ingrese un dato válido: ");
            aux = leer.nextFloat();
        }
        return aux;
    }

}
