package backend.command.control;

import backend.command.Command;
import backend.command.Parameter;

public class ToCommand extends Command {
	
	private static final int myParameterCount = 2; //Takes in string immediately during parsing
	private String commandName;
	
	public ToCommand(){
		super(myParameterCount);
	}
	
	public void setName(String name){
		commandName = name;
	}
	
	public void addArgumentCommand(Command c){
		myParameters.add(new Parameter(c));
		myCurrentParameters++;
		if(myCurrentParameters == myParameterCount){
			execute();
		}
	}
	
	public double execute(){
		UserDefinedCommand newCommand = new UserDefinedCommand(commandName, 
				myParameters.get(0).getCommand(), myParameters.get(1).getCommand());
		myUserCommands.put(commandName, newCommand);
		return 1.0;
	}	
	
}
