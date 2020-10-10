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
   
   
   ### Issues
     - Not recognizing resource bundle error, not sure how to fix


### Refactored Code

* What was conceptually easy or hard about making these changes?
  - Thinking about where to place the 
* What was technically easy or hard about making these changes?
   - Using new syntaxes.
* How could these concepts be used to conceptually improve and clarify your project's design?
  - I'm not sure about the current simulation project but the last game project we could've eliminated the conditionals 
  that instantiated different kinds of power-ups by using reflection.
* How likely are you to implement these kinds of changes? Why or why not?
  - Very likely, I like short and intuitive code that's easy to use. Reflection further increases my ability  to
  maintain the open closed principle and will make updates significantly easier.

