package airport;

public interface IFan {
    void increaseRPM(int value);
    void decreaseRPM(int value);
    void shutdown();
    void start();
}
