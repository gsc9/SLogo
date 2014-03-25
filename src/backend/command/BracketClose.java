package backend.command;

/**
 * Allows backend to recognize a closing square bracket as the end of a command
 */
public class BracketClose extends Command {
	public BracketClose(){
		myParameterCount =0;
	}
	
	public boolean equals(Object obj){
		return true;
	}
	
}
