package backend;

import java.util.HashMap;
import java.util.List;

import backend.command.control.UserDefinedCommand;
import slogo.Controller;

/**
 * API to the back end. Frontend sends strings of user input commands through the Controller
 * into this class.
 */
public class Backend {
	private Tokenizer myTokenizer;
	private Parser myParser;
	private Executor myExecutor;
	private Controller myController;
	private String myLanguage = "english"; //default is English
	private HashMap<String, Double> variables;
	private HashMap<String, UserDefinedCommand> userCommands;
	
	public Backend(Controller controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		variables = new HashMap<String, Double>();
		userCommands = new HashMap<String, UserDefinedCommand>();
		myTokenizer = new Tokenizer();
		myParser = new Parser(variables, userCommands);
		myExecutor = new Executor();
		myController = controller;
	}
	
	public void setLanguage(String language) {
		myLanguage = language;
	}
	
	/**
	 * Takes in a string of commands and sends the string off to the parser.
	 * This method must be called after the method that sets the language.
	 * @param command a String of commands entered by the user
	 * @param activeTurtleIDs a list of the IDs of active turtles
	 * @return the final return value of the command
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public double parse(String command, List<Integer> activeTurtleIDs) throws InstantiationException, IllegalAccessException{ 
		double returnVal = 0.0;
		for(int ID : activeTurtleIDs) {
			returnVal = myExecutor.executeCommands(myParser.parse(myTokenizer.tokenize(command), myLanguage), myController, ID);
		}
		return returnVal;
	}

}
