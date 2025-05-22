package smarthome;
import java.util.Scanner;

public class SmartLight extends SmartDevice {
    Scanner stdin = new Scanner(System.in);
    int brightness;
    int defaultBrightness = 0;

    SmartLight(int brightness, String brand, String name) {
        super(brand, name);     // Grabs constructor function from SmartDevice to initialize
        this.brightness = brightness;
    }

    @Override
    public void toggleOff() {
        System.out.println(name + " has been turned OFF");
        toggle = false;
        brightness = 0;
    }

    @Override
    public void toggleOn() {
        System.out.println(name + " has been turned ON");
        toggle = true;
        if (defaultBrightness != 0) {
            brightness = defaultBrightness;
        } else {
            brightness = 100;
        }
    }

    public void setBrightness() {
        System.out.println("Set bright for " + name + ":");
        brightness = stdin.nextInt();
        defaultBrightness = brightness; // When user toggles light on and back on, returns to defaultBrightness
    }

    @Override
    public void printStatus(){
        if (toggle || brightness > 0) {
            System.out.println("[ON] SmartLight: " + name + " (" + brand + ") - Brightness: " + brightness +"%");
            toggle = true;  // When initializing light, user isn't asked to toggle
        } else {    // Technically should print 0% if off, just for testing output
            System.out.println("[OFF] SmartLight: " + name + " (" + brand + ") - Brightness: " + brightness +"%");
        }
    }
}
