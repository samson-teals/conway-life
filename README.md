# Starter files for Conway's Game of Life

The `Main` class itself isn't supposed to be interesting: it only hosts a simple `Canvas` that we can draw on to.
Classes that implement the `LifeGrid` interface can be used in the `Main` class.

The `Main` class then draws data from  `LifeGrid` classes on to a grid.
Feel free to modify `Main`.
For example, you may way to change the painted cell colour from `RED` to something else, or change the background color from `WHITE` to `BLACK`.

# Conway's Game of Life

From Wikipedia: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

The rules are as follows:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## What to do

Create a copy of `Sweep.java` and modify the following methods:
- isAlive
- init
- iterate

`SweepBounce.java` is an example of how to modify `Sweep.java` to implement different behaviour.
You can play with `SweepBounce.java` in place of `Sweep.java` just be replacing `Sweep` with `SweepBounce` in the `Main` class' `main` method.

Eventually, you will replace `Sweep` (or `SweepBounce`) with your own class that implements the game.

### isAlive

`Main` uses `isAlive` to determine whether to paint a cell or not.
Only cells that are alive are painted.
Specifically, `Main`'s `GridCanvas`.`paintGrid` method uses `isAlive`.

### init

`Main`'s `main` method is set up to call a `LifeGrid` class' `init` method after it is created.
You may call it yourself in your constructor too, but having a separate `init` allows us to call it anytime we want.

### iterate

This method is where you can update the state of the grid data.
`Main` will call `iterate` once every period (where the period is derived from the `Main` constructor's `framesPerSecond` parameter).

`Main` then schedules a repaint of the canvas after the call to `iterate`.
This allows us to animate the game.

## Hints

You may want to create two 2D arrays of type `boolean` to implement the rules.
Remember that the _next_ iteration of the grid is generated from the _current_ iteration.
If you only have one 2D array, it might be more difficult to keep track of the _current_ state while you are calculating the _next_ state.

## Experiments

- Can you modify the rules to create interesting new behaviour?
- What can you do if you use a 2D array of e.g. `int` instead of `boolean`? Can you use that to keep track of another attribute of each cell, e.g. the age of the cell?
