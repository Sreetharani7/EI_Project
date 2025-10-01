package DecoratorPattern;

public class AntiAgingAddon extends ProductDecorator {
    public AntiAgingAddon(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Anti-Aging Serum";
    }

    @Override
    public double getCost() {
        return product.getCost() + 100.0;
    }
}
