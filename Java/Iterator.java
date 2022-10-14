
public interface Iterator {
	public boolean hasNext();
	public Object next();	
}

//=====================================================================================================

public interface Container {
	public Iterator getIterator();
}

//=====================================================================================================

import java.util.ArrayList;

public class ObjectRepository implements Container {

	public ArrayList<Object> objects = new ArrayList<Object>();

	public void addObject(Object object) {
		objects.add(object);
	}

	public void RemoveObject(Object object) {
		objects.remove(object);
	}

	public Iterator getIterator() {
		return new ObjectIterator();
	}

	private class ObjectIterator implements Iterator {

		int index;

		public boolean hasNext() {
			if (index < objects.size()) {
				return true;
			} else {
				return false;
			}
		}

		public Object next() {
			if (this.hasNext()) {
				return objects.get(index++);
			}
			return null;
		}
	}
}

//=====================================================================================================

import java.util.ArrayList;
import java.util.Arrays;

public class DemoClass {

	public static void main(String[] args) {

		ArrayList<Boolean> arrayList = new ArrayList<Boolean>(Arrays.asList(new Boolean[] {true, true, false, false}));

		ObjectRepository objectRepository = new ObjectRepository();

		objectRepository.addObject("Jamie");
		objectRepository.addObject("Earl");
		objectRepository.addObject("Mike");
		objectRepository.addObject("Sheldon");
		objectRepository.addObject(12);
		objectRepository.addObject(arrayList);

		for (Iterator i = objectRepository.getIterator(); i.hasNext();) {
			Object object = i.next();

			System.out.println(object);

		}

	}

}

//=====================================================================================================
/*


Jamie
Earl
Mike
Sheldon
12
[true, true, false, false]


*/



