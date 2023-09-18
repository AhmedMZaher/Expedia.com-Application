package Model;

public class Item {
    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void printItem() {
        throw new UnsupportedOperationException("This method must be overridden");
    }
    public int getItemIdFromDatabase(){
        throw new UnsupportedOperationException("This method must be overridden");
    }
}
