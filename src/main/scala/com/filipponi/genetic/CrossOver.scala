package com.filipponi.genetic

import com.filipponi.genetic.Fitness.fitnessFunction

object CrossOver {

  def crossover(fittestParents: (Chromosome, Chromosome), crossOverPointCalculator: () => Int): (Chromosome, Chromosome) = {

    val fittest = fittestParents._1
    val secondFittest = fittestParents._2
    val crossOverPoint = crossOverPointCalculator()

    printf(s"""CrossOverPoint : $crossOverPoint """)

    val newFittestGenesSeq: Seq[Gene] = fittest.genes.zipWithIndex.foldRight(List.empty[Gene])((tuple, list) => {
      val index = tuple._2
      val currentGene = tuple._1
      if (index < crossOverPoint) secondFittest.genes(index) :: list else currentGene :: list
    }
    )

    val newSecondFittestGenesSeq: Seq[Gene] = secondFittest.genes.zipWithIndex.foldRight(List.empty[Gene])((tuple, list) => {
      val index = tuple._2
      val currentGene = tuple._1
      if (index < crossOverPoint) fittest.genes(index) :: list else currentGene :: list
    })

    val newFittestChromosome = fittest.copy(genes = newFittestGenesSeq)
    val newSecondFittestChromosome = secondFittest.copy(genes = newSecondFittestGenesSeq)

    //this is obscene, need to be better
    (newFittestChromosome.copy(fitness = Some(fitnessFunction(newFittestChromosome))), newSecondFittestChromosome.copy(fitness = Some(fitnessFunction(newSecondFittestChromosome))))
  }

}
