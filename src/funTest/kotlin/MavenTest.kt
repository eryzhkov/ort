package com.here.provenanceanalyzer.functionaltest

import com.here.provenanceanalyzer.managers.Maven

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

import java.io.File

class MavenTest : StringSpec() {
    init {
        "computed dependencies are correct" {
            val expectedDependencies = File(
                    "src/funTest/assets/projects/external/jgnash-expected-maven-dependencies.txt").readLines()
            val resolvedDependencies = Maven.resolveDependencies(listOf(File("projects/external/jgnash/pom.xml")))

            resolvedDependencies shouldBe expectedDependencies
        }.config(enabled = false)
    }
}
