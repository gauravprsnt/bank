package com.company;

import java.util.Scanner;

public class Invoice implements Payable {
    private int partNumber;
    private String partName;
    private int quantity;
    private int pricePerItem;

    public Invoice() {

    }

    Scanner scanner = new Scanner(System.in);

    public Invoice(int partNumber, String partName, int quantity, int pricePerItem) {
        setPartNumber(partNumber);
        setPartName(partName);
        setQuantity(quantity);
        setPricePerItem(pricePerItem);

    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }


    @Override
    public double payment() {
        return getQuantity() * getPricePerItem();
    }

    public void readIntoInvoice() {

        System.out.println("Enter Part Number::");
        setPartNumber(scanner.nextInt());
        System.out.println("Enter Part Description::");
        setPartName(scanner.next());
        System.out.println("Enter Quantitiy::");
        setQuantity(scanner.nextInt());
        System.out.println("Enter Price per Item::");
        setPricePerItem(scanner.nextInt());


    }

    public void display() {
        System.out.println("Part Number::" + getPartNumber());
        System.out.println("Part Name::" + getPartName());
        System.out.println("Quantity::" + getQuantity());
        System.out.println("Price Per Item::" + getPricePerItem());
        System.out.println("Total::" + payment());
    }
}
