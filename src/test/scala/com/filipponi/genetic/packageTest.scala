package com.filipponi.genetic

import org.scalatest.{FlatSpec, Matchers}

class packageTest extends FlatSpec with Matchers {

  "package object" should "provide a valid ordering for chromosomes" in {

    chromosomeOrdering.compare(Chromosome(List(),Some(1)),Chromosome(List(),Some(2))) should be (-1)
    chromosomeOrdering.compare(Chromosome(List(),Some(3)),Chromosome(List(),Some(2))) should be (1)
    chromosomeOrdering.compare(Chromosome(List(),Some(0)),Chromosome(List(),Some(0))) should be (0)

  }

}
