/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaprioridad;

/**
 *
 * @author Acer
 */
public class ColaPrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MaxPQ<Integer> cola=new MaxPQ<>(3);
       //adicionamos elementos a la cola
       cola.adicionar(2);
        cola.adicionar(5);
         cola.adicionar(3);
      
        System.out.println("el elemento maximo es "+cola.maximo());
      
        while (!cola.isEmpty()) {
            System.out.print("  "+cola.quitarMax());

        }
        
        }

               
}


