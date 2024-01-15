package org.example.java_base.module_6;

import java.util.Objects;

/**
 *  6.1 - Реализуйте generic-класс Pair, похожий на Optional,
 *  но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
 *  Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
 *  а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
 * @param <F>
 * @param <S>
 */
public class Pair<F, S> {
    private Pair (F fval, S sval){
        this.fValue = fval;
        this.sValue = sval;
    }            
    private F fValue;
    private S sValue;
    
    public F getFirst(){
        return fValue;
    }
    public S getSecond(){
        return sValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!Objects.equals(this.fValue, other.fValue)) {
            return false;
        }
        if (!Objects.equals(this.sValue, other.sValue)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.fValue);
        hash = 43 * hash + Objects.hashCode(this.sValue);
        return hash;
    }
    
    public static <F, S> Pair<F, S> of(F fV, S sV){
        return new Pair<> (fV, sV);
       
        
    }

}
