package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}
import com.filipponi.genetic.Fitness.fitnessFunction

class FitnessTest extends FlatSpec with Matchers {

  "Fitness" should "have the right fitness function" in {

    fitnessFunction(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true))) should be(5)
    fitnessFunction(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true))) should be(4)
    fitnessFunction(List(Gene(false), Gene(false), Gene(true), Gene(true), Gene(true))) should be(3)
    fitnessFunction(List(Gene(false), Gene(false), Gene(false), Gene(true), Gene(true))) should be(2)
    fitnessFunction(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(true))) should be(1)
    fitnessFunction(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(false))) should be(0)

  }

}
