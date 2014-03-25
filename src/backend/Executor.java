package backend;

import java.util.Queue;

import slogo.Controller;
import backend.command.Command;

/**
 * Translates the parse tree into commands for the turtle
 */
public class Executor { //Will need to add some error checking code most likely
	
	/**
	 * Passes the instance of the Controller as well as the turtle ID into the command
	 * being executed.
	 * @param commands a Queue of commands
	 * @param controller the instance of the Controller
	 * @param ID the ID of the turtle being commanded
	 * @return the result of the last executed command
	 */
	public double executeCommands(Queue<Command> commands, Controller controller, int ID){
		double returnValue = 0.0;
		while(!commands.isEmpty()){
			Command command = commands.remove();
			command.setTurtleID(ID);
			command.setController(controller);
			returnValue =  command.execute();
		}
		return returnValue;
	}
}
