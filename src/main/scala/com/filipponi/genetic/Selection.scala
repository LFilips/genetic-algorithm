package com.filipponi.genetic

object Selection {

  //todo don't use the sorting but rather manually get the two element in O(n)
  def selection(population: Population)(implicit chromosomeOrdering: Ordering[Chromosome]): (Chromosome, Chromosome) = {
    val sortedPopulation = population.chromosomes.sortBy(chromosome => chromosome.fitness match {
      case Some(value) => - value
      case None => 1
    })
    (sortedPopulation.head, sortedPopulation(1))
  }
}
