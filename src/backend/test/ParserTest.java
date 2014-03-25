package backend.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;

import slogo.Controller;
import backend.Executor;
import backend.Parser;
import backend.Tokenizer;
import backend.command.Bracket;
import backend.command.BracketClose;
import backend.command.Command;
import backend.command.control.UserDefinedCommand;
import backend.command.turtle.ForwardCommand;
import backend.command.turtle.TurnRightCommand;

public class ParserTest {

	private String language = "english";
	private HashMap<String, Double> var = new HashMap<String, Double>();
	private HashMap<String, UserDefinedCommand> udc = new HashMap<String, UserDefinedCommand>();
	private Controller controller = new Controller();
	@Test
	public void testForward() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Parser parse = new Parser(var, udc);
		Command fd = new ForwardCommand();
		fd.addArgumentDouble(50.0);
		String[] fd50 = {"FD","50"};
		parse.parse(fd50, language);
		assertEquals(parse.parse(fd50, language).remove(), fd);
	}

	@Test
	public void testRight() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Parser parse = new Parser(var, udc);
		Command rt = new TurnRightCommand();
		rt.addArgumentDouble(50.0);
		String[] rt50 = {"RT","50"};
		parse.parse(rt50, language);
		assertEquals(parse.parse(rt50, language).remove(), rt);
	}

	@Test
	public void testRightRight() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Parser parse = new Parser(var, udc);
		Command rt = new TurnRightCommand();
		Command rt1 = new TurnRightCommand();
		rt1.addArgumentDouble(50.0);
		rt.addArgumentCommand(rt1);
		String[] rt50 = {"RT","RT","50"};
		parse.parse(rt50, language);
		assertEquals(parse.parse(rt50, language).remove(), rt);
	}
	
	@Test
	public void testFDFD() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Parser parse = new Parser(var, udc);
		Command rt = new ForwardCommand();
		Command rt1 = new ForwardCommand();
		rt1.addArgumentDouble(50.0);
		rt.addArgumentCommand(rt1);
		String[] rt50 = {"FD","FD","50"};
		parse.parse(rt50, language);
		assertEquals(parse.parse(rt50, language).remove(), rt);
	}

	@Test
	public void testMultipleCommands() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		LinkedList<Command> testCase = new LinkedList<Command>();
		Parser parse = new Parser(var, udc);
		Command rt = new TurnRightCommand();
		Command rt1 = new TurnRightCommand();
		rt.addArgumentDouble(50.0);
		rt1.addArgumentDouble(50.0);
		testCase.add(rt);
		testCase.add(rt1);

		String[] rt50rt50 = {"RT","50","RT","50"};
		assertEquals(parse.parse(rt50rt50, language), testCase);
	}

//	@Test
//	public void testDiffBasic() throws InstantiationException, IllegalAccessException{
//		Parser parse = new Parser(var, udc);
//		String[] diff = {"-", "60", "50"};
//		assertEquals(parse.parse(diff).remove().execute(), 10.0, 0.01);
//	}
	
	@Test
	public void testProductBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] prod = {"PRODUCT", "6", "5"};
		assertEquals(parse.parse(prod, language).remove().execute(), 30.0, 0.01);
	}

	@Test
	public void testSinBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] sin = {"SIN", "90"};
		assertEquals(parse.parse(sin, language).remove().execute(), 1.0, 0.01);
	}
	
	@Test
	public void testEqualBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] equals = {"EQUALP", "80", "90"};
		assertEquals(parse.parse(equals, language).remove().execute(), 0.0, 0.01);
	}
	
	@Test
	public void testNotBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] not = {"NOT", "80"};
		assertEquals(parse.parse(not, language).remove().execute(), 0.0, 0.01);
	}
	
	@Test
	public void testAndBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] and = {"AND", "80", "90"};
		assertEquals(parse.parse(and, language).remove().execute(), 1.0, 0.01);
	}
	
	@Test
	public void testAnd2Basic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] and = {"AND", "80", "0"};
		assertEquals(parse.parse(and, language).remove().execute(), 0.0, 0.01);
	}
	
	@Test
	public void testSumBasic() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		String[] sum = {"+", "60", "50"};
		assertEquals(parse.parse(sum, language).remove().execute(), 110.0, 0.01);
	}

//	@Test
//	public void testDiffNesting() throws InstantiationException, IllegalAccessException{
//		Parser parse = new Parser(var, udc);
//		String[] diff = {"-", "-", "10", "-", "20", "30", "40"};
//		assertEquals(parse.parse(diff).remove().execute(), 100.0, 0.01);
//	}
	
	@Test
	public void testBracket1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ fd 50 fd 50 ]");
		Command fd1 = new ForwardCommand();
		Command fd2 = new ForwardCommand();
		Command bc = new BracketClose();
		Command br = new Bracket();
		fd1.addArgumentDouble(50.0);
		fd2.addArgumentDouble(50.0);
		br.addArgumentCommand(fd1);
		br.addArgumentCommand(fd2);
		br.addArgumentCommand(bc);
		Bracket a = (Bracket) parse.parse(b, language).remove();
		assertEquals(a, br);
	}
	
	@Test
	public void testBracket2()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Executor execute = new Executor();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ sum 50 0 sum sum 10 20 30 ]");
		assertEquals(60.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);
	}
	
	@Test
	public void testBracket3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ sum [ sum sum 10 20 30 ] 0 ]");
		assertEquals(60.0, parse.parse(b, language).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket4() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ [ ] sum 50 0 ]");
		assertEquals(50.0, parse.parse(b, language).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket5() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("sum [ ST ] [ ST ]");
		assertEquals(2.0, parse.parse(b, language).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket6() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ sum [ sum sum 10 20 30 ] [ sum sum 10 20 30 ] ]");
		Command c = parse.parse(b, language).remove();
		Double d = c.execute();
		assertEquals(120.0, d, 0.01);
	}
	
	@Test
	public void testIf() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("if sum 50 50 sum 50 100");
		String[] c = token.tokenize("if sum 50 -50 sum 50 100");
		assertEquals(150.0, parse.parse(b, language).remove().execute(), 0.01);
		assertEquals(0.0, parse.parse(c, language).remove().execute(), 0.01);
	}
	
	@Test
	public void testRepeat() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("REPEAT 20 REPCOUNT");
		String[] c = token.tokenize("REPEAT 5 [ sum 10 myRepcount ]");
		assertEquals(20.0, parse.parse(b, language).remove().execute(), 0.01);
		assertEquals(15.0, parse.parse(c, language).remove().execute(), 0.01);
	}
	
	@Test
	public void testIfElse() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("ifelse sum 50 50 [ sum 50 100 ] sum 100 100");
		String[] c = token.tokenize("ifelse sum 50 -50 sum 50 100 sum 100 100");
		assertEquals(150.0, parse.parse(b, language).remove().execute(), 0.01);
		assertEquals(200.0, parse.parse(c, language).remove().execute(), 0.01);
	}
	

	@Test
	public void testVariables1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize(":testVal make :testVal 10 :testVal");
		assertEquals(10.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);
	}
	
	@Test
	public void testVariables2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize(":testVala make :testVala 10 :testValb make :testValb :testVala :testValb");
		assertEquals(10.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);
	}
	
	@Test
	public void testDoTimes() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("dotimes [ :var 5 ] [ :var ]");
		assertEquals(4.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);
	}
	
	@Test
	public void testFor() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("for [ :var 0 4 1 ] [ :var ]");
		assertEquals(4.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);
	}
	
	@Test
	public void testDefineCommands1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		HashMap<String, UserDefinedCommand> udc = new HashMap<String, UserDefinedCommand>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("to test [ :testVar ] [ :testVar ]  test 4");
		assertEquals(4.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);		
	}
	
	@Test
	public void testDefineCommands2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		HashMap<String, UserDefinedCommand> udc = new HashMap<String, UserDefinedCommand>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("to test [ :testVar :testVarb ] [ sum :testVar :testVarb ]  test 2 2");
		assertEquals(4.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);		
	}
	
	@Test
	public void testDefineCommands3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Executor execute = new Executor();
		HashMap<String, Double> var = new HashMap<String, Double>();
		HashMap<String, UserDefinedCommand> udc = new HashMap<String, UserDefinedCommand>();
		Parser parse = new Parser(var, udc);
		Tokenizer token = new Tokenizer(); //2 + 3 + 2 = 7 
		String[] b = token.tokenize("to test [ :testVar :testVarb ] [ sum :testVar :testVarb ]  to testA [ :b :c ] [ sum sum test 1 :b test 2 1 :c ] testA 1 2");
		assertEquals(7.0, execute.executeCommands(parse.parse(b, language), controller, 1), 0.01);		
	}
}
