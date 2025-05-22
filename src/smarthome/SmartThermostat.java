package smarthome;
import java.util.Scanner;

public class SmartThermostat extends SmartDevice {
    Scanner stdin = new Scanner(System.in);
    int temperature;
    int savedTemperature = temperature;

    SmartThermostat(int temperature, String brand, String name) {
        super(brand, name);     // Grabs constructor function from SmartDevice to initialize
        this.temperature = temperature;
        this.toggle = true; // initialize as on upon start
    }

    @Override
    public void toggleOff() {
        toggle = false;
        savedTemperature = temperature;
        temperature = 83;
        System.out.println(name + " turned OFF; setting temperature to room temperature (" + temperature + "°F)");
    }

    @Override
    public void toggleOn() {
        System.out.println(name + " turned ON; setting temperature to " +  savedTemperature + "°F");
        toggle = true;
    }

    public void setTemperature() {
        System.out.println("Set temperature for " + name + ":");
        temperature = stdin.nextInt();
        savedTemperature = temperature; // Saves last temp after toggling off thermostat
    }

    @Override
    public void printStatus(){
        if (toggle) {
            System.out.println("[ON] SmartThermostat: " + name + " (" + brand + ") - temperature: " + temperature +"°F");
        } else {
            System.out.println("[OFF] SmartThermostat: " + name + " (" + brand + ") - temperature: "+ temperature + "°F");
        }
    }
}