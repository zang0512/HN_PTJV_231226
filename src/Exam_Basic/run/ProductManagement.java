package Exam_Basic.run;

import Exam_Basic.bussiness.Product;
import Exam_Basic.bussiness.design.IDesignProduct;
import Exam_Basic.designImpl.ProductDesignImpl;
import Exam_Basic.util.InputMethods;

import java.util.List;

public class ProductManagement {
    private static IDesignProduct designProduct = new ProductDesignImpl();

    public static void main(String[] args) {
        byte choice = 0;
        while (choice != 8) {
            System.out.println("****************PRODUCT-MANAGER-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi thông tin sản phẩm theo mã sản phẩm\n" +
                    "7. Thay đổi trạng thái của sản phẩm theo mã sản phẩm \n" +
                    "8. Thoát\n");
            System.out.println("Nhap lua chon cua ban");
            choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sortProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    break;
                case 6:
                    updateProduct();
                    break;
                case 7:
                    updateProductStatus();
                    break;
                case 8:
                    break;
                default:
                    System.err.println("Lua chon khong hop le");
            }
        }
    }

    // them moi san pham
    private static void addNewProduct(){
        System.out.println("Nhap so luong muon them");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count ; i++) {
            System.out.println("Hay nhap thong tin cho san pham thu " + (i+1));
            Product product = new Product();
            product.inputData(true, true);
            designProduct.addNewProduct(product);
        }
        System.out.println("Da them moi thanh cong" + count+ " san pham");
    }

    // hien thi san pham
    private static void displayProduct(){
        List<Product> list = designProduct.findAll();
        if (list.isEmpty()){
            System.err.println("Khong co san pham nao");
        } else {
            System.out.println("Danh sach san pham:");
            list.forEach(Product::displayData);
        }
    }

    // thay doi thong tin va trang thai san pham
    private static void updateProduct(){
        System.out.println("Nhap id san pham can sua thong tin");
        int id = InputMethods.getInteger();

        Product product = designProduct.findById(id);
        if (product== null){
            System.err.println("Khong tim thay id");
        } else {
            System.out.println("Hien thi thong tin cu");
            product.displayData();
            System.out.println("Nhap thong tin moi");
            product.inputData(false, true);
            designProduct.updateProduct(product);
            System.out.println("cap nhat thanh cong thong tin san pham co id " + id);
        }}
    private static void updateProductStatus(){
        System.out.println("Nhap id san pham can sua trang thai");
        int id = InputMethods.getInteger();

        Product product = designProduct.findById(id);
        if (product== null){
            System.err.println("Khong tim thay id");
        } else {
            System.out.println("Hien thi thong tin cu");
            product.displayData();
            System.out.println("Nhap trang thai moi");
            product.inputData(false, false);
            designProduct.updateProduct(product);
            System.out.println("cap nhat thanh cong trang thai san pham co id " + id);
    }}

    // xoa san pham theo id
    protected static void deleteProduct(){
        System.out.println("Nhap id san pham muon xoa");
        int id = InputMethods.getInteger();

        Product product = designProduct.findById(id);
        if (product==null) {
            System.out.println("Khong tim thay id");
        } else {
            designProduct.deleteId(id);
            System.out.println("Xoa thanh cong san pham co id " + id);
        }
    }

    // sap xep san pham
    private static void sortProduct(){
        int types;
        // nhập dữ liệu kiểu cần sắp xếp
        while (true) {
            System.out.println("Chọn trường sắp xếp\n" + "1. Tên\n" + "2. giá bán\n" + "3. lợi nhuận\n");
            types = InputMethods.getInteger();

            if (types < 1 || types > 3) {
                System.err.println("Lựa chọn không hợp lệ");
            } else {
                designProduct.sortProduct();
                break;
            }
        }
    }
}
