package DecoratorPattern;

public class VitaminCAddon extends ProductDecorator {
    public VitaminCAddon(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Vitamin C";
    }

    @Override
    public double getCost() {
        return product.getCost() + 70.0;
    }
}
