# The Binary Representation Function Library

This is a program that is set up to provide the user with several converters based on the concepts of binary, hexadecimal, and decimal relationships.

## Usage

To use the program, build the project with an installed JDK in the command-line or using your IDE. Then, run the resulting build in the terminal with no arguments to start the program.

The current program does the following in order:
1. Upon running the program, a welcome message and list of possible converters is shown to the user in the terminal
2. The user must correctly input a number corresponding to the converter, or exit the program (e.g. type-in "1" for choice "1.")
3. Within each converter, there may be choices to further refine what type of conversion the user would like to take place (e.g. toLower or toUpper)
4. The converters each instantiate their own user input handler and a chosen input checker
5. Each converter follows a process taught in class to convert the provided input to the desired output