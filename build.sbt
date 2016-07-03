scalaVersion := "2.11.8"

resolvers ++= Seq(
  DefaultMavenRepository,
  Resolver.bintrayRepo("scalaz", "releases")
)

libraryDependencies ++= Seq(
  "org.rogach" %% "scallop" % "0.9.+",
  "junit" % "junit" % "4.+" % "test",
  "org.scalatest" %% "scalatest" % "2.2.+" % "test",
  "org.mockito" % "mockito-all" % "1.10.+" % "test"
)
