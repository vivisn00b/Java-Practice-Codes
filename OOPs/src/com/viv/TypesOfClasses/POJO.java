package OOPs.src.com.viv.TypesOfClasses;

// POJO (Plain Old Java Object) is a simple class that primarily contains private fields, public getters and setters

class Products {
    private int id;
    private String name;
    private double price;

    // No-argument constructor (default)
    public Products() {
    }

    // Parameterized constructor
    public Products(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        return price - (price * discountPercentage / 100);
    }

    // toString() method
    @Override
    public String toString() {
        return "Product id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}

class POJO {
    public static void main(String[] args) {
        Products product = new Products(1, "Laptop", 75000.0);

        // Accessing fields using getters
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Price: " + product.getPrice());

        // Modifying fields using setters
        product.setPrice(72000.0);
        System.out.println("Updated Price: " + product.getPrice());

        System.out.println(product);

        double discountedPrice = product.getDiscountedPrice(10);
        System.out.println("Price after 10% discount: " + discountedPrice);
    }
}
