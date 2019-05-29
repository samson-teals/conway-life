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

This method returns a `boolean`. Return `true` if the cell is "alive".

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

Alternatively, another way to keep track of a _next_ state separate from the _current_ state is to have a 2D array of objects that can keep track of both the _current_ and _next_ states.

## Experiments

- Can you modify the rules to create interesting new behaviour?
- What can you do if you use a 2D array of e.g. `int` instead of `boolean`? Can you use that to keep track of another attribute of each cell, e.g. the age of the cell?

# Getting started with IntelliJ

- Start IntelliJ
- Select source files using one of the following methods:
    - Using a `zip` download from github
      - `Download ZIP` from the green `Clone or download` button above
      - Unzip the file, maintaining the folder structure, e.g. into `H:`
      - From the welcome dialog, select "Import Project"
        - Import the project from the location where you unzipped the file
    - Using `Git` version control (this currently does not work)
      - From the welcome dialog, select "Check out form Version Control"
        - Select "Git" from the dropdown
      - Copy and paste in the url: `git@github.com:samson-teals/conway-life.git`
        - Optionally choose a target directory
        - Click "Clone"
- Click "Yes" when IntelliJ asks if you would like to create an IntelliJ project from sources
  - Choose "Create project from existing sources"
  - Click "Next"
  - Optionally modify the project name or location
  - Click "Next" again
  - Accept the checked off source location
  - You may be asked to select a JDK; a JDK is necessary to do any JAVA development
    - Click on the `+` and add a new JDK
    - Select any available JDK: BlueJ comes with one
      - BlueJ's JDK may be located at `C:\Program Files (x86)\BlueJ\jdk`
  - Click "Next" until you can click "Finish"
- IntelliJ should have created a starter project for you.
To run it, navigate to `src/life/Main` and find `public static void main()` near the bottom of the file
  - If everything works, you should see a green arrow to the left of `public static void main()` which you can click to `Run 'Main.main()'`
  - Let IntelliJ compile what it needs to, and you should see a new window with a sweeping crosshairs animation.

# Getting started with BlueJ

- `Download ZIP` from the green `Clone or download` button above
- Start BlueJ
- Open ZIP/JAR from the `Project` menu
  - BlueJ will warn you about not being at the top level, but it is ok
- You should be able to run `Main`.`main()` as usual and you should see a new window with a sweeping crosshairs animation.
