/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.e2;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IFEOLUWA
 */
public class ASCTableModel extends AbstractTableModel {
    //fields
    //empty string array for column names
    private String [] columnNames;
    
    //empty two dimensional object array for data
    private Object[][] data;
    
    //provide a custom constructor
    public  ASCTableModel(final String [] colNames, final ArrayList<ASCStockItem> dataList) {
        //get length of array parameter
        int columnNamesLength = colNames.length;
        
        //copy parameter array into column names
        columnNames = Arrays.copyOf(colNames, columnNamesLength);
        //get size of arraylist
        int rowLength = dataList.size();
        
        //set size of data array
        data = new Object[rowLength][columnNamesLength];
        
        //set index variables for data row
        int row = 0;
        
        //loop through array list
        for (ASCStockItem item: dataList) {
            String productCode = item.getProductCode();
            String productTitle = item.getProductTitle();
            String productDescription = item.getProductDescription() ;
            String Price = item.getPrice();
            //Integer pricePence = item.getPricePence();
            Integer stockQuantity = item.getStockQuantity();
            //Integer pricePounds = item.getPricePounds();
            
            //use fields to create object array
            Object [] dataRow = new Object[] {productCode, productTitle, productDescription, Price, stockQuantity};
            
            //copy row data array into current data row
            data[row] = Arrays.copyOf(dataRow, columnNamesLength);
            
            //increase row index
            row++;
        }
    }// end constructor
    
    //overriden method
    @Override
    public int getRowCount() {
        return data.length;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        //get object at intersection of row and column in data
        return data[row][column];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    
    
}
