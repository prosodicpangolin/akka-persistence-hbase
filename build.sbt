organization := "pl.project13.scala"

name := "akka-persistence-hbase"

version := "0.2-SNAPSHOT"

scalaVersion := "2.10.2"


libraryDependencies += "org.apache.hadoop" % "hadoop-core"   % "1.1.2"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "1.1.2"

libraryDependencies += "org.apache.hbase"  % "hbase"         % "0.94.6.1"

libraryDependencies += "org.hbase"         % "asynchbase"    % "1.4.1"

libraryDependencies +=  "com.jsuereth" %% "scala-arm" % "1.3"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence-experimental" % "2.3-M2" % "compile"


libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.3-M2" % "test"

libraryDependencies += "org.scalatest"     %% "scalatest"    % "2.0" % "test"


// publishing settings

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials(Path.userHome / ".sbt" / "sonatype.properties")

pomExtra := (
<url>http://github.com/ktoso/akka-persistence-hbase</url>
<licenses>
  <license>
    <name>Apache 2 License</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
    <distribution>repo</distribution>
  </license>
</licenses>
<scm>
  <url>git@github.com:ktoso/akka-persistence-hbase.git</url>
  <connection>scm:git:git@github.com:ktoso/akka-persistence-hbase.git</connection>
</scm>
<developers>
  <developer>
    <id>ktoso</id>
    <name>Konrad 'ktoso' Malawski</name>
    <url>http://blog.project13.pl</url>
  </developer>
</developers>
<parent>
  <groupId>org.sonatype.oss</groupId>
  <artifactId>oss-parent</artifactId>
  <version>7</version>
</parent>)