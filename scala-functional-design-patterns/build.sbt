import Dependencies._

ThisBuild / scalaVersion     := "2.12.3"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.njkol"
ThisBuild / organizationName := "njkol"

lazy val root = (project in file("."))
  .settings(
    name := "scala-functional-design-patterns",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "commons-codec" % "commons-codec" % "1.9"           
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
