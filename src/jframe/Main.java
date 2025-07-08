package jframe;

public class Main {
    public static void main(String[] args) {
        /*  Instead of having to write all the code for a JFrame window
            We can create that code under a class, then call class anytime
            View the MyClass class to see code for JFrames
         */
        IntroUI window = new IntroUI();
        window.setTitle("COP3330");  // You can still update window's JFrame through individual func calls
    }
}
