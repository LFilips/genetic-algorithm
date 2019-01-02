package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}

class PopulationTest extends FlatSpec with Matchers {

  "Pupulation" should "create a random population with the empty apply method" in {

    //There is no simple way to test the random population
    val randomPopulation = Population(5,5)
    randomPopulation should not be null
    randomPopulation.chromosomes should not be null
    randomPopulation.chromosomes.foreach(_.genes should not be null)

    //there is a low probability but this test can actually fail if two random generations are creating the same
    //population. //todo think of a good way to test this
    val randomPopulation2 = Population(5,5)
    randomPopulation should not be randomPopulation2

  }

}