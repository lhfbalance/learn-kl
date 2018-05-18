package learnLamda;

public class Event {

    private String name;

    Event(String name) {
        this.name = name;
    }

    public String getName() {
         return name;
    }

    void notice(Manager m) {
        m.listeners.forEach(l -> l.response2Event(this));
    }
}
