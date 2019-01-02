package com.filipponi.genetic

import com.filipponi.genetic.CrossOver.crossover
import org.scalatest.{FlatSpec, Matchers}

class CrossOverTest extends FlatSpec with Matchers {

  "CrossOver" should "crossOver the genes of two chromosomes" in  {

    val fittest = Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)),None)
    val secondFittest = Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)),None)

    implicit val crossoverPointFunction: () => Int = () => 2

    val (fittestCrossover,secondFittestCrossOver) = crossover((fittest,secondFittest))

    fittestCrossover should be (Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)),Some(4)))
    secondFittestCrossOver should be (Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)),Some(5)))

  }

}
