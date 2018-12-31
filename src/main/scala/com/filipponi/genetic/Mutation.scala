package com.filipponi.genetic

import com.filipponi.genetic.Fitness.fitnessFunction

object Mutation {

  def mutation(fittestParents: (Chromosome, Chromosome),mutationPointCalculator: () => Int): (Chromosome, Chromosome) = {

    val fittest = fittestParents._1
    val secondFittest = fittestParents._2
    val firstMutationPoint = mutationPointCalculator()

    val mutatedFittest = fittest.copy(genes = fittest.genes.zipWithIndex map {
      case (gene: Gene, index: Int) => {
        if (index == firstMutationPoint) Gene(!gene.value) else gene
      }
    }
    )

    val secondMutationPoint = mutationPointCalculator()

    printf(s"""FirstMutationPoint : $firstMutationPoint, SecondMutationPoint : $secondMutationPoint """)

    val mutatedSecondFittest = secondFittest.copy(genes = secondFittest.genes.zipWithIndex map {
      case (gene: Gene, index: Int) => {
        if (index == secondMutationPoint) Gene(!gene.value) else gene
      }
    }
    )

    //this is obscene, the model for the fitness value need to be improved
    (mutatedFittest.copy(fitness = Some(fitnessFunction(mutatedFittest))), mutatedSecondFittest.copy(fitness = Some(fitnessFunction(mutatedSecondFittest))))

  }

}
