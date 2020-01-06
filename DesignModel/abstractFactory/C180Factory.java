package DesignModel.abstractFactory;
public class C180Factory implements BenzFactory {

    @Override
    public Benz createCar() {
        return new C180Benz();
    }

    @Override
    public CarNavigator createNavigator() {
        return new C180Navigator();
    }

}