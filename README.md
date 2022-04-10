# Simple_Tic-Tac-Toe
### The objectives of the project:
1. Prints an empty grid at the beginning of the game.
2. Creates a game loop where the program asks the user to enter the cell coordinates, analyzes the move for correctness and shows a grid with the changes if everything is okay.
3. Ends the game when someone wins or there is a draw.
```
---------
|       |
|       |
|       |
---------
Enter the coordinates: 1 1
---------
| X     |
|       |
|       |
---------
Enter the coordinates: 2 2
---------
| X     |
|   O   |
|       |
---------
Enter the coordinates: 3 3
---------
| X     |
|   O   |
|     X |
---------
Enter the coordinates: 0 2
Coordinates should be from 1 to 3!
Enter the coordinates: 1 3
---------
| X   O |
|   O   |
|     X |
---------
Enter the coordinates: 31
You should enter 2 numbers!
Enter the coordinates: 3 1
---------
| X   O |
|   O   |
| X   X |
---------
Enter the coordinates: 2 one
You should enter numbers!
Enter the coordinates: 2 1
---------
| X   O |
| O O   |
| X   X |
---------
Enter the coordinates: 2 1
This cell is occupied! Choose another one!
Enter the coordinates: 3 2
---------
| X   O |
| O O   |
| X X X |
---------
X wins
```
