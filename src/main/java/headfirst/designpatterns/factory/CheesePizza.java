package headfirst.designpatterns.factory;

public class CheesePizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.name = "Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();

        System.out.println(" - dough: " + dough);
        System.out.println(" - sauce: " + sauce);
        System.out.println(" - cheese: " + cheese);
    }
}
