package labka;

public interface IBeverage
{
    double GetCost();
    String GetDescription();
}

class Coffee implements IBeverage {
    public double GetCost(){
        return 60.0;
    }

    public String GetDescription(){
        return "coffee";

    }
}
abstract class BeverageDecorator implements IBeverage {
    protected IBeverage _beverage;

    public BeverageDecorator(IBeverage beverage){
        _beverage = beverage;
    }

    public double GetCost(){
        return _beverage.GetCost();
    }

    public  String GetDescription(){
        return _beverage.GetDescription();
    }
}
class MilkDecorator extends BeverageDecorator{
    public MilkDecorator(IBeverage beverage) {
        super(beverage);

    }

    public double GetCost(){
        return _beverage.GetCost() + 10.0;
    }

    public String GetDescription(){
        return _beverage.GetDescription() + ", Milk";
    }
}
class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(IBeverage beverage){
        super(beverage);
    }

    public double GetCost(){
        return _beverage.GetCost() + 5.0;  // Стоимость с добавлением сахара
    }

    public String GetDescription() {
        return _beverage.GetDescription() + ", Sugar";
    }
}
class ChocolateDecorator extends BeverageDecorator{
    public ChocolateDecorator(IBeverage beverage){
        super(beverage);
    }

    public double GetCost(){
        return _beverage.GetCost() + 15.0;
    }

    public String GetDescription(){
        return _beverage.GetDescription() + ", Chocolate";
    }
}
class Main{
    public static void main(String[] args) {
        IBeverage beverage = new Coffee();
        System.out.println(beverage.GetDescription() +" "+ beverage.GetCost());

        beverage = new MilkDecorator(beverage);
        System.out.println(beverage.GetDescription() +" "+ beverage.GetCost());

        beverage = new SugarDecorator(beverage);
        System.out.println(beverage.GetDescription() +" "+ beverage.GetCost());

        beverage = new ChocolateDecorator(beverage);
        System.out.println(beverage.GetDescription() +" "+ beverage.GetCost());

    }
}