/* Ejercicio_01: Realizar una clase llamada CuentaBancaria en el paquete Entidades con
los siguientes atributos: numeroCuenta(entero), dniCliente(entero largo),
saldoActual. Agregar constructor vacío, con parámetros, getters y
setters.
Agregar la clase CuentaBancariaServicio en el paquete Servicios que
contenga:
a) Método para crear cuenta pidiéndole los datos al usuario.
b) Método ingresar(double): recibe una cantidad de dinero a ingresar y
se le sumará al saldo actual.
c) Método retirar(double): recibe una cantidad de dinero a retirar y se le
restara al saldo actual. Si la cuenta no tiene la cantidad de dinero a
retirar se retirará el máximo posible hasta dejar la cuenta en 0.
d) Método extraccionRapida: le permitirá sacar solo un 20% de su saldo.
Validar que el usuario no saque más del 20%.
e) Método consultarSaldo: permitirá consultar el saldo disponible en la
cuenta.
f) Método consultarDatos: permitirá mostrar todos los datos de la
cuenta */
package Servicio;

import Entidad.CuentaBancaria;
import java.util.Scanner;

/* @author G96xyFast */
public class CuentaBancariaServicio {
    public CuentaBancaria crearCuenta(){
        CuentaBancaria cuenta= new CuentaBancaria();
        System.out.println("Ingrese número de cuenta: ");
        cuenta.setNumCuenta(Comprobar());
        System.out.println("Ingrese número de DNI: ");
        cuenta.setDniCliente(Documento());
        System.out.println("Ingrese salario: ");
        cuenta.setSalario(Salario());
        
        return cuenta;
    }
    public void Menu(CuentaBancaria cuenta){
        Scanner leer = new Scanner(System.in);
        boolean var= false;
        while (var==false) {
            System.out.println("MENÚ:\n1-Ingresar\n2-Retirar\n3-Extracción rápida\n4-Consultar datos\n5-Salir");
            int opt= leer.nextInt();
            switch (opt) {
                case 1:
                    cuenta.setSalario(cuenta.getSalario()+ Ingresar());
                    break;
                case 2:
                    cuenta.setSalario(cuenta.getSalario()- Retirar(cuenta));
                    break;
                case 3:
                    cuenta.setSalario(cuenta.getSalario()- ExtraccionRapida(cuenta));
                    break;
                case 4:
                    ConsultarDatos(cuenta);
                    break;
                case 5:
                    System.out.println("Finalizando. Gracias por usar el programa");
                    var=true;
                    break;
                default:
                    System.out.println("Error. Ingrese un dato válido. ");;
            }
        }
    }
    
    public double Ingresar(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Cantidad a ingresar: ");
        return leer.nextDouble();
    }
    
    public double Retirar(CuentaBancaria aux){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese cantidad a retirar: ");
        double retiro= leer.nextDouble();
        if (retiro>aux.getSalario()) {
            System.out.println("Error. No se puede retirar fondos superiores al salario. ");
            return 0;
        } else {
            return retiro;
        }
    }
    
    public double ExtraccionRapida(CuentaBancaria aux){
        Scanner leer = new Scanner(System.in);
        System.out.println("Extracción rápida en proceso ");
        return aux.getSalario()*0.2;
    }
    
    public void ConsultarDatos(CuentaBancaria aux){
        System.out.println("Datos: " + aux.toString());
    }
    
    public int Comprobar(){
        Scanner leer = new Scanner(System.in);
        int aux= leer.nextInt();
        while (aux<=0) {
            System.out.println("Error. Ingrese un dato válido: ");
            aux= leer.nextInt();
        }
        return aux;
    }
    
    public long Documento(){
        Scanner leer = new Scanner(System.in);
        long aux= leer.nextLong();
        while (aux<=0 || aux>99999999) {
            System.out.println("Error. Ingrese un dato válido: ");
            aux= leer.nextInt();
        }
        return aux;
    }
    
    public double Salario(){
        Scanner leer = new Scanner(System.in);
        double aux= leer.nextDouble();
        while (aux<=0) {
            System.out.println("Error. Ingrese un dato válido: ");
            aux= leer.nextDouble();
        }
        return aux;
    }
}
