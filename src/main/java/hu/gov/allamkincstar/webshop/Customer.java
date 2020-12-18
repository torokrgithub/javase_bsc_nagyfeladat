package hu.gov.allamkincstar.webshop;

public class Customer {

    private String customerID;
    private String name;
    private String address;
    private String phone;
    private String email;

    public Customer(String customerID, String name, String address, String phone, String email) {
        if (customerID.isEmpty()) {
            throw new RuntimeException("A vásárló egyedi azonosítója üres!");
        }
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

