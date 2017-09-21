import sbt.Keys.version

val jsDir = "target"

lazy val root = (project in file("."))
  .settings(
    name := "scala-bundler-test",
    version := "0.1",
    scalaVersion := "2.12.3",
    scalaJSUseMainModuleInitializer := true,
    scalaJSUseMainModuleInitializer in Test := false,
    artifactPath in(Compile, fastOptJS) := file("target/app.js"),
    artifactPath in(Compile, packageJSDependencies) := file("target/app.dep.js"),
    artifactPath in(Compile, packageMinifiedJSDependencies) := file("target/deps.min.js"),
    artifactPath in(Test, fastOptJS) := file("target/app.test.js"),
    artifactPath in(Test, fullOptJS) := file("target/app.min.test.js"),
    artifactPath in(Test, packageJSDependencies) := file("target/deps.test.js"),
    artifactPath in(Test, packageMinifiedJSDependencies) := file("target/deps.min.test.js"),
    libraryDependencies ++= Seq(
      "be.doeraene" %%% "scalajs-jquery" % "0.9.2",
      "com.github.japgolly.scalajs-react" %%% "core" % "1.1.0",
      "com.github.japgolly.scalajs-react" %%% "extra" % "1.1.0",
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "com.olvind" %%% "scalajs-react-components" % "0.8.0")
    /*,npmDevDependencies in Compile += "expose-loader" -> "0.7.1",
    webpackConfigFile := Some(baseDirectory.value / "webpack.config.js"),
    npmDependencies in Compile ++= Seq(
      "jquery" -> "2.1.3",
      "react" -> "15.6.1",
      "react-dom" -> "15.6.1",
      "material-ui" -> "0.19.2"
    )*/
  )
  .enablePlugins(ScalaJSPlugin)
//.enablePlugins(ScalaJSBundlerPlugin)



