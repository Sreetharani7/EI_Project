package Factory;

import java.util.logging.Logger;

public class Facial implements Service {
    private static final Logger logger = Logger.getLogger(Facial.class.getName());

    @Override
    public void performService(String customerName) {
        logger.info("Giving a glowing facial treatment to " + customerName);
    }

    @Override
    public double getCost() {
        return 800.0;
    }
}
