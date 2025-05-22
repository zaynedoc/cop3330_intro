package smarthome;

public abstract class SmartDevice {
    boolean toggle = false; // false off; true on
    String brand;   // manufacturer of device
    String name;    // name for device

    SmartDevice(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }   // Although never initializing a device as "SmartDevice," must have this function for inheritance

    public abstract void toggleOff();
    public abstract void toggleOn();
    public abstract void printStatus();
}