package lesson4.task2;

import java.util.Random;

public class Item {

    private String name;
    private int price;
    private ProductCategory productCategory;
    private static Discount discount;

    public Item(String name, int price, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public enum ProductCategory{
        PROD,
        NON_PROD;

    }

    public enum Discount {

        NONE(0),
        FIVE_PERCENT(5),
        TEN_PERCENT(10),
        FIFTEEN_PERCENT(15),
        TWENTY_PERCENT(20);

        private final int amount;

        Discount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public static Discount getDiscount() {
        return discount;
    }

    public static void setDiscount(Discount discount) {
        Item.discount = discount;
    }

    public static Discount getRandomDiscount(){
        Random random = new Random();
        int index = random.nextInt(Discount.values().length);
        return Discount.values()[index];
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory +
                '}';
    }
}
