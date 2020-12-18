package hu.gov.allamkincstar.webshop;

public class Product {

    private String productID;
    private String articleNumber;
    private String description;
    private String manufacturer;
    private int price;
    private ProductStatus productStatus;

    public Product(String productID, String articleNumber, String description, String manufacturer, int price) {
        if (productID.isEmpty()) {
            throw new RuntimeException("A termék egyedi azonosítója üres!");
        }
        this.productID = productID;
        this.articleNumber = articleNumber;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.productStatus = ProductStatus.IN_STOCK;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", articleNumber='" + articleNumber + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", productStatus=" + productStatus +
                '}';
    }
}

