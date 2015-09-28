name := "scala-spray-rest"

version := "1.0"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {

  Seq(
    "io.spray"            %%  "spray-can"     % "1.3.1",
    "io.spray"            %%  "spray-routing" % "1.3.1",
    "io.spray"            %%  "spray-json"    % "1.2.5",
    "com.typesafe.akka"   %%  "akka-actor"    % "2.3.0"
  )
}