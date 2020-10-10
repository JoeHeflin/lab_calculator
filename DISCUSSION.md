# Lab Discussion
## Joseph Heflin, jnh24

### Original Code

 * What are possible errors that might occur when trying to evaluate a user entered arithmetic expression?
   - multiple spaces between number or operations
   - invalid string (operation not recognized)
   - operation but no numbers
   - numbers but no operation
   - invalid characters

 * What are possible appropriate responses to each issue (throw exception, return 0, assume default value, etc.)?
   - For too many spaces, ignore
   - For rest, throw exception

 * Why should you not use exceptions to handle "checkable" conditions?
   - Exceptions should only signal undesirable behavior in the program.

 * How is Reflection currently being used in the code?
   - line 24 of CalculatorView to set resource package
   - the toString method in Operation


### Refactored Code

* What was conceptually easy or hard about making these changes?

* What was technically easy or hard about making these changes

* How could these concepts be used to conceptually improve and clarify your project's design?

* How likely are you to implement these kinds of changes? Why or why not?

