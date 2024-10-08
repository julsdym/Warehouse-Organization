package warehouse;

/*
 * This class represents a warehouse Product.
 * 
 * @author Julia Dymnicki
 * 
 */ 
public class Product {
    private int id;              // product identification
    private String name;         // product name
    private int stock;           // number of items in stock
    private int lastPurchaseDay; // the number of days since the store opening that the item was last purchased
    private int demand;          // initial demand is obtained from a survey prior to product release
    private int popularity;      // Initial Demand + Total Amount Purchased + Date of Last Purchase

    public Product(int i, String n, int s, int l, int d) {
        id = i;
        name = n;
        stock = s;
        lastPurchaseDay = l;
        demand = d;
        popularity = l + d;
    }
    
    public Product(int i, String n, int s, int l) {
        this(i, n, s, l, 0);
    }
    
    public Product(int i, String n) {
        this(i, n, 0, 0);
    }

    public int getId() { 
        return id; 
    }

    public String getName() { return name; }
    public int getStock() { return stock; }
    public int getLastPurchaseDay() { return lastPurchaseDay; }
    public int getDemand() { return demand; }
    public int getPopularity() { return popularity; }

    public void setId(int i) { id = i; }
    public void setName(String n) { name = n; }
    public void updateStock(int s) { stock += s; }
    public void setStock(int s) { stock = s; }
    public void setLastPurchaseDay(int l) {
        lastPurchaseDay = l;
        popularity = lastPurchaseDay + demand;
    }
    
    public void updateDemand(int d) { 
        demand += d;
        popularity = lastPurchaseDay + demand;
    }
    
    public void setDemand(int d) {
        demand = d;
        popularity = lastPurchaseDay + demand;
    } 
    
    /*
     * Returns true if this object equals other
     */
    public boolean equals (Object other) {
        if ( !(other instanceof Product) ) {
            return false;
        }
        Product o = (Product) other;
        return this.getId() == o.getId();
    }

    public String toString() {
        return String.format("(%s: %d, %d)", name, stock, popularity);
    }
}
