package com.filipponi.genetic

import com.filipponi.genetic.Fitness.fitnessFunction

object CrossOver {

  def crossover(fittestParents: (Chromosome, Chromosome))(implicit crossOverPointCalculator: () => Int): (Chromosome, Chromosome) = {

    val fittest = fittestParents._1
    val secondFittest = fittestParents._2
    val crossOverPoint = crossOverPointCalculator()

    printf(s"""CrossOverPoint : $crossOverPoint """)

    //this is obscene, need to be better
    (crossOverChromosomes(fittest,secondFittest,crossOverPoint),crossOverChromosomes(secondFittest,fittest,crossOverPoint))
  }

  def crossOverChromosomes(a: Chromosome,b: Chromosome, crossOverPoint: Int): Chromosome = {

    val crossOverGenes = a.genes.zipWithIndex.foldRight(List.empty[Gene])((tuple, list) => {
      val index = tuple._2
      val currentGene = tuple._1
      if (index < crossOverPoint) b.genes(index) :: list else currentGene :: list
    })

    Chromosome(crossOverGenes,Some(fitnessFunction(crossOverGenes)))
  }

}
