package hu.gov.allamkincstar.webshop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList = new ArrayList<Product>();

    public ShoppingCart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productList=" + productList +
                '}';
    }

    public void addShoppingCart(String articleNumber, Warehouse warehouse) {
        Boolean inShoppingCart = Boolean.FALSE;

        if (articleNumber.isEmpty()) {
            throw new RuntimeException("A kosárba helyezendő termék cikkszáma üres!");
        }

        for (Product product : warehouse.getProductList()) {
            if ((product.getArticleNumber() == articleNumber) && (product.getProductStatus() == ProductStatus.IN_STOCK) && (! inShoppingCart)) {
                product.setProductStatus(ProductStatus.UNDER_ORDERS);
                this.productList.add(product);
                inShoppingCart = Boolean.TRUE;
            }
        }

        if (! inShoppingCart) {
            throw new RuntimeException("A megadott cikkszámú termék elfogyott!");
        }
    }

    public void removeShoppingCart(String articleNumber) {

        Product removeProduct = null;

        if (articleNumber.isEmpty()) {
            throw new RuntimeException("A kosárból törlendő termék cikkszáma üres!");
        }

        if (this.getProductList().isEmpty()) {
            throw new RuntimeException("A kosár üres!");
        }

        for (Product product : this.getProductList()) {
            if (product.getArticleNumber() == articleNumber ) {
                product.setProductStatus(ProductStatus.IN_STOCK);
                removeProduct = product;
                break;
            }
        }

        if (removeProduct == null ) {
            throw new RuntimeException("Nincs ilyen cikkszámú termék a kosárban!");
        } else {
            this.productList.remove(removeProduct);
        }

    }

}
