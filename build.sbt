//TODO (user/cgccuser): clean this file up
// enablePlugins(ScalaJSPlugin)

//The version of Scala we use
val scalaversion = "3.1.1"

ThisBuild / scalaVersion := scalaversion

//Automatically reload SBT when build.sbt changes
Global / onChangedBuildSource := ReloadOnSourceChanges

Test / testOptions += Tests.Argument("-oN")

/*
Use ("com.foo" % "bar.baz" % version).cross(CrossVersion.for3Use2_13)
if needed

Use compile to just compile when testing on your computer
Use vyxalJVM/run to actually run the JVMMain class

Use fastOptJS to quickly link JS, and fullOptJS when releasing
Use vyxalJS/run to run the JSMain class (you will need Node.JS for this)
 */

import org.scalajs.linker.interface.OutputPatterns

lazy val root = project
  .in(file("."))
  .aggregate(vyxal.js, vyxal.jvm)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val vyxal = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name := "vyxal",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.2.10" % Test,
      ("org.typelevel" %%% "spire" % "0.17.0").cross(CrossVersion.for3Use2_13)
    ),
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-encoding",
      "utf-8", // Specify character encoding used by source files.
      // "-explain-types",                    // Explain type errors in more detail.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      // Above options from https://tpolecat.github.io/2017/04/25/scalac-flags.html
      "-language:implicitConversions",
      // "-explain",
      "-print-lines",
      "-Ycheck-all-patmat"
    )
  )
  .jvmSettings(
    // Add JVM-specific settings here
    Compile / mainClass := Some("vyxal.JVMMain")
  )
  .jsSettings(
    // Add JS-specific settings here
    Compile / mainClass := Some("vyxal.Main"),
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.2.0",
      "com.lihaoyi" %%% "scalatags" % "0.11.1",
    ),
    Compile / fastOptJS / artifactPath := baseDirectory.value / "lib" / "main.js",
    Compile / fullOptJS / artifactPath := baseDirectory.value / "lib" / "main.js"
  )

val genElements = taskKey[Unit]("genElements")
genElements := GenElements.run()
