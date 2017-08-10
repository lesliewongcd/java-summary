package ind.lw.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler{
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object returnObject = method.invoke(target,args);

        System.out.println("after");
        return returnObject;
    }

    private Object target;

    public TargetProxy(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
