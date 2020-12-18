package hu.gov.allamkincstar.webshop;

import java.time.LocalDateTime;

public class Order {

    private Customer customer;
    private ShoppingCart shoppingCart;
    private Integer sumPrice;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private OrderStatus OrderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    public Order(Customer customer, ShoppingCart shoppingCart, DeliveryType deliveryType, PaymentType paymentType) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.sumPrice = 0;

        for (Product product : shoppingCart.getProductList()) {
            this.sumPrice = this.sumPrice + product.getPrice();
        }

        this.deliveryType = deliveryType;
        this.paymentType = paymentType;
        this.orderDate = LocalDateTime.now();
        if (deliveryType == DeliveryType.IN_SHOP) {
            this.OrderStatus = OrderStatus.DELIVERED;
            this.deliveryDate = LocalDateTime.now();
            for (Product product : shoppingCart.getProductList()) {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
        } else {
            this.OrderStatus = OrderStatus.BOOKED;
            this.deliveryDate = null;
        }

    }


    public void handOverToCourier() {

        if (!(this.deliveryType == DeliveryType.DELIVERY && this.getOrderStatus() == OrderStatus.BOOKED)) {
            throw new RuntimeException("Webshop-ban bonyolított vásárlás adható át futárnak!");
        } else {
            this.OrderStatus = OrderStatus.IN_PROGRESS;
        }
    }

    public void courierDelivered() {

        if (!(this.deliveryType == DeliveryType.DELIVERY && this.getOrderStatus() == OrderStatus.IN_PROGRESS)) {
            throw new RuntimeException("Kiszállítás alatti termék adható át a megrendelőnek!");
        } else {
            this.OrderStatus = OrderStatus.DELIVERED;
            this.deliveryDate = LocalDateTime.now();
            for (Product product : shoppingCart.getProductList()) {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
        }
    }

    public void courierBringsItBack() {

        if (!(this.deliveryType == DeliveryType.DELIVERY && this.getOrderStatus() == OrderStatus.IN_PROGRESS)) {
            throw new RuntimeException("Kézbesítés alatti rendelés adható vissza a boltnak!");
        } else {
            this.OrderStatus = OrderStatus.FAILED_DELIVERY;

            for (Product product : shoppingCart.getProductList()) {
                product.setProductStatus(ProductStatus.IN_STOCK);
            }
        }
    }


    public Customer getCustomer() {
        return customer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Integer getSumPrice() {
        return sumPrice;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", shoppingCart=" + shoppingCart +
                ", sumPrice=" + sumPrice +
                ", deliveryType=" + deliveryType +
                ", paymentType=" + paymentType +
                ", OrderStatus=" + OrderStatus +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

