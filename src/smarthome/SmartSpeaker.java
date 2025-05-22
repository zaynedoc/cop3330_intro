package smarthome;
import java.util.Scanner;

public class SmartSpeaker extends SmartDevice {
    Scanner stdin = new Scanner(System.in);
    int volume;
    int defaultVolume = 0;

    SmartSpeaker(int volume, String brand, String name) {
        super(brand, name);     // Grabs constructor function from SmartDevice to initialize
        this.volume = volume;
    }

    @Override
    public void toggleOff() {
        System.out.println(name + " has been turned OFF");
        toggle = false;
        volume = 0;
    }

    @Override
    public void toggleOn() {
        System.out.println(name + " has been turned ON");
        toggle = true;
        if (defaultVolume != 0) {
            volume = defaultVolume;
        } else {
            volume = 100;
        }
    }

    public void setVolume() {
        System.out.println("Set volume for " + name + ":");
        volume = stdin.nextInt();
        defaultVolume = volume;
    }

    @Override
    public void printStatus(){
        if (toggle || volume > 0) {
            System.out.println("[ON] SmartSpeaker: " + name + " (" + brand + ") - Volume: " + volume +"%");
            toggle = true;  // When initializing light, user isn't asked to toggle
        } else {    // Technically should print 0% if off, just for testing output
            System.out.println("[OFF] SmartSpeaker: " + name + " (" + brand + ") - Volume: " + volume +"%");
        }
    }
}