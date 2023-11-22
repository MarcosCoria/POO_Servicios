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
esMayorDeEdad en distintas variables(arrays):
para después calcular un porcentaje de esas 4 personas cuantas
están por debajo, por encima o en peso ideal y
también calcularemos un porcentaje de cuantos son 
mayores de edad y cuantos menores. Para esto, podemos crear unos 
métodos adicionales */
package java_003;

import Entidad.Persona;
import Servicio.PersonaServicio;
import java.util.ArrayList;
import java.util.Scanner;

/* @author G96xyFast */
public class Java_003 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        PersonaServicio serv = new PersonaServicio();
        ArrayList<Persona> lista = new ArrayList();
        System.out.println("Ingrese cantidad de personas: ");
        int cant = leer.nextInt();
        while (cant <= 0) {
            System.out.println("Error. Ingrese cantidad de personas: ");
            cant = leer.nextInt();
        }
        
        int cont1=0, cont2=0, cont3=0;
        int mayor=0, menor=0;
        for (int i = 0; i < cant; i++) {
            System.out.println("Datos de la persona Nº" + (i + 1));
            Persona aux = serv.CrearPersona();
            switch (serv.CalcularIMC(aux)) {
                case -1:
                    System.out.println("Está por debajo de su peso ideal");
                    cont1++;
                    break;
                case 0:
                    System.out.println("Está en su peso ideal");
                    cont2++;
                    break;
                case 1:
                    System.out.println("Está por encima de su peso ideal");
                    cont3++;
                    break;
            }
            switch (serv.EsMayor(aux)) {
                case 1:
                    System.out.println("Sí es mayor de edad");
                    mayor++;
                    break;
                case 0:
                    System.out.println("No es mayor de edad");
                    menor++;
            }
            lista.add(aux);
        }
        System.out.println("Porcentaj peso bajo: " + (cont1*100)/cant);
        System.out.println("Porcentaj peso ideal: " + (cont2*100)/cant);
        System.out.println("Porcentaj peso alto: " + (cont3*100)/cant);
        System.out.println("\nPorcentaje mayores de edad: " + (mayor*100)/cant);
        System.out.println("Porcentaje menores de edad: " + (menor*100)/cant);
    }
}
