package ind.lw.java.dynamicproxy;

public class Test {

    public static void main(String[] args) {

        IClient client = new TargetClient();
        IClient proxy = (IClient) new TargetProxy(client).getProxy();
        
        proxy.createAccount();
    }
}
