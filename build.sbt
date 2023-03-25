ThisBuild / tlBaseVersion := "0.0"

ThisBuild / organization := "com.armanbilge"
ThisBuild / organizationName := "Arman Bilge"
ThisBuild / startYear := Some(2023)
ThisBuild / developers := List(
  tlGitHubDev("armanbilge", "Arman Bilge"),
)

ThisBuild / tlSonatypeUseLegacyHost := false

ThisBuild / crossScalaVersions := Seq("3.2.2")
ThisBuild / scalacOptions ++= Seq("-new-syntax", "-indent", "-source:future")

ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("17"))
ThisBuild / tlJdkRelease := Some(8)

val CalicoVersion = "0.2.0-M2"

lazy val root = tlCrossRootProject.aggregate(material, sandbox)

lazy val material = project
  .in(file("material"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "calico-material",
    libraryDependencies ++= Seq(
      "com.armanbilge" %%% "calico" % CalicoVersion,
    ),
  )

lazy val sandbox = project
  .in(file("sandbox"))
  .enablePlugins(ScalaJSPlugin, ScalaJSImportMapPlugin, NoPublishPlugin)
  .dependsOn(material)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    Compile / scalaJSImportMap := { (s: String) =>
      if (s.startsWith("@material/web"))
        "https://cdn.jsdelivr.net/npm/" + s + "/+esm"
      else
        s
    },
    Compile / fastLinkJS / scalaJSLinkerConfig ~= {
      import org.scalajs.linker.interface.ModuleSplitStyle
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("calico.material")))
    },
  )
