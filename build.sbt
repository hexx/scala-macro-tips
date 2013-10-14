val buildSettings = Defaults.defaultSettings ++ Seq(
  organization := "com.github.hexx",
  scalaVersion := "2.10.3",
  scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-language:_"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  addCompilerPlugin("org.scala-lang.plugins" % "macro-paradise" % "2.0.0-SNAPSHOT" cross CrossVersion.full)
)

lazy val root = project in file(".") settings(
  buildSettings ++ Seq(
  ): _*
) dependsOn macros

lazy val macros = project.settings(
  buildSettings ++ Seq(
    libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
  ): _*
)
