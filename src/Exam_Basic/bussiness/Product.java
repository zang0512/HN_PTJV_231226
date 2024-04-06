package Exam_Basic.bussiness;

import Exam_Basic.bussiness.IProduct;
import Exam_Basic.util.InputMethods;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements IProduct, Serializable {
    // xây dựng thuộc tính
    private int productId;
    private String productName, title, descriptions;
    private float importPrice, exportPrice, interest;
    private boolean productStatus;

    // cac constructor
    public Product() {
        // khong co tham so
    }
    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    // các getter
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getTitle() {
        return title;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public float getImportPrice() {
        return importPrice;
    }
    public float getExportPrice() {
        return exportPrice;
    }
    public float getInterest() {
        return interest;
    }
    public boolean isProductStatus() {
        return productStatus;
    }

    // cac setter
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }
    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(boolean isAdd, boolean isUpdate) {
        if (isAdd){
            System.out.println("Nhap id cua san pham");
            this.productId = InputMethods.getInteger();
        }
        if (isUpdate){
            System.out.println("Nhap ten cua san pham");
            this.productName = InputMethods.getString();
            System.out.println("Nhap tieu de cua san pham");
            this.title = InputMethods.getString();
            System.out.println("Nhap mo ta cua san pham");
            this.descriptions = InputMethods.getString();
            System.out.println("Nhap gia nhap cua san pham");
            this.importPrice = InputMethods.getFloat();
            while (importPrice < 0){
                System.err.println("Gia nhap khong duoc be hon 0");
                this.importPrice = InputMethods.getFloat();
            }
            System.out.println("Nhap gia xuat cua san pham");
            this.exportPrice = InputMethods.getFloat();
            while (exportPrice<importPrice){
                System.err.println("Gia ban khong duoc thap hon gia nhap");
                this.exportPrice = InputMethods.getFloat();
            }
            this.interest = (exportPrice - importPrice);
        }
        System.out.println("Nhap trang thai cua san pham");
        while (true) {
            System.out.println("Trang thai:\n 1. Dang ban\n 2. Het hang");
            byte statusChoice = InputMethods.getByte();
            switch (statusChoice) {
                case 1:
                    this.productStatus = true;
                    break;
                case 2:
                    this.productStatus = false;
                    break;
                default:
                    System.err.println("Khong hop le, nhap 1 hoac 2");
            }
            if (statusChoice == 1 || statusChoice ==2){
                break;
            }
        }
    }
    @Override
    public void displayData() {
        System.out.printf("Id: %-5s| Ten: %-15s| Tieu de: %-10s| Mo ta: %-10s| Gia Nhap: %-5s$| Gia ban: %-5s$| Lai: %-5s$| TT: %-8s\n",productId,productName,title,descriptions,importPrice,exportPrice,interest,productStatus?"Dang ban":"Het hang");
    }
}
