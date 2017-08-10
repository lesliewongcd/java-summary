package ind.lw.java.dynamicproxy;

public class TargetClient implements IClient{
    @Override
    public void createAccount() {
        System.out.println("do something");
    }
}
