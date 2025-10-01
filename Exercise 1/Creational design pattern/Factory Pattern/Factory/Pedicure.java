package Factory;

import java.util.logging.Logger;

public class Pedicure implements Service {
    private static final Logger logger = Logger.getLogger(Pedicure.class.getName());

    @Override
    public void performService(String customerName) {
        logger.info("Doing pedicure for " + customerName);
    }

    @Override
    public double getCost() {
        return 600.0;
    }
}
