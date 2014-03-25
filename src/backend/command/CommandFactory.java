package backend.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import backend.PropertiesParser;
import backend.command.control.UserDefinedCommand;

/**
 * Creates an instance of the CommandFactory, taking a hashmap of strings to doubles
 * (variables), a hashmap of strings to UserDefinedCommand objects (user commands), and 
 * the programming language (i.e. English, Spanish) as a string. Automatically attempts to populate
 * an empty hashmap of built-in command names to their class paths, using a parser (Parser.java) and
 * the appropriate language properties file.
 * @param var - hashmap of strings to doubles; a hashmap of variables
 * @param udc - hashmap of strings to UserDefinedCommands; a hashmap of user-defined commands
 * @param language - a string indicating the language in which SLogo commands will be typed
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws ClassNotFoundException
 */
public class CommandFactory {
	private Map<String, String> myCommands;
	private HashMap<String, Double> myVariables;
	private HashMap<String, UserDefinedCommand> myUserCommands;
	private String myLanguage;
	
	public CommandFactory(HashMap<String, Double> var, HashMap<String, UserDefinedCommand> udc, String language) 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		myLanguage = language;
		myCommands = new HashMap<String, String>();
		myVariables = var;
		myUserCommands = udc;
		PropertiesParser parser = new PropertiesParser();
		try {
			parser.read(myLanguage, myCommands);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns true if the given token is a built-in command, or if the
	 * given token is a user-defined command.
	 * @param token - a token (string) that is possibly a command
	 * @return boolean - whether the token is a command or not
	 */
	public boolean hasCommand(String token){
		return (myCommands.containsKey(token) || myUserCommands.containsKey(token));
	}
	
	/**
	 * Determines whether the given token is a valid class name, and returns the instance
	 * of the Command if it is.
	 * @param token - a string that may or may not be a valid command
	 * @return a Command if the token is a valid command
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Command getCommand(String token) throws InstantiationException, IllegalAccessException{
		try {
			String className = "";	
			for(String key : myCommands.keySet()) {
				if(key.equals(token)) {
					className = myCommands.get(key);
				}
			}
			if(myUserCommands.containsKey(token)){
				return myUserCommands.get(token).initialize();
			}
			Class c = Class.forName(className);
			Command newCommand = (Command) c.newInstance();
			newCommand.setVariables(myVariables);
			newCommand.setUserCommands(myUserCommands);
			return newCommand;
		} catch (ClassNotFoundException e) {
			//Display error message
			System.out.println("This command is not in the library of commands.");
			e.printStackTrace();
		}
		return null;
	}
}
