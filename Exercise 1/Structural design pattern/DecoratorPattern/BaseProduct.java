package DecoratorPattern;

public abstract class BaseProduct implements Product {
    private final String description;
    private final double cost;

    protected BaseProduct(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
