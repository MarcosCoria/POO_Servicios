/* Ejercicio_01: Vamos a realizar una clase llamada Raices, donde representaremos los
valores de una ecuación de 2º grado. Tendremos los 3 coeficientes
como atributos, llamémosles a, b y c. Hay que insertar estos 3 valores
para construir el objeto a través de un método constructor. Luego, en
RaicesServicio las operaciones que se podrán realizar.
Nota: Fórmula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo varía
el signo delante de -b */
package Servicios;

import Entidad.Raices;
import java.util.Scanner;

/* @author G96xyFast */
public class RaicesServicios {
    public void PedirDatos(){
        Scanner leer = new Scanner(System.in);
        Raices raiz= new Raices();
        System.out.println("Ingrese valor de 'a': ");
        raiz.setA(leer.nextInt());
        System.out.println("Ingrese valor de 'b': ");
        raiz.setB(leer.nextInt());
        System.out.println("Ingrese valor de 'c': ");
        raiz.setC(leer.nextInt());
        Calcular(raiz);
    }
    /*  a) Método getDiscriminante(): devuelve el valor del discriminante
    (double). El discriminante tiene la siguiente fórmula: (b^2)-4*a*c  */
    public double GetDiscriminante(Raices raiz){
        double aux= Math.pow(raiz.getB(), 2)- 4*raiz.getA()* raiz.getC();
        return aux;
    }
    /* b) Método tieneRaices(): devuelve un booleano indicando si tiene dos
    soluciones, para que esto ocurra, el discriminante debe ser mayor o igual que 0. */
    public boolean TieneRaices(double aux){
        boolean var= false;
        if (aux>0) {
            var= true;
        }
        return var;
    }
    /* c) Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, 
    para que esto ocurra, el discriminante debe ser igual que 0. */
    public boolean TieneRaiz(double aux){
        boolean var= false;
        if (aux==0) {
            var= true;
        }
        return var;
    }
    /* d) Método obtenerRaices(): imprime las 2 posibles soluciones. */
    public void ObtenerRaices(Raices raiz){
        double denominador= (2*raiz.getA());
        double aux= Math.sqrt(GetDiscriminante(raiz));
        double sol1= ( -raiz.getB() + aux ) / denominador ;
        double sol2= ( -raiz.getB() - aux ) / denominador ;
        System.out.println("Tiene 2 soluciones");
        System.out.println("Raíz 1: "+ sol1 + ", Raíz 2: " + sol2);
    }
    /* e) Método obtenerRaiz(): imprime si tine una única solución posible. */
    public void ObtenerRaiz(Raices raiz){
        double denominador= (2*raiz.getA());
        double aux= Math.sqrt(GetDiscriminante(raiz));
        double sol1= ( -raiz.getB() + aux) / denominador;
        System.out.println("Tiene 1 solución");
        System.out.println("Raíz 1: "+ sol1);
    }
    /* f) Método calcular(): este método llamará tieneRaices() y a tieneRaíz(),
    y mostrará por pantalla las posibles soluciones que tiene nuestra
    ecuación con los métodos obtenerRaices() o obtenerRaiz(), según lo
    que devuelvan nuestros métodos y en caso de no existir solución, se mostrará un mensaje.
    Nota: Fórmula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo varía
    el signo delante de -b */
    public void Calcular(Raices raiz){
        if (TieneRaices(GetDiscriminante(raiz))==true) {
            ObtenerRaices(raiz);
        } else if (TieneRaiz(GetDiscriminante(raiz))==true) {
            ObtenerRaiz(raiz);
        } else {
            System.out.println("No tiene solución");
        }
    }
}