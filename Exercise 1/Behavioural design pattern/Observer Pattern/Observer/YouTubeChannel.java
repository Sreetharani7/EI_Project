package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class YouTubeChannel {
    private static final Logger LOGGER = Logger.getLogger(YouTubeChannel.class.getName());

    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public YouTubeChannel(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Channel name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public void subscribe(Subscriber s) {
        if (s == null) return;
        if (!subscribers.contains(s)) {
            subscribers.add(s);
            LOGGER.info(s.getName() + " subscribed to " + name);
        } else {
            LOGGER.warning(s.getName() + " is already subscribed to " + name);
        }
    }

    public void unsubscribe(Subscriber s) {
        if (s == null) return;
        if (subscribers.remove(s)) {
            LOGGER.info(s.getName() + " unsubscribed from " + name);
        } else {
            LOGGER.warning(s.getName() + " was not subscribed to " + name);
        }
    }

    public void uploadVideo(String videoTitle) {
        if (videoTitle == null || videoTitle.trim().isEmpty()) {
            LOGGER.warning("Video title cannot be empty");
            return;
        }
        LOGGER.info(name + " uploaded a new video: \"" + videoTitle + "\"");
        notifySubscribers(videoTitle);
    }

    private void notifySubscribers(String videoTitle) {
        for (Subscriber s : new ArrayList<>(subscribers)) {
            try {
                s.update(name, videoTitle);
            } catch (Exception e) {
                LOGGER.severe("Error notifying " + s.getName() + ": " + e.getMessage());
            }
        }
    }
}
