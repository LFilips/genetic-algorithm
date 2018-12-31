package com.filipponi.genetic

import scala.util.Random

case class Population(chromosomes: Seq[Chromosome])

//todo maybe can define a super class and have a specialization for when the fitness value is computed instead of option?
case class Chromosome(genes: Seq[Gene],fitness: Option[Int])

case class Gene(value: Boolean) extends AnyVal

object Population{

  val GENES_IN_CHROMOSOME = 1000

  /**
    * Creates a random population
    * @return the randomPopulation
    */
  def apply(): Population = {

    val rand = Random

    Population(List.fill(GENES_IN_CHROMOSOME)(Chromosome(List.fill(GENES_IN_CHROMOSOME)(Gene(rand.nextBoolean())),None)))

  }

  def apply(chromosomes: Seq[Chromosome]): Population = new Population(chromosomes)

}