/**
 * Equipment allows the creation of an equipment object
 * @author Ben Capper
 */
public class Equipment {

    /**
     * Equipment attributes initialized
     */
    String name,supplier;
    double cost, amount;

    /**
     * Equipment constructor
     * @param name,supplier,cost,amount
     */
    public Equipment (String name, String supplier, double cost, double amount){
        this.name = name;
        this.supplier = supplier;
        this.cost = cost;
        this.amount = amount;
    }

    /**
     * Returns Equipment Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Equipment Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Equipment Supplier
     * @return supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Sets Equipment Supplier
     * @param supplier
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * Returns Equipment Cost
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets Equipment Cost
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns Equipment Amount
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets Equipment Amount
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns Equipment toString
     * @return Equipment
     */
    @Override
    public String toString() {
        String str = "";
        str += ("\n----------Equipment-----------\n");
        str += ("Name: " + name + "\n");
        str += ("Supplier: " + supplier + "\n");
        str += ("Cost: " + cost + " euro\n");
        str += ("Amount:" + amount + "\n");
        str += ("-------------------------------");
        return str;
    }
}
