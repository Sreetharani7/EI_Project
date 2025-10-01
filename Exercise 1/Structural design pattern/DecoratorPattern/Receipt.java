package DecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void printReceipt() {
        System.out.println("\n===== BILL SUMMARY =====");
        double total = 0;
        for (Product item : items) {
            System.out.printf("%-40s Rs.%.2f%n", item.getDescription(), item.getCost());
            total += item.getCost();
        }
        System.out.println("----------------------------");
        System.out.printf("TOTAL: Rs.%.2f%n", total);
        System.out.println("============================\n");
    }
}
