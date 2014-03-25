#SLogo README

CompSci 308 (Software Design & Implementation)

###Group Information:

Front End: Dennis Park, Ashley Qian

Back End: Grace Chen, Willy Chen

Date Started: 02/20/14

Date Finished: 03/08/14

Approx. Hours Spent: ~50 hours

[Link to project repository](https://github.com/duke-compsci308-spring2014/slogo_team11)

###Division of Workload:

**FRONTEND**

Ashley and Dennis: View, Swing components (Menu, Buttons, Tabs, Listeners, Canvas), objects that live in the workspace, corresponding manager/control classes

**BACKEND**

Grace: the bulk of Part 2 commands, languages (formatting/parsing properties files), 
enabling commanding multiple turtles

Willy: Parsing, the command classes. command instantiation, command execution, variables, user defined commands

###Sources Consulted:

[Google Translate](translate.google.com)

[Stackoverflow](http://stackoverflow.com/questions)

[Java Swing Tutorials](http://docs.oracle.com/javase/tutorial/uiswing/)

###Important Files:

"Main" class, which displays the GUI, is in the slogo package in the src folder.

Backend tests can be found in the test package of the backend package. ParserTest
tests the functionality of commands/operations, and TokenizerTest tests the 
functionality of the Tokenizer class, which breaks up a string of inputs into a string
array of user-entered commands, parameters, etc.

###Required Data/Resource Files:

In Backend, the CommandFactory class is where the HashMap of strings to strings, where
the keys are valid commands (such as EQUAL? or EQUALP), and the values are the 
directory locations of the classes that contain the definitions of these commands. 
(CommandFactory isn't exactly a data or resource file, but sort of functions like 
one?)

###Misc. Information About Using the Program:

The Controller class, also in the slogo package of the src folder, is the point of 
contact between the Frontend and Backend.

###Known Bugs:

As of 3/8/14: Multiple turtle commands are not yet implemented (the commands just 
execute on all existing turtles, rather than on user-selected turtles only).
