# Vyxal in Scala

This repository is where we're going to experiment with rewriting the golfing language [Vyxal](https://github.com/Vyxal/Vyxal) in Scala.

## Setting everything up

### Stuff to run and build Scala

- Java - Since Scala runs on the JVM, you'll have to install Java first. There are different distributions and stuff, but I think the best choice would be OpenJDK 17, which you can get [here](https://jdk.java.net/17/).
- sbt - After that, you can install sbt using the instructions [here](https://www.scala-sbt.org/download.html). sbt lets you build Scala projects so you can actually run them, so it's kinda like Poetry. It's also got a REPL in case you don't have Scala installed on your computer.

### Editors

- If you were using VS Code for Vyxal and want to continue using that, there's the [Metals](https://scalameta.org/metals/docs/editors/vscode/) extension. You can also use Metals with Sublime Text and Vim.
- IntelliJ also has an [official Scala plugin](https://plugins.jetbrains.com/plugin/1347-scala) if you want that, though I personally prefer VS Code + Metals.

## Running stuff

If you want to just run a single command with sbt (e.g. run tests once), you can run `sbt test` directly. Otherwise, if you're going to run and test stuff multiple times, just run `sbt`, and that drops you into a shell where you can run `> test`, `> build`, etc. The second approach is preferred if you're going to run multiple commands because sbt is very slow to load and you don't want it to load every time you want to build and run tests. If you want to run the JVM version of Vyxal locally from our code, run `sbt vyxalJVM/run`. If you have Node installed, you can also do `vyxalJS/run`.

If you want to run the compiled jar, you can do `java -jar nameofbuiltvyxaljar.jar`. We might want to write a script to "install" the jar or something, although the online interpreter will probably be preferred by most.
