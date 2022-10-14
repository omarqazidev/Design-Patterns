
public interface Character {
    
    void move();

}

//================================================================================================

public class Bot implements Character{

    private String type;
    
    public Bot(String type){
    	this.type = type;
    }
    
    @Override
    public void move() {
    	System.out.println("-" + type + " Bot is Moving");
    }
 
}

//================================================================================================

import java.util.HashMap;

public class CharacterFactory {

    private static final HashMap<String, Character> characterMap = new HashMap<String, Character>();

    public static Character getBot(String type) {
    	Bot bot = (Bot) characterMap.get(type);

		if (bot == null) {
		    bot = new Bot(type);
		    characterMap.put(type, bot);
		    System.out.println("Creating bot of type: " + type);
		}
		return bot;
    }

}

//================================================================================================

public class DemoClass {

    private static final String typesOfBots[] = {
		"Friendly",
		"Enemy",
		"NPC",
		"Robot"
    };

    public static void flyweight() {
	
		System.out.println("\n\n========================================");
		System.out.println("\t\tFlyweight");
		System.out.println("========================================\n");
	
		for (int i = 0; i < 10; i++) {
		    Bot bot = (Bot) CharacterFactory.getBot(getRandomBot());
		    bot.move();
		}
	
    }
	
    private static String getRandomBot() {
		return typesOfBots[(int) (Math.random() * typesOfBots.length)];
    }

}

//================================================================================================
/*

========================================
		Flyweight
========================================

Creating bot of type: Friendly
-Friendly Bot is Moving
Creating bot of type: NPC
-NPC Bot is Moving
-NPC Bot is Moving
Creating bot of type: Robot
-Robot Bot is Moving
-Robot Bot is Moving
-Robot Bot is Moving
-Friendly Bot is Moving
Creating bot of type: Enemy
-Enemy Bot is Moving
-Robot Bot is Moving
-Enemy Bot is Moving


*/

