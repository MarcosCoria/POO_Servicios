/* Ejercicio_02: Programa Nespresso. Desarrolle una clase Cafetera en el paquete
Entidades con los atributos capacidadMáxima (la cantidad máxima de
café que puede contener la cafetera) y cantidadActual (la cantidad
actual de café que hay en la cafetera). Agregar constructor vacío y con
parámetros así como setters y getters. Crear clase CafeteraServicio en
el paquete Servicios con los siguiente:
a) Método llenarCafetera(): hace que la cantidad actual sea igual a la
capacidad máxima.
b) Método servirTaza(int): se pide el tamaño de una taza vacía, el
método recibe el tamaño de la taza y simula la acción de servir la
taza con la capacidad indicada. Si la cantidad actual de café “no
alcanza” para llenar la taza, se sirve lo que quede. El método le
informará al usuario si se llenó o no la taza, y de no haberse llenado
en cuanto quedó la taza.
c) Método vaciarCafetera(): pone la cantidad de café actual en cero.
d) Método agregarCafe(int): se le pide al usuario una cantidad de café,
el método lo recibe y se añade a la cafetera la cantidad de café
indicada */
package Servicio;

import Entidad.Cafetera;
import java.util.Scanner;

/* @author G96xyFast */
public class CafeteraServicio {

    public Cafetera LlenarCafetera() {
        Cafetera cafetera = new Cafetera();
        cafetera.setCapAct(cafetera.getCapMax());
        System.out.println("Cafetera llena. Capacidad actual: " + cafetera.getCapAct());
        return cafetera;
    }

    public void Menu(Cafetera aux) {
        Scanner leer = new Scanner(System.in);
        boolean var = false;
        while (var == false) {
            System.out.println("MENÚ\n1-Llenar Cafetera\n2-Servir tazas\n3-Vaciar cafetera\n4-Agregar café\n5-Salir");
            int opt = leer.nextInt();
            switch (opt) {
                case 1:
                    aux = LlenarCafetera();
                    break;
                case 2:
                    aux = ServirTazas(aux);
                    break;
                case 3:
                    aux = VaciarCafetera(aux);
                    break;
                case 4:
                    aux = AgregarCafe(aux);
                    break;
                case 5:
                    System.out.println("Finalizando. Gracias por usar el programa");
                    var = true;
                    break;
                default:
                    System.out.println("Error. Ingrese una opción válida. ");;
            }
        }
    }

    public Cafetera ServirTazas(Cafetera cafetera) {
        Scanner leer = new Scanner(System.in);
        if (cafetera.getCapAct() <= 0) {
            System.out.println("No hay más café. Debe llenar la cafetera");
        } else {
            System.out.println("Inserte capacidad de la taza: ");
            double taza = leer.nextDouble();
            while (taza <= 0) {
                System.out.println("Error. Inserte capacidad de la taza: ");
                taza = leer.nextDouble();
            }
            if (taza > cafetera.getCapAct()) {
                taza = cafetera.getCapAct();
                cafetera.setCapAct(0);
                System.out.println("Cafetera vacía, capacidad actual de la taza: " + taza);
            } else {
                cafetera.setCapAct(cafetera.getCapAct() - taza);
                System.out.println("Cafetera: " + cafetera.getCapAct() + ", taza llena: " + taza);
            }
        }
        return cafetera;
    }

    public Cafetera VaciarCafetera(Cafetera cafetera) {
        cafetera.setCapAct(0);
        System.out.println("Capacidad actual de la cafetera: " + cafetera.getCapAct());
        return cafetera;
    }

    public Cafetera AgregarCafe(Cafetera cafetera) {
        Scanner leer = new Scanner(System.in);
        if (cafetera.getCapAct() == cafetera.getCapMax()) {
            System.out.println("Cafetera llena. No es posible agregar más café. ");
        } else {
            System.out.println("Ingrese una cantidad de café: ");
            double cafe = leer.nextDouble();
            while (cafe <= 0) {
                System.out.println("Error. Ingrese una cantidad de café: ");
                cafe = leer.nextDouble();
            }
            if (cafetera.getCapAct() + cafe > cafetera.getCapMax()) {
                cafe = cafe - (cafetera.getCapMax() - cafetera.getCapAct());
                cafetera.setCapAct(cafetera.getCapMax()); // Llenamos la cafetera  
                System.out.println("Cafetera llena: " + cafetera.getCapAct() + ", sobrante de café: " + cafe);
            } else {
                cafetera.setCapAct(cafetera.getCapAct() + cafe);
                System.out.println("Capacidad actual de la cafetera: " + cafetera.getCapAct());
            }
        }
        return cafetera;
    }
}
