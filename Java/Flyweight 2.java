
public interface Character {
	
	public void diaplayCharacter();

}

//================================================================================================

public class Digit {
	
	int typeOfDigit;
    int sizeOfDigit;
    int locationOfDigit;

    public Digit(int typeOfDigit, int sizeOfDigit, int locationOfDigit) {
        this.typeOfDigit = typeOfDigit;
        this.sizeOfDigit = sizeOfDigit;
        this.locationOfDigit = locationOfDigit;
    }
    
    public void diaplayCharacter(){
        System.out.println("" +
                "\tType of Digit:\t" + typeOfDigit +
                "\tSize of Digit:\t" + sizeOfDigit +
                "\tLocation of Digit:\t" + locationOfDigit +
        		"");
    }
}

//================================================================================================

import java.util.HashMap;

public class CharacterFactory{
   
    private final HashMap<Integer, Digit> digitMap = new HashMap<Integer, Digit>();
    private int digitCreationNumber = 0;
    
    public Digit getDigit(int typeOfDigit){
        
        Digit digit = (Digit) digitMap.get(typeOfDigit);
        
        if(digit == null){
            digit = new Digit(typeOfDigit, getRandomSize(),getRandomLocation());
            digitMap.put(typeOfDigit, digit);
            digitCreationNumber++;
            System.out.println(digitCreationNumber + ")Creating new digit");
        }
        
        digit.diaplayCharacter();
        return digit;
    }
    
    private int getRandomSize(){
        return ((int) (Math.random() * 10));
    }
    
    private int getRandomLocation(){
        return ((int) (Math.random() * 100));
    }
    
}

//================================================================================================

public class Document {

	String textInDocument;
	  
    public Document() {
      textInDocument = "";
    }
    
    public void addDigitToDocument(Digit digit){
        textInDocument = textInDocument + "" + digit.typeOfDigit;
    }
    
    public void printDocument(){
        System.out.println(textInDocument);
    }
    
}

//================================================================================================

public class DemoClass {

	private static final int[] arrayOfDigits = {0,1,2,3,4,5,6,7,8,9};
    
    public static void main(String[] args) {
  
        CharacterFactory factory = new CharacterFactory();
       
        Document documentWithDigits = new Document();
        
         for (int i=0; i<30; i++){
            documentWithDigits.addDigitToDocument(factory.getDigit(getRandomDigit()));
        }
         
        System.out.println("\nText of Digit Document:");
        documentWithDigits.printDocument();
        
    }
    
     private static int getRandomDigit(){
        return (arrayOfDigits[(int) (Math.random() * arrayOfDigits.length)]);
    }
	
}

//================================================================================================
/*


1)Creating new digit
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
2)Creating new digit
	Type of Digit:	7	Size of Digit:	6	Location of Digit:	57
3)Creating new digit
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
4)Creating new digit
	Type of Digit:	3	Size of Digit:	4	Location of Digit:	31
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
5)Creating new digit
	Type of Digit:	8	Size of Digit:	7	Location of Digit:	76
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
6)Creating new digit
	Type of Digit:	4	Size of Digit:	3	Location of Digit:	15
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
7)Creating new digit
	Type of Digit:	6	Size of Digit:	7	Location of Digit:	34
8)Creating new digit
	Type of Digit:	0	Size of Digit:	8	Location of Digit:	40
	Type of Digit:	4	Size of Digit:	3	Location of Digit:	15
	Type of Digit:	7	Size of Digit:	6	Location of Digit:	57
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
	Type of Digit:	7	Size of Digit:	6	Location of Digit:	57
	Type of Digit:	0	Size of Digit:	8	Location of Digit:	40
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
	Type of Digit:	8	Size of Digit:	7	Location of Digit:	76
	Type of Digit:	6	Size of Digit:	7	Location of Digit:	34
9)Creating new digit
	Type of Digit:	9	Size of Digit:	4	Location of Digit:	63
	Type of Digit:	0	Size of Digit:	8	Location of Digit:	40
	Type of Digit:	5	Size of Digit:	5	Location of Digit:	74
	Type of Digit:	1	Size of Digit:	5	Location of Digit:	80
	Type of Digit:	4	Size of Digit:	3	Location of Digit:	15
	Type of Digit:	3	Size of Digit:	4	Location of Digit:	31
	Type of Digit:	3	Size of Digit:	4	Location of Digit:	31

Text of Digit Document:
175311815416047517055869051433


*/