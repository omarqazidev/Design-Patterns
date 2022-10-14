
public interface CompositeInterface {
    
    public int getID();
    public String getName();
    public String getDescription();
    public void print();
    public void add(Composite item);
    public void remove(Composite item);
    public Composite get(int index);
     
}

//==================================================================================================================================================

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements CompositeInterface {

	private int id;
	private String name;
	private String description;

	List<Composite> composites = new ArrayList<Composite>();

	public Composite(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void add(Composite compositeItem) {
		composites.add(compositeItem);
	}

	public void remove(Composite compositeItem) {
		composites.remove(compositeItem);
	}

	public Composite get(int index) {
		return composites.get(index);
	}

	@Override
	public void print() {
		System.out.println("===========================================================");
		System.out.println("ID:\t\t" + getID());
		System.out.println("Name:\t\t" + getName());
		System.out.println("Description:\t" + getDescription());
		// System.out.println("===========================================================");

		Iterator<Composite> compositeIterator = composites.iterator();

		while (compositeIterator.hasNext()) {
			Composite compositeItem = compositeIterator.next();
			compositeItem.print();
		}

	}

}


//==================================================================================================================================================

public class DemoClass {

    public static void main(String[] args) {
    	
    	//===========================================================================================================
    	
    	//CEO
    	Composite ceo = new Composite(1,"Gregg Simons", "The CEO");
    	
       	//Software Developer Team
    	Composite devTeamLeader = new Composite(23,"Jamie Jackson", "Team leader of the Development team");
    	
    	Composite devWeb = new Composite(124,"Carl Kessler", "React Developer");
    	Composite devIos = new Composite(126,"George Dawson", "iOS Developer");
    	Composite devAndroid = new Composite(112,"Shane Khan", "Flutter Developer");
    	
    	//Software Quality Team
    	Composite qaTeamLeader = new Composite(13,"Donald Norton", "Team leader of the Quality Assurance team");
    	
    	Composite qaEngineer = new Composite(454,"Leigh Conner", "Software Quality Engineer");
    	Composite qaAnalyst = new Composite(432,"Alvin Phillips", "Software Quality Analyst");
    	Composite qaTestManager = new Composite(403,"Donnell Mast", "Software Testing Manager/Engineer");
    	
    	//===========================================================================================================
    	
    	//Assigning developers to the developer team leader
    	devTeamLeader.add(devWeb);
    	devTeamLeader.add(devIos);
    	devTeamLeader.add(devAndroid);
    	
    	//Assigning quality staff to the quality team leader
    	qaTeamLeader.add(qaEngineer);
    	qaTeamLeader.add(qaAnalyst);
    	qaTeamLeader.add(qaTestManager);
    	
    	//Assigning both team leaders to the ceo
    	ceo.add(devTeamLeader);
    	ceo.add(qaTeamLeader);
    	
    	//===========================================================================================================
    	
    	//print the entire hierarchy of the company
    	ceo.print();
    	
    }
    
}

//==================================================================================================================================================
/*


===========================================================
ID:		1
Name:		Gregg Simons
Description:	The CEO
===========================================================
ID:		23
Name:		Jamie Jackson
Description:	Team leader of the Development team
===========================================================
ID:		124
Name:		Carl Kessler
Description:	React Developer
===========================================================
ID:		126
Name:		George Dawson
Description:	iOS Developer
===========================================================
ID:		112
Name:		Shane Khan
Description:	Flutter Developer
===========================================================
ID:		13
Name:		Donald Norton
Description:	Team leader of the Quality Assurance team
===========================================================
ID:		454
Name:		Leigh Conner
Description:	Software Quality Engineer
===========================================================
ID:		432
Name:		Alvin Phillips
Description:	Software Quality Analyst
===========================================================
ID:		403
Name:		Donnell Mast
Description:	Software Testing Manager/Engineer


*/



