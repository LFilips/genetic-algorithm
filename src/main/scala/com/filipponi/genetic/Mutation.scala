package com.filipponi.genetic

import com.filipponi.genetic.Fitness.fitnessFunction

object Mutation {

  def mutation(fittestParents: (Chromosome, Chromosome))(implicit mutationPointCalculator: () => Int): (Chromosome, Chromosome) = {

    val fittest = fittestParents._1
    val secondFittest = fittestParents._2

    val firstMutationPoint = mutationPointCalculator()
    val secondMutationPoint = mutationPointCalculator()

    printf(s"""FirstMutationPoint : $firstMutationPoint, SecondMutationPoint : $secondMutationPoint """)

    (mutateChromosome(fittest,firstMutationPoint),mutateChromosome(secondFittest,firstMutationPoint))

  }

  private def mutateChromosome(chromosome: Chromosome,mutationPoint: Int) = {

    val geneSequence = chromosome.genes.zipWithIndex map {
      case (gene: Gene, index: Int) =>
        if (index == mutationPoint) Gene(!gene.value) else gene
    }
    Chromosome(geneSequence,Some(fitnessFunction(geneSequence)))
  }

}
