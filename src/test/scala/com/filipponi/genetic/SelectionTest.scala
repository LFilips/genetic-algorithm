package com.filipponi.genetic

import com.filipponi.genetic.Selection.selection
import com.filipponi.genetic.Fitness.calculateFitness
import org.scalatest.{FlatSpec, Matchers}

class SelectionTest extends FlatSpec with Matchers {

  it should "select the fittest individual from the population" in {

    val population = Population(List(
      Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(true), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(true), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(true)), None),
      Chromosome(List(Gene(false), Gene(false), Gene(false), Gene(false), Gene(false)), None)))

    val (fittest,secondFittest) = selection(calculateFitness(population))

    fittest should be (Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)), Some(5)))
    secondFittest should be (Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)), Some(4)))

  }

}
