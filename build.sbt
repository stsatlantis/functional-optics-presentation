name := "functional-optics-workshop"

version := "0.1"
val monocleVersion = "1.5.0"
val catsVersion = "1.5.0"

scalaVersion := "2.12.8"
libraryDependencies ++= Seq(
  "com.github.julien-truffaut" %% "monocle-core" % monocleVersion,
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)