package lesson4.task2;

import java.util.ArrayList;

public class Shop {

    final ArrayList<Item> stock;
    final ArrayList<Buyer> customers;


    public Shop(ArrayList<Item> stock, ArrayList<Buyer> customers) {
        this.stock = stock;
        this.customers = customers;
    }

    public Order deal(String buyerName, String item, int amount) throws NoBuyerFoundException, NoItemFoundException, IllegalAmountException, TooMuchSaleException {
        if (amount <= 0) {
            throw new IllegalAmountException("Amount is: " + amount);
        }
        Buyer tempBuyer = null;
        Item tempItem = null;
        tempBuyer = getTempBuyer(buyerName, tempBuyer);
        tempItem = getTempItem(item, tempItem);
        tempItem.getRandomDiscount();
        if (amountOfDiscounts() > 50) {
            throw new TooMuchSaleException();
        }
        return new Order(tempBuyer, tempItem, amount);
    }

    private Item getTempItem(String item, Item tempItem) throws NoItemFoundException {
        for (int i = 0; i < stock.size(); i++) {
            if (item.equals(stock.get(i).getName())) {
                tempItem = stock.get(i);
                break;
            }
        }
        if (tempItem == null) {
            throw new NoItemFoundException("Shop doesn't have such item in stock");
        }
        return tempItem;
    }

    private Buyer getTempBuyer(String buyerName, Buyer tempBuyer) throws NoBuyerFoundException {
        for (int i = 0; i < customers.size(); i++) {
            if (buyerName.equals(customers.get(i).getName())) {
                tempBuyer = customers.get(i);
                break;
            }
        }
        if (tempBuyer == null) {
            throw new NoBuyerFoundException("No such buyer found");
        }
        return tempBuyer;
    }

    private int amountOfDiscounts() {
        int amountOfDiscounts = 0;
        for (Item item : stock) {
            if (Item.getDiscount() != null) {
                amountOfDiscounts += Item.getDiscount().getAmount();
            }
        }
        return amountOfDiscounts;
    }

}
