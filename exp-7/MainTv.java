public class MainTv {
    public static void main(String[] args) {
        Remote remote = new Television();
        remote.powerOn();
        remote.changeChannel(5);
        remote.powerOff();
    }
}
    