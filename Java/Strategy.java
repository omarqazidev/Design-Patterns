
public interface Strategy {
    
    public void pay();

}

//=============================================================================

public class CreditCard implements Strategy{

    @Override
    public void pay() {
    	System.out.println("Pay using CreditCard");
    }
    
}

//=============================================================================

public class GiftCard implements Strategy{

    @Override
    public void pay() {
    	System.out.println("Pay using GiftCard");
    }
    
}

//=============================================================================

public class PayPal implements Strategy{

    @Override
    public void pay() {
    	System.out.println("Pay using PayPal");
    }
    
}

//=============================================================================

public class DemoClass {

    public static void strategy() {
	
		System.out.println("\n\n========================================");
		System.out.println("\t\tStrategy");
		System.out.println("========================================\n");
		
		Context context = new Context (new PayPal());
		context.givePayment();
		
		context = new Context(new CreditCard());
		context.givePayment();
		
		context = new Context(new GiftCard());
		context.givePayment();
	
    }
    
}

//=============================================================================
/*


========================================
		Strategy
========================================

Pay using PayPal
Pay using CreditCard
Pay using GiftCard


/*