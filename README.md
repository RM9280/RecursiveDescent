This project demonstrates a recursive descent parser implemented in Java.
The parser recognizes a very simple expression grammar consisting of integer literals (int) combined with the addition operator (+).

The program demonstrates:

How recursive descent parsing works,
How grammars are translated into parsing functions,
How token streams are consumed and backtracked

Grammer:

P  → E

E  → T E'

E' → + T E' | ε

T  → int
