/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaprioridad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Acer
 */
public class MaxPQ <Key extends Comparable<Key>>implements Iterable<Key>{
 private Key[] fa;
   
    private int actual;
    
    public MaxPQ(int max) {
         
         fa = (Key[]) new Comparable[max+1];
        actual = 0;
    }
    public MaxPQ(Key[] a){
    actual=a.length;
    fa = (Key[]) new Object[a.length+1];
        for (int i = actual; i < 10; i++) {
            fa[i+1]=a[i];
        }
        for (int j = a.length/2; j>=1; j--) {
            sink(j);
        }
    
    }
//adicionar    
public void adicionar(Key a){
fa[++actual]=a;
    swim(actual);

}
    public Key maximo(){
    
    return fa[1];
    }
    
    public Key quitarMax(){
    Key maximo =maximo();
        exch(1, actual--);
       
        fa[actual+1]=null;
        sink(1);
       return maximo;
    }
    public boolean isEmpty(){
    return actual==0;
    }
    
    public void swim(int a){
         while (a>1 && comp(a/2, a)) {
             exch(a/2, a);
             a=a/2;
        }
 
    }
    //comparar 
    public boolean comp(int a, int b ){
    return fa[a].compareTo(fa[b])<0;
    }
    
   
   public void exch (int i, int j){
 
    Key t=fa[i];
    fa[i]=fa[j];
    fa[j]=t;
           
    }
    
    //ver que tan lara esta la cola
    public int size() {
        return actual;
    }
    private void sink(int a ){
        while (2*a<=actual) {
           int j=2*a;
           if(j<actual&&comp(j, j+1))j++;
           if(!comp(a, j))break;
            exch(a, j);
            a=j;
            
        }
    }
   
    
    
    @Override
    public Iterator<Key> iterator() {
      return new ArrayIterator<Key> ();  
    }
    
    
 private class ArrayIterator<Key> implements Iterator<Key> {

          private int posicion=0;

             @Override
             public boolean hasNext() {
                return actual < fa.length;
             }

             @Override
             public Key next() {
                if (posicion < fa.length) {
                Key t = (Key) fa[posicion];
                posicion++;
                return t;
            } else {
                System.out.println("No existen mas elementos");
                return null; 
              
             }
         };    
    }

 }
   


