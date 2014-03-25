package backend;

/**
 * Takes a string of user input and returns a string array of the
 * user input, split on white spaces, with white spaces, newlines/returns/tabs, etc. trimmed.
 *
 */
public class Tokenizer {

	public String trimWhiteSpace(String string) { 
		return string.trim().replaceAll("[\\t\\n\\r]"," ").replaceAll(" +", " ");
	}

	public String[] tokenize(String command) {
		return trimWhiteSpace(command.toUpperCase()).split("\\s+");
	}
}
