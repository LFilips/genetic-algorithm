package com.filipponi.genetic

import com.filipponi.genetic.Fitness.fitnessFunction

object OffSpring {

  def calculateFittestOffSpring(fittestParent: (Chromosome, Chromosome)): Chromosome = {
    if (fitnessFunction(fittestParent._2) > fitnessFunction(fittestParent._1)) fittestParent._2 else fittestParent._1
  }


  def replaceLeastFitnessWithOffSpring(population: Population, offSpring: Chromosome): Population = {
    val leastFitnessChromosome = population.chromosomes.min
    population.copy(chromosomes = population.chromosomes.map(chromosome => if (chromosome == leastFitnessChromosome) offSpring else chromosome))
  }


}
