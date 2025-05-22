package smarthome;

public class Room {
    String name;
    SmartDevice[] devices;

    Room(String name, SmartDevice[] devices) {
        this.name = name;
        this.devices = devices;
    }

    public void addDevice(SmartDevice[] devices, SmartDevice device) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] == null) {   // if nothing in spot of devices[i], add device
                devices[i] = device;
                return;
            }
        }   // if function ends, then array of devices for room is full

        System.out.println("Error in Room class: exceeded limit for devices");
    }

    // Go through array of devices in room; toggle each on
    public void toggleOnAll(SmartDevice[] devices) {
        for (SmartDevice device : devices) {
            device.toggleOn();
        }
    }

    // Go through array of devices in room; toggle each off
    public void toggleOffAll(SmartDevice[] devices) {
        for (SmartDevice device : devices) {
            device.toggleOff();
        }
    }

    public void deviceStatuses(SmartDevice[] devices) {
        for (SmartDevice device : devices) {
            if (device != null) { // in Main, device array initializes devices as null
                device.printStatus();
            }
        }
    }
}
