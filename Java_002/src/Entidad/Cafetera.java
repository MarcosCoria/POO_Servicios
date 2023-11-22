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
package Entidad;

/* @author G96xyFast */
public class Cafetera {
    private double capMax= 100;
    private double capAct;

    public Cafetera() {
    }

    public Cafetera(double capMax, double capAct) {
        this.capMax = capMax;
        this.capAct = capAct;
    }

    public double getCapMax() {
        return capMax;
    }

    public void setCapMax(double capMax) {
        this.capMax = capMax;
    }

    public double getCapAct() {
        return capAct;
    }

    public void setCapAct(double capAct) {
        this.capAct = capAct;
    }

    @Override
    public String toString() {
        return "Cafetera{" + "capMax=" + capMax + ", capAct=" + capAct + '}';
    }
    
}
