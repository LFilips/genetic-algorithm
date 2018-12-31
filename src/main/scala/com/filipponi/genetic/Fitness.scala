package com.filipponi.genetic

object Fitness {

  val fitnessFunction: Chromosome => Int = (chromosome:Chromosome) => {
    chromosome.genes.foldLeft(0)((a,b) => a + (if (b.value) 1 else  0))
  }

  def calculateFitness(population: Population) : Population = {
    Population(population.chromosomes.map(chromosome => chromosome.copy(fitness = Some(fitnessFunction(chromosome)))))
  }

}
