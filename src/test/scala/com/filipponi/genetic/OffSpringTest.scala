package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}
import com.filipponi.genetic.OffSpring.{calculateFittestOffSpring, replaceLeastFitnessWithOffSpring}

class OffSpringTest extends FlatSpec with Matchers {

  "OffSpring" should "calculate the fittest offSpring between to parents" in {
    val fittest = Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), None)
    val secondFittest = Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), None)

    calculateFittestOffSpring(fittest, secondFittest) should be(fittest)

  }

  it should "replace the leastFitnessElement with the new offSpring" in {

    val population = Population(List(
      Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(false)), None)))

    val fitnessPopulation = Fitness.calculateFitness(population)

    val offSpring = Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), Some(5))

    val newPopulation = Population(List(
      Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), Some(5)),
      Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), Some(4)),
      Chromosome(List(Gene(false), Gene(false), Gene(true), Gene(true), Gene(true)), Some(3)),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(true), Gene(true)), Some(2)),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(true)), Some(1)),
      offSpring))

    replaceLeastFitnessWithOffSpring(fitnessPopulation, offSpring) should be(newPopulation)
  }

}
