package com.treinamento.Mock.treinamentoMock;

public class Calculadora {
   private int x ;
   private int y;

    public int somar(){
        return this.x + this.y;
    }

    public int subtrair(){
        return this.x - this.y;
    }

    public double multiplicar(){
        return this.x * this.y;
    }

    public double dividir(){
        return this.x / this.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        c.setX(5);
        c.setY(4);

        System.out.println(c.dividir());
    }
}
