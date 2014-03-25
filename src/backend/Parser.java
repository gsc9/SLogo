package backend;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import backend.command.CommandFactory;
import backend.command.Command;
import backend.command.control.ToCommand;
import backend.command.control.UserDefinedCommand;
import backend.command.variable.Variable;

/**
 * Holds methods for parsing an array list of tokenized commands
 */
public class Parser {
	private static final String NUMBER = "-?[0-9]+\\.?[0-9]*";
	private static final String WORD = "[a-zA-z_]+(\\?)?";
	private static final String OPERANDS = "[+-/%~*]";
	private static final String VARIABLE = ":[a-zA-z]+";
	private static final String LEFTBRACKET = "[";
	private static final String RIGHTBRACKET = "]";
	
	private CommandFactory myCommands;
	private LinkedList<String> myCurrentTokens;
	private HashMap<String, Double> myVariables;
	private HashMap<String, UserDefinedCommand> myUserCommands;

	public Parser(HashMap<String, Double> var, HashMap<String, UserDefinedCommand> udc) 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		myVariables = var;
		myUserCommands = udc;
		myCurrentTokens = new LinkedList<String>();
	}

	/**
	 * Takes a string of tokens and the language being used, and returns a queue
	 * of commands to be executed.
	 * @param tokens a String array of commands and parameters
	 * @param language the language in which commands/parameters were entered
	 * @return a queue of commands
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException 
	 */
	public Queue<Command> parse(String[] tokens, String language) 
			throws InstantiationException, IllegalAccessException {
		try {
			myCommands = new CommandFactory(myVariables, myUserCommands, language);
		} catch (Exception e) {
			e.printStackTrace();
		}
		generateQueue(tokens);
		LinkedList<Command> commands = new LinkedList<Command>();
		while(!myCurrentTokens.isEmpty()){ 
			if(Pattern.matches(VARIABLE, myCurrentTokens.peek())){ //checking if is variable
				commands.add(defineVariable(myCurrentTokens.remove()));
			}
			else if(Pattern.matches(WORD, myCurrentTokens.peek()) || 
					Pattern.matches(OPERANDS,myCurrentTokens.peek()))
				commands.add(defineCommand(myCurrentTokens.remove()));
			else{
				//Should not be reached. error state. No commands probably
				System.out.println("Incorrect input type; " + myCurrentTokens.peek() + 
						" is not a valid variable, word, or operand.");
			}
		}
		return commands;
	}
	
	private Command defineVariable(String s){
		return new Variable(s, myVariables);
	}
	
	private Command defineCommand(String s) throws InstantiationException, IllegalAccessException{
		Command c;
		if(myCommands.hasCommand(s)){
			c = myCommands.getCommand(s);
			completeCommand(c);
			return c;
		}
		//Display error message
		System.out.println("The " + s + " command does not exist.");
		return null;
	}

	private void completeCommand(Command c) throws InstantiationException, IllegalAccessException {
		int numArguments = c.getArgumentCount();
		int count = 0;
		String token = "emptyList";
		defineUserCommand(c);
		while(((count < numArguments) || isLeftBracket(c, count)) && isNotRightBracket(token, c)){
			count++;
			if(myCurrentTokens.isEmpty()){
				//Display error message
				System.out.println("Command queue is empty; no commands to exeute.");
			}
			else{
				token = myCurrentTokens.remove();
				if(token != null && Pattern.matches(VARIABLE, token)){
					c.addArgumentCommand(defineVariable(token));
				}
				else if(token != null && Pattern.matches(NUMBER, token)){
					c.addArgumentDouble(Double.parseDouble(token));
				}
				else if((token != null && Pattern.matches(WORD, token) || Pattern.matches(OPERANDS,token)) 
						|| (token.equals(LEFTBRACKET))){
					c.addArgumentCommand(defineCommand(token));
				}
				else{
					//Display error message
					System.out.println("Input is not correct; make sure all inputs are either variables, "
							+ "numbers, letters, or operands.");
				}
			}
		}
	}
	
	private void defineUserCommand(Command c){
		if(c.getClass().toString().endsWith("ToCommand")){
			ToCommand def = (ToCommand)c;
			def.setName(myCurrentTokens.remove());
		}
	}

	private boolean isLeftBracket(Command c, int count) {
		return (!myCurrentTokens.isEmpty() && myCurrentTokens.peek().equals(LEFTBRACKET) || 
				c.getClass().toString().endsWith("Bracket")) && 
				count < c.getArgumentCount();
	}

	private boolean isNotRightBracket(String token, Command c){
		return !token.equals(RIGHTBRACKET) && !c.getClass().toString().endsWith("BracketClose");
	}


	private void generateQueue(String[] tokens){
		for(String s: tokens){
			myCurrentTokens.add(s);
		}
	}

}
