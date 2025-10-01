package Observer;

public class User implements Subscriber {
    private final String name;

    public User(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subscriber name cannot be null or empty");
        }
        this.name = name.trim();
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("[NOTIFICATION] " + name + " → " + channelName + " uploaded \"" + videoTitle + "\"");
    }

    @Override
    public String getName() {
        return name;
    }
}
