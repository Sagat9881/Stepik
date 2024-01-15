package org.example.java_base// 3.5 - Напишите класс AsciiCharSequence,
// реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт.

public class AsciiCharSequence implements CharSequence{
  private byte [] sequence;
  public AsciiCharSequence (byte [] byteArray){
    sequence = byteArray;
  }
  public int length(){
    return sequence.length;
  }
  public char charAt (int index){
    return (char) sequence[index];
  }
  public AsciiCharSequence subSequence (int a, int b){
  int len = (b - a);
  byte [] newSequence = new byte[len];
  System.arraycopy (sequence, a, newSequence, 0, b-a);
  return new AsciiCharSequence(newSequence);
  }
  public String toString(){
  return  new String (sequence); 
  }
}
