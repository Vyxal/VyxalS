//TODO (user/cgccuser): clean this file up
// enablePlugins(ScalaJSPlugin)

//The version of Scala we use
val scalaversion = "3.1.0"

ThisBuild / scalaVersion := scalaversion

//Automatically reload SBT when build.sbt changes
Global / onChangedBuildSource := ReloadOnSourceChanges
//Set main class

//Use ("com.foo" % "bar.baz" % version).cross(CrossVersion.for3Use2_13)
//if needed

//Use compile to just compile when testing on your computer
//Use vyxalJVM/run to actually run the JVMMain class

//Use fastLinkJS to quickly link JS, and fullLinkJS when releasing
//Use vyxalJS/run to run the JSMain class

lazy val root = project.in(file(".")).
  aggregate(vyxal.js, vyxal.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val vyxal = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "vyxal",
    version := "0.1-SNAPSHOT",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
  ).
  jvmSettings(
    // Add JVM-specific settings here
    Compile / mainClass := Some("vyxal.JVMMain")
  ).
  jsSettings(
    // Add JS-specific settings here
    Compile / mainClass := Some("vyxal.JSMain"),
    scalaJSUseMainModuleInitializer := true,
  )
