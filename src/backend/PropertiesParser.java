package backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesParser {

	/**
	 * Takes in a language name and an empty commands map, and populates the map
	 * with mappings of string commands in a certain language to the strings of the
	 * command class paths.
	 * @param language - the String indicating which language should be used
	 * @param commands - the empty map of commands to class paths
	 * @throws IOException 
	 */
	public void read(String language, Map<String, String> commands) throws IOException {
		String source = "src/languages/" + language + ".properties";
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(source);
		properties.load(in);
		
		for(Object key : properties.keySet()) {
			String command = key.toString();
			String classPath = properties.getProperty(command).toString();
			commands.put(command.toUpperCase(), classPath);
		}
	}
	
}
