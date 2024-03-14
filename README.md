


![image](https://github.com/BoscoBecker/Api-Scala/assets/6303278/c4ecd07c-793a-466f-a36e-c802b0893ef4)


API Made in Scala 2.13
Realizando conexão com banco de dados SQL Server

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
