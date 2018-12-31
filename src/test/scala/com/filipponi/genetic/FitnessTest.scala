package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}
import com.filipponi.genetic.Fitness.fitnessFunction

class FitnessTest extends FlatSpec with Matchers {

  "Fitness" should "have the right fitness function" in {

    fitnessFunction(Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), None)) should be(5)
    fitnessFunction(Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), None)) should be(4)
    fitnessFunction(Chromosome(List(Gene(false), Gene(false), Gene(true), Gene(true), Gene(true)), None)) should be(3)
    fitnessFunction(Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(true), Gene(true)), None)) should be(2)
    fitnessFunction(Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(true)), None)) should be(1)
    fitnessFunction(Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(false)), None)) should be(0)

  }

}
