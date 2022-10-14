
public abstract class OnlineStoreTemplate {
    
    public final void buyItems(){
		selectItems();
		verifyCart();
		chooseDeliveryMethod();
		choosePaymentMethod();
		payForItems();
    }
    
    private void choosePaymentMethod(){
    	System.out.println("Choose a Payment Method:\t Choose a payment option");
    }
    
    private void verifyCart(){
    	System.out.println("Verify Items in Your Cart:\t You are redirected to cart page");
    }
    
    public abstract void chooseDeliveryMethod();
    public abstract void selectItems();
    public abstract void payForItems();

}



//=============================================================================================================================================


public class Amazon extends OnlineStoreTemplate {

    @Override
    public void selectItems() {
    	System.out.println("Selecting Items:\t\t Select items by clicking the 'Add to Cart' button");
    }

    @Override
    public void chooseDeliveryMethod() {
    	System.out.println("Choosing Delivery Method:\t Delivery options for your country is shown (if amazon is in your contry)");
    }

    public void payForItems() {
    	System.out.println("Pay for the Items:\t\t You are redirected to Amazon Pay");
    }

}

//=============================================================================================================================================


public class AliBaba extends OnlineStoreTemplate {

    @Override
    public void selectItems() {
    	System.out.println("Selecting Items:\t\t Select items by clicking on the item, choosing the version you want, then click 'Start Order'");
    }

    @Override
    public void chooseDeliveryMethod() {
    	System.out.println("Choosing Delivery Method:\t Delivery options for national and international shipping are shown");
    }

    public void payForItems() {
    	System.out.println("Pay for the Items:\t\t You are Shown multiple payment methods, select the one you like and pay with it");
    }

}

//=============================================================================================================================================


public class DemoClass {

    public static void template(){
	
	System.out.println("\n\n========================================");
	System.out.println("\t\tTemplate");
	System.out.println("========================================\n");
	
	OnlineStoreTemplate storeType = new Amazon();
	storeType.buyItems();
	
	System.out.println("\n\n");
	
	storeType = new AliBaba();
	storeType.buyItems();
	
    } 
    
} 

//=============================================================================================================================================
/*


========================================
		Template
========================================

Selecting Items:		 Select items by clicking the 'Add to Cart' button
Verify Items in Your Cart:	 You are redirected to cart page
Choosing Delivery Method:	 Delivery options for your country is shown (if amazon is in your contry)
Choose a Payment Method:	 Choose a payment option
Pay for the Items:		 You are redirected to Amazon Pay



Selecting Items:		 Select items by clicking on the item, choosing the version you want, then click 'Start Order'
Verify Items in Your Cart:	 You are redirected to cart page
Choosing Delivery Method:	 Delivery options for national and international shipping are shown
Choose a Payment Method:	 Choose a payment option
Pay for the Items:		 You are Shown multiple payment methods, select the one you like and pay with it


/*

