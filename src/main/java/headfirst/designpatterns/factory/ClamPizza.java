package headfirst.designpatterns.factory;

public class ClamPizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.name = "Clam Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();

        System.out.println(" - dough: " + dough);
        System.out.println(" - sauce: " + sauce);
        System.out.println(" - cheese: " + cheese);
        System.out.println(" - clams: " + clams);
    }
}
