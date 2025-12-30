package headfirst.designpatterns.factory;

public abstract class Pizza {
    protected String name;

    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 180°C");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
