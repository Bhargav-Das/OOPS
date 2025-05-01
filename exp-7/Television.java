public class Television implements Remote {
    @Override
    public void powerOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is off");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }
}