
public interface Pizza {
    
    public String getDescription();
    public int getCost();

}

//================================================================================================

public class PlainPizza implements Pizza {

	@Override
	public String getDescription() {
		return "Plain Pizza";
	}

	@Override
	public int getCost() {
		return 700;
	}

}

//================================================================================================

public class PizzaDecorator implements Pizza {

	protected Pizza tempPizza;

	public PizzaDecorator(Pizza newPizza) {
		tempPizza = newPizza;
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription();
	}

	@Override
	public int getCost() {
		return tempPizza.getCost();
	}

}

//================================================================================================

public class FajitaPizza extends PizzaDecorator {

	public FajitaPizza(Pizza newPizza) {
		super(newPizza);
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription() + ", Fajita";
	}

	@Override
	public int getCost() {
		return tempPizza.getCost() + 400;
	}

}

//================================================================================================

public class CheesePizza extends PizzaDecorator {

	public CheesePizza(Pizza newPizza) {
		super(newPizza);
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription() + ", Cheese";
	}

	@Override
	public int getCost() {
		return tempPizza.getCost() + 600;
	}

}

//================================================================================================

public class DemoClass {

	public static void decorator() {

		System.out.println("\n\n========================================");
		System.out.println("\t\tDecorator");
		System.out.println("========================================\n");
		
		Pizza basicPizza1 = new FajitaPizza(new CheesePizza(new PlainPizza()));
		System.out.println("Ingredients:\t" + basicPizza1.getDescription());
		System.out.println("Price:\t\t" + basicPizza1.getCost());
		System.out.println();

		Pizza basicPizza2 = new FajitaPizza(new PlainPizza());
		System.out.println("Ingredients:\t" + basicPizza2.getDescription());
		System.out.println("Price:\t\t" + basicPizza2.getCost());
		System.out.println();

		Pizza basicPizza3 = new CheesePizza(new PlainPizza());
		System.out.println("Ingredients:\t" + basicPizza3.getDescription());
		System.out.println("Price:\t\t" + basicPizza3.getCost());
		System.out.println();
	}

}

//================================================================================================
/*

========================================
		Decorator
========================================

Ingredients:	Plain Pizza, Cheese, Fajita
Price:			1700

Ingredients:	Plain Pizza, Fajita
Price:			1100

Ingredients:	Plain Pizza, Cheese
Price:			1300


*/



