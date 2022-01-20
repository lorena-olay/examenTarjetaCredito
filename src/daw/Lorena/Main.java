package daw.Lorena;
/*
Crea una tarjeta con el constructor por defecto (t1) y otra con el constructor parametrizado (t2).
Crea una copia de t2 en t3.
Muestra los datos de los tres objetos usando la consola y toString.
Anula t2 e intenta pagar cualquier cantidad.
Activa t2 e intenta pagar una cantidad de dinero superior al límite.
Paga con t3 una cantidad de dinero inferior al límite.
Muestra por consola la información de t3.
*/
public class Main {
    public static void main(String[] args) {
        TarjetaCredito t1 = new TarjetaCredito();
        //TarjetaCredito t2 = new TarjetaCredito("Caixa", "Lorena Olay", "00000000000000001", 1111, 600, 2055,05, false, 75.5);

        System.out.println(t1);


    }
}
