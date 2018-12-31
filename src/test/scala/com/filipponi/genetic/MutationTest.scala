package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}
import com.filipponi.genetic.Mutation.mutation

class MutationTest extends FlatSpec with Matchers {

  "Mutation" should "mutate genes in the chromosomes" in {

    val fittest = Chromosome(List(Gene(true), Gene(true), Gene(true), Gene(true), Gene(true)),None)
    val secondFittest = Chromosome(List(Gene(false), Gene(true), Gene(true), Gene(true), Gene(true)),None)

    val (fittestMutated,secondFittestMutated) = mutation((fittest,secondFittest),() => 2)

    fittestMutated should be (Chromosome(List(Gene(true), Gene(true), Gene(false), Gene(true), Gene(true)),None))
    secondFittestMutated should be (Chromosome(List(Gene(false), Gene(true), Gene(false), Gene(true), Gene(true)),None))

  }

}
