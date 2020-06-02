name := "playopenhtmltopdf"

version := "1.0"

lazy val `playopenhtmltopdf` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq( guice )

libraryDependencies += "com.openhtmltopdf" % "openhtmltopdf-pdfbox" % "1.0.3"
libraryDependencies += "com.openhtmltopdf" % "openhtmltopdf-svg-support" % "1.0.3"

libraryDependencies += "io.nayuki" % "qrcodegen" % "1.6.0"

