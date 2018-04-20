# Tic Tac Toe
Refactoring two player Tic Tac Toe game for production readiness. Below is points considered when code is refactored.

## What is production readiness?
* it satisfies the project requirements
* it's design was well thought out
* it's extendable
* it's maintainable
* it's scalable
* it's documented
* it's tested

## How to refactor for above requirements?
* Separation of responsibility (extendable, readable, testable)
* Use Interface to enforce design and requirements (testable, readable)
* Use Dependency Injection (testable, extendable)
* Know when to use composition and inheritance

## Steps
1. Identify the components (player, board, game, runner, view)
2. Separate out each components to its own module, abstract the behavior into an interface
3. Always reference interface from the using code to decouple implementation details
4. Transfer the implementation details by implementing the interface
5. Make sure all the behaviors are tested



