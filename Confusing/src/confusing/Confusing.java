/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusing;

/**
 *
 * @author user
 */
public class Confusing {

   

    public static void method1() {
        System.out.println("I am method 1.");
    }
    public static void method2(){
        method1();
        System.out.println("I am method 2.");
    }
    public static void method3(){
        method2();
        System.out.println("I am Groot.");
        method1();
    }
    public static void main(String[] args){
        method1();
        method3();
        method2();
        method3();
        
    }


}

    
