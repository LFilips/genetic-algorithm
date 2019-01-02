package com.filipponi.genetic

import scala.util.Random

case class Population(chromosomes: Seq[Chromosome])

case class Chromosome(genes: Seq[Gene], fitness: Option[Int])

case class Gene(value: Boolean) extends AnyVal

object Population {
  /**
    * Creates a random population
    *
    * @return the randomPopulation
    */
  def apply(chromosomesCount: Int, genes: Int): Population = {
    val rand = Random
    Population(List.fill(chromosomesCount)(Chromosome(List.fill(genes)(Gene(rand.nextBoolean())), None)))
  }

  def apply(chromosomes: Seq[Chromosome]): Population = new Population(chromosomes)

}