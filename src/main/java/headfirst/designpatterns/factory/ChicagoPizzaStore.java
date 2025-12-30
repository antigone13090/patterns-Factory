package headfirst.designpatterns.factory;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if ("cheese".equalsIgnoreCase(type)) {
            Pizza p = new CheesePizza(ingredientFactory);
            p.setName("Chicago Style Cheese Pizza");
            return p;
        }
        if ("clam".equalsIgnoreCase(type)) {
            Pizza p = new ClamPizza(ingredientFactory);
            p.setName("Chicago Style Clam Pizza");
            return p;
        }

        throw new IllegalArgumentException("Unknown pizza type: " + type);
    }
}
