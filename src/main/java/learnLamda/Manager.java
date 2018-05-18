package learnLamda;

import java.util.LinkedList;
import java.util.List;

public class Manager {

    List<Listener> listeners;

    Manager() {
        listeners = new LinkedList<>();
    }

    void addListener(Listener listener) {
        listeners.add(listener);
    }

    void remListener(Listener listener) {
        listeners.remove(listener);
    }

}
