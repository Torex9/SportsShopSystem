///*
//Author: RUFUS OLUDARE C2676906
//Author: MD SARWAR AHMED W9608149
//
//*/
//package oop.ica.e1;
//
///*This code imports the necessary classes from the Java Standard Library 
//for working with ArrayLists and reading user input from the console.*/
//import java.util.ArrayList;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class SportsShopSystem {
//    
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        //menu();
//        Scanner sc = new Scanner(System.in);
//        ArrayList<ShopData> storedData = new ArrayList<>();
//        ShopAction shopAction = new ShopAction();
//        boolean terminate = false;
//        int selection;
//        //try to load the data csv file
//        try{
//             storedData = shopAction.loadData();
//              
//            }catch(FileNotFoundException e) {
//                System.out.println("\n\n!!!!!Unable to open file!!!!!" + e.getMessage() + "\n");
//                System.exit(0);
//            }catch(IOException e) {
//                System.out.print("\n\n!!!!! file read error!!!!!\n " + e.getMessage() + "\n");
//                System.exit(0);
//            }
//        
//        //printing out the menu header
//        System.out.println("ASHER SPORT CONSORTIUM \n");
//        
//        
//        
//        try {
//            do {
//                
//                shopAction.menu();
//                
//                selection = sc.nextInt();
//        
//        
//                switch (selection) {
//                    case 0:
//                        quit();
//                        terminate = true;
//                        shopAction.savedData(storedData);
//                        break;       
//    
//                    case 1:
//                        viewItems();
//                        shopAction.displayItems(storedData, "view");
//                        break;
//                    case 2:
//                        buyItems();
//                        shopAction.displayItems(storedData, "buy");
//                        
//                        System.out.println("\nSelect the item you want to buy, or 0 to return to main menu");
//                        selection = sc.nextInt();
//                        
//                        if (selection != 0) {
//                            int index = selection - 1;
//                            if(storedData.get(index).getStockQuantity() > 0) {
//                                shopAction.modifyStock(storedData, "buy", index);
//                            } else 
//                                if( storedData.get(index).getStockQuantity() == 0) {
//                                System.out.println(storedData.get(index).getProductTitle() + " is out of stock");   
//                            }
//                        }
//                        break;
//                        
//                        case 3:
//                            addStock();
//                            System.out.println("Stock Items");
//                            shopAction.displayItems(storedData, "add");
//                            
//                            System.out.println("\nSelect item to add, or 0 to return to main menu");
//                            selection = sc.nextInt();
//                            
//                            if(selection != 0) {
//                                int index = selection - 1;
//                                shopAction.modifyStock(storedData, "add", index);
//                            }
//                            break;
//                            
//                        default:
//                            System.out.println("!!!!! please select a Valid menu option to continue !!!!! \n" );
//                }
//            } 
//            
//            
//            while(terminate != true );
//        }
//        catch(InputMismatchException | IndexOutOfBoundsException ex) {
//            System.out.println("!!!!! Please select a Valid menu option to continue !!!!!");
//            //menu();    
//        }
//    }
//    
//    
//    /*methods for to print view items, buyItems, addStock, */
//    public static void viewItems(){
//            System.out.println("1 \n");
//            System.out.println("View Items \n");
//    }
//    
//    public static void buyItems(){
//            System.out.println("2 \n");
//            System.out.println("Buy Items \n");
//    }
//    
//    public static void addStock(){
//            System.out.println("3 \n");
//            System.out.println("Add Stock \n");
//    }
//    
//    public static void quit(){                 
//            System.out.println("***** Thank you for your visit ***** \n" );
//    }
//    
//    
//}
//
//
