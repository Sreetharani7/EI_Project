package Factory;

import java.util.logging.Logger;

public class Haircut implements Service {
    private static final Logger logger = Logger.getLogger(Haircut.class.getName());

    @Override
    public void performService(String customerName) {
        logger.info("Performing a stylish haircut for " + customerName);
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
