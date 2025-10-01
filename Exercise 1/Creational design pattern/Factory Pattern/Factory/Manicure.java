package Factory;

import java.util.logging.Logger;

public class Manicure implements Service {
    private static final Logger logger = Logger.getLogger(Manicure.class.getName());

    @Override
    public void performService(String customerName) {
        logger.info("Doing manicure for " + customerName);
    }

    @Override
    public double getCost() {
        return 500.0;
    }
}
