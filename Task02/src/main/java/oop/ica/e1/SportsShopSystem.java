/*
Author: RUFUS OLUDARE C2676906
Author: MD SARWAR AHMED W9608149

*/
package oop.ica.e1;

/*This code imports the necessary classes from the Java Standard Library 
for working with ArrayLists and reading user input from the console.*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SportsShopSystem {
    //This line of code creates a new ArrayList object named "storedData" that can hold elements of the SportsShopSystem type
    ArrayList<SportsShopSystem> storedData = new ArrayList<>();
    
    
    String productCode;
    String productTitle;
    String productDescription;
    int pricePence;
    int stockQuantity;
    int pricePounds;
    
    /*This methods are declared as public, meaning that
    it can be accessed from other classes and methods.*/
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    public int getPricePounds(){
        return pricePounds;
    }
    
    public int getPricePence(){
        return pricePence;
    }
    
    public String getProductCode(){
        return productCode;
    }
    
    public String getProductTitle(){
        return productTitle;
    }
    
    public String getProductDescription(){
        return productDescription;
    }
    
    /*this constructor provides a way to create new SportsShopSystem objects 
    with specific attributes and initial values, which can be stored in the
    storedData ArrayList.*/
    public SportsShopSystem(String productCode, String productTitle, String productDescription, int pricePounds, int pricePence, int stockQuantity){
        this.productCode = productCode;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.pricePounds = pricePounds;
        this.pricePence = pricePence;
        this.stockQuantity = stockQuantity;
    }
    
    public SportsShopSystem() {
        
    }
    
    public static void menu() {
        Scanner sc = new Scanner(System.in); 
        SportsShopSystem sportsShopSystem = new SportsShopSystem();
        boolean terminate = false;
        
        ArrayList<SportsShopSystem> storedData =  sportsShopSystem.loadData();
        
        
        System.out.println("ASHER SPORT CONSORTIUM \n");
        int selection;
        
        
        try {
            do {


                System.out.println("MAIN MENU: Please select a menu option to continue" );
                System.out.println( "\t[1] View Items ");
                System.out.println( "\t[2] Buy Items ");
                System.out.println( "\t[3] Add Stock ");
                System.out.println( "\t[0] Quit \n");
        
                System.out.println("Please enter a number: ");
        
                
                selection = sc.nextInt();
        
        
                switch (selection) {
                    case 0:
                        quit(selection);
                        terminate = true;
                        break;       
    
                    case 1:
                        viewItems(selection);
                        sportsShopSystem.displayItems(storedData, "view");
                        break;
                    case 2:
                        buyItems(selection);
                        sportsShopSystem.displayItems(storedData, "buy");
                        
                        System.out.println("\nSelect the item you want to buy, or 0 to return to main menu");
                        selection = sc.nextInt();
                        
                        if (selection != 0) {
                            int index = selection - 1;
                            if(storedData.get(index).getStockQuantity() > 0) {
                                sportsShopSystem.modifyStock(storedData, "buy", index);
                            } else
                                if( selection == 0) {
                                System.out.println(storedData.get(index).getProductTitle() + " is out of stock");
                                
                            }
                        }
                        break;
                        
                        case 3:
                            addStock(selection);
                            System.out.println("Stock Items");
                            sportsShopSystem.displayItems(storedData, "add");
                            
                            System.out.println("\nSelect item to add, or 0 to return to main menu");
                            selection = sc.nextInt();
                            
                            if(selection != 0) {
                                int index = selection - 1;
                                sportsShopSystem.modifyStock(storedData, "add", index);
                            }
                            break;
                            
                        default:
                            System.out.println("!!!!! please select a Valid menu option to continue !!!!! \n" );
                }
            } 
            
            
            while(terminate != true );
        }
        catch(InputMismatchException | IndexOutOfBoundsException ex) {
            System.out.println("!!!!! Please select a Valid menu option to continue !!!!!");
            menu();    
        }
    }
    
    
    /*methods for to print view items, buyItems, addStock, */
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
    
    /*This code defines a private method named loadData that returns
    an ArrayList of SportsShopSystem objects. The method is used to load
    sample data into the storedData ArrayList if it is empty.*/
    private ArrayList loadData() {
        if(storedData.isEmpty()) {
            storedData.add(new SportsShopSystem("RUN1234567", "RunTech Shorts", "High quality running shorts", 10, 0, 10));
            storedData.add(new SportsShopSystem("CYC1111111", "Cycle4ever Cycling Jacket", "Ultra lightweight jacket for te urban cyclist", 50, 0, 20));
            storedData.add(new SportsShopSystem("SWM2222222", "7oceans Googles", "Super HiTech googles for the extreme swimmer", 24, 99, 8));
        }
        
        return storedData;
    }
    
    /*The method is used to display the items in the sports shop
    system either in a detailed view or a summary view, depending
    on the value of the action parameter.*/
    private ArrayList displayItems(ArrayList<SportsShopSystem> storedData, String action) {
        if (action.equals("view")){
            System.out.println("Stock Code" + "\t" + String.format("%-30s", "Title") + "\t"
                + String.format("%-80s", "Description") + "\t" + "Price" + "\t" + "Quantity" );
            for (int a = 0; a < storedData.size(); a++) {
                SportsShopSystem dataOut = storedData.get(a);
                Double stockPrice = Double.valueOf(dataOut.getPricePounds() + "." + dataOut.getPricePence());
                String PriceFormatted = String.format("%,.2f", stockPrice);
                System.out.println(storedData.get(a).getProductCode() + "\t" + String.format("%-30s",dataOut.getProductTitle()) + "\t"
                        + String.format("%-80s", dataOut.getProductDescription()) + "\t" + "£" + PriceFormatted + "\t" + dataOut.getStockQuantity());
            }
            
        } else {
            System.out.println("ID" + "\t" + String.format("%-30s", "Item") + "\t" + "Price" + "\t" + "Quantity");
            for(int a = 0; a < storedData.size(); a++) {
                int b = 1 + a;
                SportsShopSystem dataOut = storedData.get(a);
                Double stockPrice = Double.valueOf(dataOut.getPricePounds() + "." + dataOut.getPricePence());
                String PriceFormatted = String.format("%,.2f", stockPrice);
                System.out.println(b + "\t" + String.format("%-30s", dataOut.getProductTitle()) + "\t£" 
                        + PriceFormatted + "\t" + dataOut.getStockQuantity());
            }
        }
        System.out.println("");
        return storedData;
    }
    
    /*The modifyStock method is used to modify the quantity of
    items in the inventory based on the specified action
    ("buy" or "add") and the index of the item to modify.*/
    private ArrayList modifyStock (ArrayList<SportsShopSystem> storedData, String action, int index) {
        if (action.equals("buy")) {
            if(storedData.get(index).getStockQuantity() > 0) {
                int newQuantity = storedData.get(index).getStockQuantity() - 1;
                storedData.set(index, new SportsShopSystem(storedData.get(index).getProductCode(),storedData.get(index).getProductTitle(),
                storedData.get(index).getProductDescription(), storedData.get(index).getPricePounds(),
                storedData.get(index).getPricePence(), newQuantity ));
                
                Double buyingPrice = Double.valueOf(storedData.get(index).getPricePounds() + "." + storedData.get(index).getPricePence());
                String PriceFormatted = String.format("£%,.2f", buyingPrice);
                System.out.println("Sale of " + storedData.get(index).getProductTitle() + " for " +
                PriceFormatted + " confirmed. Quantity remaining: " + storedData.get(index).getStockQuantity());
            }
        }
        
        if (action.equals("add")) {
            int newQuantity = storedData.get(index).getStockQuantity() + 1;
            storedData.set(index, new SportsShopSystem(storedData.get(index).getProductCode(), storedData.get(index).getProductTitle(),
            storedData.get(index).getProductDescription(), storedData.get(index).getPricePounds(), storedData.get(index).getPricePence(), newQuantity ));
            
            System.out.println("New Quantity of " + storedData.get(index).getProductTitle() + " is: " + 
                    storedData.get(index).getStockQuantity());
        }
        
        return storedData;
    }
}


