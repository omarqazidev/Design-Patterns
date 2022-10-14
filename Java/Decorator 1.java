
public abstract class Bicycle {

	public abstract double getPrice();

	public abstract String ride();

}

//================================================================================================

public class BMX extends Bicycle {

	public String getDescription() {
		return "BMX";
	}

	public double getPrice() {
		return 3000;
	}

	public String ride() {
		return "Riding " + getDescription();
	}

}

//================================================================================================

public class RacingBike extends Bicycle {

	public String getDescription() {
		return "RacingBike";
	}

	public double getPrice() {
		return 5000;
	}

	public String ride() {
		return "Riding " + getDescription();
	}

}

//================================================================================================

public abstract class BikeDecorator extends Bicycle {

}

//================================================================================================

public class BikeWithBell extends decorator.BikeDecorator {

	Bicycle bicycle;

	public BikeWithBell(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public double getPrice() {
		return (bicycle.getPrice() + 20);
	}

	public String ride() {
		return (bicycle.ride() + " with bell");
	}

	public String ringBell() {
		return ride() + " ringing";
	}
}

//================================================================================================

public class BikeWithLight extends decorator.BikeDecorator {

	Bicycle bicycle;

	public BikeWithLight(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public double getPrice() {
		return (bicycle.getPrice() + 30);
	}

	public String ride() {
		return (bicycle.ride() + " with lights");
	}

	public String lightOn() {
		return ride() + " on";
	}

	public String lightOff() {
		return ride() + " off";
	}
}

//================================================================================================

public class BikeWithTrainingWheels extends decorator.BikeDecorator {

	Bicycle bicycle;

	public BikeWithTrainingWheels(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public double getPrice() {
		return (bicycle.getPrice() + 50);
	}

	public String ride() {
		return (bicycle.ride() + " with training wheels");
	}
}

//================================================================================================

public class DemoClass {

	public static void decorator() {

		System.out.println("\n\n========================================");
		System.out.println("\t\tDecorator");
		System.out.println("========================================\n");

		BMX bike1 = new BMX();
		System.out.println(bike1.getDescription());
		System.out.println(bike1.getPrice());
		System.out.println(bike1.ride());

		System.out.println();

		RacingBike bike2 = new RacingBike();
		System.out.println(bike2.getDescription());
		System.out.println(bike2.getPrice());
		System.out.println(bike2.ride());

		System.out.println();

		BikeWithLight bike3 = new BikeWithLight(bike1);
		System.out.println(bike3.getPrice());
		System.out.println(bike3.ride());
		System.out.println(bike3.lightOn());
		System.out.println(bike3.lightOff());

		System.out.println();

		BikeWithBell bike4 = new BikeWithBell(bike3);
		System.out.println(bike4.getPrice());
		System.out.println(bike4.ride());
		System.out.println(bike4.ringBell());

		Bicycle bike5 = new BikeWithTrainingWheels(bike4);
		System.out.println(bike5.getPrice());
		System.out.println(bike5.ride());

	}

}

//================================================================================================
/*

========================================
		Decorator
========================================

BMX
3000.0
Riding BMX

RacingBike
5000.0
Riding RacingBike

3030.0
Riding BMX with lights
Riding BMX with lights on
Riding BMX with lights off

3050.0
Riding BMX with lights with bell
Riding BMX with lights with bell ringing
3100.0
Riding BMX with lights with bell with training wheels


*/



