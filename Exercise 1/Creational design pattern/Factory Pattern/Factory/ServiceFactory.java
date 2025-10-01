package Factory;

public class ServiceFactory {
    public static Service getService(String choice) {
        if (choice == null) {
            return null;
        }
        switch (choice.toLowerCase()) {
            case "haircut":
                return new Haircut();
            case "facial":
                return new Facial();
            case "manicure":
                return new Manicure();
            case "pedicure":
                return new Pedicure();
            default:
                return null;
        }
    }
}
