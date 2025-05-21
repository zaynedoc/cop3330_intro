package inheritance;

public class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }

    // Composition: when an object class exists solely within another class
    // Example: the type of an engine is only used within the Vehicle class
}
