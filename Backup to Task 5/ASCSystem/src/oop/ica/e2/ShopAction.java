/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.e2;


import java.io.FileNotFoundException;
import java.io.IOException;
import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author IFEOLUWA
 */
public class ShopAction {
    String productCode;
    String productTitle;
    String productDescription;
    int pricePence;
    int stockQuantity;
    int pricePounds;
   
    private static final String DELIMITER = ",";
    private static ArrayList<ASCStockItem> storedData = new ArrayList<>();
    
    public static ArrayList loadData() throws IOException, FileNotFoundException   {
        final String INPUT_FILE_PATH = "AsherSportsConsortium.csv";
        File inputFile = new File(INPUT_FILE_PATH);
        Scanner fileScanner;
        ArrayList initData = new ArrayList();
        
        if ( inputFile.exists() && inputFile.isFile() ) {
            //set scanner to be file object
            fileScanner = new Scanner(inputFile);
            
            while (fileScanner.hasNextLine()) {
                //read and trim line
                String Line = fileScanner.nextLine().trim();
                //chech line has cotent
                if (!Line.isEmpty()) {
                    String stockCode = Line.split(DELIMITER)[0];
                    String Title = Line.split(DELIMITER)[1];
                    String Description = Line.split(DELIMITER)[2];
                    int StockPrice = Integer.parseInt(Line.split(DELIMITER)[3]);
                    int StockPricePence = Integer.parseInt(Line.split(DELIMITER)[4]);
                    int Quantity = Integer.parseInt(Line.split(DELIMITER)[5]);
                    //add data to the arraylist
                    initData.add(new ASCStockItem(stockCode, Title, Description, StockPrice,StockPricePence, Quantity ));
                }
            }
            //close file stream by closing scanner
            fileScanner.close();
        }
        else {
            System.out.println("\n !!!!! ERROR: '" + inputFile.getName() + "' does not exist as a data file. !!!!! \n");
            System.exit(0);
        }
        
        return initData;
            
            
            
        
//        if(storedData.isEmpty()) {
//            storedData.add(new SportsShopSystem("RUN1234567", "RunTech Shorts", "High quality running shorts", 10, 0, 10));
//            storedData.add(new SportsShopSystem("CYC1111111", "Cycle4ever Cycling Jacket", "Ultra lightweight jacket for te urban cyclist", 50, 0, 20));
//            storedData.add(new SportsShopSystem("SWM2222222", "7oceans Googles", "Super HiTech googles for the extreme swimmer", 24, 99, 8));
//        }
        
        
    }
    
    
    
    /*The method is used to display the items in the sports shop
    system either in a detailed view or a summary view, depending
    on the value of the action parameter.*/
    public static ArrayList displayItems(ArrayList<ASCStockItem> storedData, String action) {
        if (action.equals("view")){
            System.out.println("Stock Code" + "\t" + String.format("%-30s", "Title") + "\t"
                + String.format("%-100s", "Description") + "\t" + "Price" + "\t" + "Quantity" );
            for (int a = 0; a < storedData.size(); a++) {
                ASCStockItem dataOut = storedData.get(a);
                Double stockPrice = Double.valueOf(dataOut.getPricePounds() + "." + dataOut.getPricePence());
                String PriceFormatted = String.format("%,.2f", stockPrice);
                System.out.println(storedData.get(a).getProductCode() + "\t" + String.format("%-30s",dataOut.getProductTitle()) + "\t"
                        + String.format("%-100s", dataOut.getProductDescription()) + "\t" + "£" + PriceFormatted + "\t" + dataOut.getStockQuantity());
            }
            
        } else {
            System.out.println("ID" + "\t" + String.format("%-30s", "Item") + "\t" + "Price" + "\t" + "Quantity");
            for(int a = 0; a < storedData.size(); a++) {
                int b = 1 + a;
                ASCStockItem dataOut = storedData.get(a);
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
    public static ArrayList modifyStock (ArrayList<ASCStockItem> storedData, String action, int index) {
        if (action.equals("buy")) {
            if(storedData.get(index).getStockQuantity() > 0) {
                int newQuantity = storedData.get(index).getStockQuantity() - 1;
                storedData.set(index, new ASCStockItem(storedData.get(index).getProductCode(),storedData.get(index).getProductTitle(),
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
            storedData.set(index, new ASCStockItem(storedData.get(index).getProductCode(), storedData.get(index).getProductTitle(),
            storedData.get(index).getProductDescription(), storedData.get(index).getPricePounds(), storedData.get(index).getPricePence(), newQuantity ));
            
            System.out.println("New Quantity of " + storedData.get(index).getProductTitle() + " is: " + 
                    storedData.get(index).getStockQuantity());
        }
        
        return storedData;
    }
    
    
//public void saveData(ArrayList<ShopData> storeData) {
//   try{
//       Writer WriteData = new OutputStreamWriter()
//   }catch(IOException e){
//       
//   }
//}
    
    
    
    public  void savedData( ArrayList<ASCStockItem> storedData) throws IOException, FileNotFoundException {
        final String OUTPUT_FILE_PATH = "asc_Output.txt";
        Path path = Paths.get(OUTPUT_FILE_PATH);
        Files.deleteIfExists(path);
        
        BufferedOutputStream buffer = new BufferedOutputStream(
        Files.newOutputStream(path, CREATE, WRITE)
        );
        
        //output string
        String report ="";
        
        //loop through arraylist
        for (int index = 0; index < storedData.size(); index++) {
            //add field of current stored data to string, followed by the delimiter
            report += storedData.get(index).getProductCode() + DELIMITER;
            report += storedData.get(index).getProductTitle() + DELIMITER;
            report += storedData.get(index).getProductDescription() + DELIMITER;
            report += storedData.get(index).getPricePounds() + DELIMITER;
            report += storedData.get(index).getPricePence() + DELIMITER;
            report += storedData.get(index).getStockQuantity() + "\r\n";
        } //end of loop
        //transform output sring to byte array
        byte  data[] = report.getBytes();
        
        //write byte array to the stream
        buffer.write(data, 0, data.length);
        
       //close buffer so stream writes to file
       buffer.close();
       
       //confirm data written
       System.out.println("\n\nData written to file at:" + path.toAbsolutePath().toString());
        
        
    }
    
    
    public void menu() {
        System.out.println("MAIN MENU: Please select a menu option to continue" );
                System.out.println( "\t[1] View Items ");
                System.out.println( "\t[2] Buy Items ");
                System.out.println( "\t[3] Add Stock ");
                System.out.println( "\t[0] Quit \n");
        
                System.out.println("Please enter a number: ");
        
    }
}
