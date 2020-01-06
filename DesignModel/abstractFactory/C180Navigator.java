package DesignModel.abstractFactory;
public class C180Navigator implements CarNavigator {
    public C180Navigator(){
        navigatorColor();
        navigatorPrice();
    }
    @Override
    public void navigatorColor() {
        System.out.println("c180navigator 颜色红色");
    }

    @Override
    public void navigatorPrice() {
        System.out.println("c180navigator 价钱80");
    }

}