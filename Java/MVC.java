
import java.util.ArrayList;

public interface Model {

    public void setAll(ArrayList list);
    public ArrayList getAll();
    
}

//===========================================================================

import java.util.ArrayList;

public class Student implements Model {

	private String name;
	private String rollNumber;

	public Student(String name, String rollNumber) {
		this.name = name;
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public void setAll(ArrayList list) {
		setName((String) list.get(0));
		setRollNumber((String) list.get(1));
	}

	@Override
	public ArrayList getAll() {
		ArrayList list = new ArrayList();
		list.add(getName());
		list.add(getRollNumber());
		return list;
	}

}

//===========================================================================

import java.util.ArrayList;

public class Controller {

    private Model model;
    private View view;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }
    
    public void setModel(Model model){
        this.model = model;
    }
    public void setView(View view){
        this.view = view;
    }
    
    public void setData(ArrayList listOfData){
        model.setAll(listOfData);
    }
    
    public ArrayList getData(){
        ArrayList list = new ArrayList();
        list = model.getAll();
        return list;
    }
    
    public void updateView(){
        view.printDataOnView(getData());
    }
    
}

//===========================================================================

import java.util.ArrayList;

public class DemoClass {

	public static void main(String[] args) {

		Student omar = new Student("Omar Qazi", "FA16-BSE-114");

		View console = new View();
		Controller controller = new Controller(omar, console);
		controller.updateView();

		Student sobhan = new Student("Sobhan", "");
		controller.setModel(sobhan);
		ArrayList sobhanData = new ArrayList();
		sobhanData.add("Sobhan");
		sobhanData.add("FA16-BSE-110");
		controller.setData(sobhanData);

		controller.updateView();

	}

}

//===========================================================================
/*


Omar Qazi
FA16-BSE-114

Sobhan
FA16-BSE-110


*/



