/*
Author: RUFUS OLUDARE C2676906
Author: MD SARWAR AHMED W9608149

*/
package oop.ica.e1;

import java.util.Scanner;

public class SportsShopSystem {
    public static void menu() {
        Scanner sc = new Scanner(System.in); 

        int selection;
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
                selection = sc.nextInt();
        
        
                switch (selection) {
                    case 0:
                        quit(selection);
                        break;       
    
                    case 1:
                        viewItems(selection);
                        break;
                    case 2:
                        buyItems(selection);
                        break;
                    case 3:
                        addStock(selection);
                        break;
                    default:
                        System.out.println("!!!!! please select a menu option to continue !!!!! \n" );
                }
            } 
            
            
            while(selection != 0 );
        }
        catch(Exception ex) {
            System.out.println("!!!!! Please select a Valid menu option to continue !!!!!");
            menu();    
        }
    }

    public static void viewItems( int selectionIn ){
            System.out.println("1 \n");
            System.out.println("View Items \n");
    }
    
    public static void buyItems( int selectionIn ){
            System.out.println("2 \n");
            System.out.println("Buy Items \n");
    }
    
    public static void addStock( int selectionIn ){
            System.out.println("3 \n");
            System.out.println("Add Stock \n");
    }
    
    public static void quit( int selectionIn ){
            System.out.println("0 \n");
            System.out.println("***** Thank you for your visit ***** \n" );
    }
    
    
    public static void main(String[] args) {
        menu();
    }
    
}
