import Dependencies._

ThisBuild / scalaVersion     := "2.12.3"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.njkol"
ThisBuild / organizationName := "njkol"

lazy val root = (project in file("."))
  .settings(
    name := "scala-creational-design-patterns",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
