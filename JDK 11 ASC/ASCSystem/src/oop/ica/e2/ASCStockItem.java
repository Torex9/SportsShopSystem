/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.e2;

/**
 *
 * @author IFEOLUWA
 */
public class ASCStockItem {
    String photoFilename;
    String productCode;
    String productTitle;
    String productDescription;
    int pricePence;
    int stockQuantity;
    int pricePounds;
    String price;
    
    /*This methods are declared as public, meaning that
    it can be accessed from other classes and methods.*/
    public String getPhotoFilename(){
        return photoFilename;
    }
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
    public void setPhotoFilename(String photoFilename) {
        this.photoFilename = photoFilename;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPricePounds(int pricePounds) {
        this.pricePounds = pricePounds;
    }

    public void setPricePence(int pricePence) {
        this.pricePence = pricePence;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public String getPrice() {
        Double formattedPrice = Double.valueOf(pricePounds + "." + pricePence);
        price = String.format("£%,.2f", formattedPrice);
        return price;
    }
    
    /*this constructor provides a way to create new ASCStockItem objects 
    with specific attributes and initial values, which can be stored in the
    storedData ArrayList.*/
    public ASCStockItem(String productCode, String productTitle, String productDescription, int pricePounds, int pricePence, int stockQuantity){
        this.productCode = productCode;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.pricePounds = pricePounds;
        this.pricePence = pricePence;
        this.stockQuantity = stockQuantity;
    }
    
    
    public ASCStockItem() {
        
    }
}
