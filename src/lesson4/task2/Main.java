package lesson4.task2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("shampoo", 120, Item.ProductCategory.NON_PROD));
        items.add(new Item("toothbrush", 90, Item.ProductCategory.NON_PROD));
        items.add(new Item("banana", 75, Item.ProductCategory.PROD));

        makeDiscount(items);

        ArrayList<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer("Ilia", 1000));
        buyers.add(new Buyer("Sabina", 5000));
        buyers.add(new Buyer("Valera", 2000));

        Shop shop = new Shop(items, buyers);

        try {
            System.out.println(shop.deal("Ilia", "shampoo",  5));
            shop.deal("Valera", "shampoo", 1);
            shop.deal("Ilia", "shampoo", 5);
            //shop.deal("Ilia", "car", 2);
            shop.deal("Ilia", "toothbrush", 1);
        } catch (NoBuyerFoundException | NoItemFoundException | IllegalAmountException | TooMuchSaleException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------");
        System.out.println("Total deals: " + Order.getCounter());

    }

    public static void makeDiscount(ArrayList<Item> items){
        for (Item item : items) {
            int discount = Item.getRandomDiscount().getAmount();
            item.setPrice(item.getPrice() - (item.getPrice() * discount / 100));
            System.out.println(item);
            System.out.println("Discount = " + discount + "%");
        }
    }

}
