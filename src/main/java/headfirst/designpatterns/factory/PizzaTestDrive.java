package headfirst.designpatterns.factory;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza1.getName());
        System.out.println();

        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza2.getName());
        System.out.println();

        Pizza pizza3 = nyStore.orderPizza("clam");
        System.out.println("Ethan ordered a " + pizza3.getName());
        System.out.println();

        Pizza pizza4 = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza4.getName());
    }
}
