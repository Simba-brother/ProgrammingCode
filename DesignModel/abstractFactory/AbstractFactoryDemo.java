package DesignModel.abstractFactory;
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("生产奔驰车C180");
        BenzFactory benzFactory = new C180Factory();
        benzFactory.createCar();
    }
}