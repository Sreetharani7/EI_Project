package DecoratorPattern;
public class AloeVeraAddon extends ProductDecorator {
    public AloeVeraAddon(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Aloe Vera Extract";
    }

    @Override
    public double getCost() {
        return product.getCost() + 50.0;
    }
}
