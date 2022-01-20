package daw.Lorena;

import java.time.YearMonth;
import java.util.Scanner;
import java.time.*;

public class TarjetaCredito {
    String entidadEmisora, titular, numero;
    int pinSeguridad, limiteCredito;
    YearMonth fechaCaducidad;
    double saldo;
    boolean estado;

    public TarjetaCredito() {
        this.entidadEmisora = "Banco";
        this.titular = "titular";
        this.numero = "0000 0000 0000 0000";
        this.pinSeguridad = 0000;
        this.limiteCredito = 3000;
        this.fechaCaducidad = YearMonth.of(2020, Month.MARCH);
        this.estado = false;
        this.saldo = 20;
    }


    public TarjetaCredito(String entidadEmisora, String titular, String numero, int pinSeguridad,
                          int limiteCredito, YearMonth fechaCaducidad, boolean estado, double saldo) {
        this.entidadEmisora = entidadEmisora;
        this.titular = titular;
        this.numero = numero;
        this.pinSeguridad = pinSeguridad;
        this.limiteCredito = limiteCredito;
        this.fechaCaducidad = fechaCaducidad;
        this.estado = false;
        this.saldo = saldo;

    }

    public static boolean Activar(TarjetaCredito tarjeta) {
        boolean estado;
        estado = tarjeta.isEstado();
        estado = true;
        return estado;
    }

    public static boolean Anular(TarjetaCredito tarjeta) {
        boolean estado;
        estado = tarjeta.isEstado();
        estado = false;
        return estado;
    }

    public static double Pagar(TarjetaCredito tarjeta) {
        Scanner sc = new Scanner(System.in);
        YearMonth actual = YearMonth.from(LocalDate.now());
        double balance = 0;
        System.out.println("Introduce PIN de seguridad");
        int pin = sc.nextInt();
        System.out.println("Introduce la cantidad a pagar");
        double pago = sc.nextDouble();
        if (tarjeta.isEstado() == true && tarjeta.getSaldo() > pago &&
                (tarjeta.getFechaCaducidad()).isBefore(actual) && tarjeta.getPinSeguridad() == pin) {
            balance = tarjeta.getSaldo() - pago;
        } else {
            System.out.println("operacion no válida");//InputMismasEx En caso contrario, se muestra un mensaje indicando el porqué no
            // ha sido posible realizar la operación.
        }
        return balance;
    }

    public static TarjetaCredito copiar(TarjetaCredito tarjeta){
        TarjetaCredito tarjetaCopia;
        tarjetaCopia = tarjeta;
        return tarjetaCopia;
    }

    public static boolean sonNumeros(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false; //Error no es numerico
        }
        return true; //Es numerico
    }

    private static String comprobar16(String num){
        final int CARACTERES_LIMITE = 16;
        if (num.length() > CARACTERES_LIMITE){
            System.out.println("error: supera la cantidad de dígitos");
        }
        return num;
    }

    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    public void setEntidadEmisora(String entidadEmisora) {
        this.entidadEmisora = entidadEmisora;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }
    //
    public void setNumero(String numero) {
        sonNumeros(comprobar16(numero));
        this.numero = numero;
    }

    public int getPinSeguridad() {
        return pinSeguridad;
    }

    public void setPinSeguridad(int pinSeguridad) {
        this.pinSeguridad = pinSeguridad;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        if (limiteCredito > 3000 || limiteCredito < 500) {
            this.limiteCredito = 500;
        } else {
            this.limiteCredito = limiteCredito;
        }
    }

    public YearMonth getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(YearMonth fechaCaducidad) {
        YearMonth actual = YearMonth.from(LocalDate.now());
        if (fechaCaducidad.isBefore(actual)) {
            fechaCaducidad = actual;
        }
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return
                "   " + titular + "    " + entidadEmisora + "  " + fechaCaducidad + "   " + limiteCredito +
                        "   " + numero
                ;
    }
}
