package lesson4.task2;

public class Order {

    private Buyer buyer;
    private Item item;
    private int amountItems;
    private double cost;
    private static int counter;

    public Order(Buyer buyer, Item item, int amountItems) {
        this.buyer = buyer;
        this.item = item;
        this.amountItems = amountItems;
        finalCost();
        counter++;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Item getItem() {
        return item;
    }

    public int getAmountItems() {
        return amountItems;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
    }

    public static int getCounter() {
        return counter;
    }

    public void finalCost(){
        if (Item.getRandomDiscount().getAmount() == 0){
            cost = item.getPrice();
        } else {
            cost = item.getPrice() * ((100 -Item.getRandomDiscount().getAmount()) / 100.0) * amountItems;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", item=" + item +
                ", amountItems=" + amountItems +
                ", cost=" + cost +
                '}';
    }
}
