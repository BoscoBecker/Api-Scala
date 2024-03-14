libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.6",
  "com.typesafe.akka" %% "akka-actor" % "2.6.17",
  "com.typesafe.akka" %% "akka-stream" % "2.6.17",
  "io.circe" %% "circe-core" % "0.14.1",
  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "9.4.1.jre11"

)
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.13"
lazy val root = (project in file("."))
  .settings(
    name := "Api"
  )
