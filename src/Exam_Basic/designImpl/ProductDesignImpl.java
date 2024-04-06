package Exam_Basic.designImpl;

import Exam_Basic.bussiness.Product;
import Exam_Basic.bussiness.design.IDesignProduct;
import Exam_Basic.util.IOFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDesignImpl implements IDesignProduct {
    private static List<Product> products;
    static {
        // khoi tao gia tri
        products = IOFile.readFromFile(IOFile.PRODUCT_PATH);
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
        // ghi ra file
        IOFile.writeToFile(IOFile.PRODUCT_PATH, products);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        products.set(products.indexOf(findById(product.getProductId())), product);
        // ghi ra file
        IOFile.writeToFile(IOFile.PRODUCT_PATH, products);
    }


    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getProductId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteId(int id) {
        products.remove(findById(id));
        IOFile.writeToFile(IOFile.PRODUCT_PATH, products);
    }

    @Override
    public void searchByName() {

    }

    private static void sortProduct(int types) {
        List<Product>unsortedList = new ArrayList<>(products);

        // sắp xếp theo kiểu
        switch (types) {
            case 1:
                unsortedList.sort(Comparator.comparing(Product::getProductName));
                break;
            case 2:
                unsortedList.sort(Comparator.comparing(Product::getExportPrice));
                break;
            case 3:
                unsortedList.sort(Comparator.comparing(Product::getInterest));
                break;
        }

        System.out.printf("%s theo %s\n", types == 1 ? "Tên" : types == 2 ? "giá bán" : "lợi nhuận");
        unsortedList.forEach(Product::displayData);

    }
}
