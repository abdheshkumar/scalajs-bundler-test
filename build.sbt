import sbt.Keys.version

lazy val root = (project in file("."))
  .settings(
    name := "scala-bundler-test",
    version := "0.1",
    scalaVersion := "2.12.3",
    scalaJSUseMainModuleInitializer := true,
    scalaJSUseMainModuleInitializer in Test := false,
    /*crossTarget in(Compile, fullOptJS) := file("demo/assets"),
    crossTarget in(Compile, fastOptJS) := file("demo/assets"),
    //      crossTarget in (Compile, packageLauncher) := file(jsDir),
    artifactPath in(Compile, fastOptJS) := ((crossTarget in(Compile, fastOptJS)).value /
      ((moduleName in fastOptJS).value + "-opt.js")),*/
    webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack.config.js"),
    libraryDependencies ++= Seq(
      //"be.doeraene" %%% "scalajs-jquery" % "0.9.2",
      "com.github.japgolly.scalajs-react" %%% "core" % "1.1.0",
      "com.github.japgolly.scalajs-react" %%% "extra" % "1.1.0",
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "com.olvind" %%% "scalajs-react-components" % "0.8.0"),
    npmDependencies in Compile ++= Seq(
      //"jquery" -> "2.1.3",
      "react" -> "15.6.1",
      "react-dom" -> "15.6.1",
      "material-ui" -> "0.19.2"
    )
  )
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)



