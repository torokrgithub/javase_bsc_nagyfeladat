package hu.gov.allamkincstar.webshop;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Product> productList = new ArrayList<Product>();

    public Warehouse(List<Product> productList) {
        this.productList = productList;
    }

    public void addWarehouse(Product inProduct) {

        for (Product product : productList) {
            if(inProduct.getProductID().equals(product.getProductID())){
                throw new RuntimeException("Már létezik termék a megadott cikkszámmal.");
            }
        }

        this.productList.add(inProduct);

    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "productList=" + productList +
                '}';
    }
}

