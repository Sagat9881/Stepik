package org.example.java_base.module_3;

import java.util.Objects;

/**
 *  3.4 - Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так,
 *  чтобы equals() сравнивал экземпляры ComplexNumber по содержимому полей re и im,
 *  а hashCode() был бы согласованным с реализацией equals()
 */
public  class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof ComplexNumber)){
            return false;
        }
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0&&
        Double.compare(that.im,im) == 0;
    }
    public int hashCode(){
        return Objects.hash(im,re);
    }
}
