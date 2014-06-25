name := "whai"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.akka23-SNAPSHOT"

libraryDependencies += "ws.securesocial" % "securesocial_2.10" % "2.1.3"
