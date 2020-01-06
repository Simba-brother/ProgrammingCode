package DesignModel.abstractFactory;
public class C180Benz implements Benz {
    public C180Benz(){
        carColor();
        carSpeed();
        carPrice();
    }

    @Override
    public void carColor() {
        System.out.println("c180 颜色为红色");
    }

    @Override
    public void carSpeed() {
        System.out.println("c180 速度为180km/h");
    }

    @Override
    public void carPrice() {
        System.out.println("c180 价格为180万");
    }
    
}