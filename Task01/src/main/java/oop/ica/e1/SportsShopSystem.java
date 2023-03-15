/*
Author: RUFUS OLUDARE C2676906
Author: MD SARWAR AHMED W9608149

*/
package oop.ica.e1;

import java.util.Scanner;

public class SportsShopSystem {
    public static void menu() {
        Scanner sc = new Scanner(System.in); 

        int test;
        try {
            do {

                System.out.println("ASHER SPORT CONSORTIUM \n");
                System.out.println("MAIN MENU: Please select a menu option to continue" );
                System.out.println( "\t[1] View Items ");
                System.out.println( "\t[2] Buy Items ");
                System.out.println( "\t[3] Add Stock ");
                System.out.println( "\t[0] Quit \n");
        
                System.out.println("Please enter a number: ");
        
                sc = new Scanner(System.in);
                test = sc.nextInt();
        
        
                switch (test) {
                    case 0:
                        quit(test);
                        break;       
    
                    case 1:
                        viewItems(test);
                        break;
                    case 2:
                        buyItems(test);
                        break;
                    case 3:
                        addStock(test);
                        break;
                    default:
                        System.out.println("!!!!! please select a menu option to continue !!!!! \n" );
                }
            } 
            
            
            while(test != 0 );
        }
        catch(Exception ex) {
            System.out.println("!!!!! Please select a Valid menu option to continue !!!!!");
            menu();    
        }
    }

    public static void viewItems( int testIn ){
            System.out.println("1 \n");
            System.out.println("View Items \n");
    }
    
    public static void buyItems( int testIn ){
            System.out.println("2 \n");
            System.out.println("Buy Items \n");
    }
    
    public static void addStock( int testIn ){
            System.out.println("3 \n");
            System.out.println("Add Stock \n");
    }
    
    public static void quit( int testIn ){
            System.out.println("0 \n");
            System.out.println("***** Thank you for your visit ***** \n" );
    }
    
    
    public static void main(String[] args) {
        menu();
    }
    
}
