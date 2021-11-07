val scala3Version = "3.1.0"

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .settings(
    name := "vyxals",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  ).jsSettings(

  ).jvmSettings(

  )
