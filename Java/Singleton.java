public class Logger {
	
	private static Logger logger;
	
	private Logger() {};
	
	public static Logger getLoggerInstance() {
		if(logger==null) {
			logger = new Logger();
		}
		return logger;
	}
	
	public void log(String message) {
		System.out.println(message);
	}
	
}

//===========================================================

public class DemoClass {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLoggerInstance();
		
		logger.log("log this message");

	}

}

//===========================================================
/*


log this message


*/