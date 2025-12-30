package headfirst.designpatterns.factory;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if ("cheese".equalsIgnoreCase(type)) {
            Pizza p = new CheesePizza(ingredientFactory);
            p.setName("NY Style Cheese Pizza");
            return p;
        }
        if ("clam".equalsIgnoreCase(type)) {
            Pizza p = new ClamPizza(ingredientFactory);
            p.setName("NY Style Clam Pizza");
            return p;
        }

        throw new IllegalArgumentException("Unknown pizza type: " + type);
    }
}
