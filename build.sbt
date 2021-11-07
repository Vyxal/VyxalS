enablePlugins(ScalaJSPlugin)

//The version of Scala we use
val scalaversion = "3.1.0"

name := "vyxals"
version := "0.1.0"
scalaVersion := scalaversion

//Automatically reload SBT when build.sbt changes
Global / onChangedBuildSource := ReloadOnSourceChanges
//Set main class
Compile / mainClass := Some("vyxal.Main")
scalaJSUseMainModuleInitializer := true

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

//Use ("com.foo" % "bar.baz" % version).cross(CrossVersion.for3Use2_13)
//if needed

//Use fastLinkJS to quickly link JS, and fullLinkJS when releasing