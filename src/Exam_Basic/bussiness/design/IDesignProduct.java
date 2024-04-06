package Exam_Basic.bussiness.design;

import Exam_Basic.bussiness.Product;

import java.util.List;

public interface IDesignProduct {
    void addNewProduct(Product product);
    List<Product> findAll();
    void updateProduct(Product product);
     Product findById(int id);
    void deleteId(int id);
    void searchByName();
    List<Product> sortProduct(int types);
}
