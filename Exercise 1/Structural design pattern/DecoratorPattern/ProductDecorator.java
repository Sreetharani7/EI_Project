package DecoratorPattern;
public abstract class ProductDecorator implements Product {
    protected final Product product;

    protected ProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }

    @Override
    public double getCost() {
        return product.getCost();
    }
}
