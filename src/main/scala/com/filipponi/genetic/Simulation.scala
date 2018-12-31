package com.filipponi.genetic

import com.filipponi.genetic.Fitness.calculateFitness
import com.filipponi.genetic.Mutation.mutation
import com.filipponi.genetic.OffSpring.{calculateFittestOffSpring, replaceLeastFitnessWithOffSpring}
import com.filipponi.genetic.Population.GENES_IN_CHROMOSOME
import com.filipponi.genetic.Selection.selection
import com.filipponi.genetic.CrossOver.crossover

import scala.annotation.tailrec
import scala.util.Random

object Simulation extends App {

  println("Running the simulation")

  val startingPopulation = Population()

  val chromosomeSize = startingPopulation.chromosomes.length

  println("Starting population")

  val computedFitnessPopulation: Population = calculateFitness(startingPopulation)

  val random = new Random()

  val randomGenerator: () => Int = {
    () => random.nextInt(chromosomeSize)
  }

  runIteration(computedFitnessPopulation,0)

  @tailrec
  def runIteration(population: Population,iteration: Int) : Population = {
    if(population.chromosomes.max.fitness.get == GENES_IN_CHROMOSOME) population
    else {
      calculateFitness(population)

      val fittestParents = selection(population)
      printf(s"""Running iteration $iteration, fittest: ${fittestParents._1.fitness}, secondFittest: ${fittestParents._2.fitness} """)

      val crossedOver = crossover(fittestParents, randomGenerator)

      val mutated = mutation(crossedOver, randomGenerator)

      val offSpring = calculateFittestOffSpring(mutated)

      printf(s"""Offspring ${offSpring.fitness}""")

      println()

      val newPopulation = replaceLeastFitnessWithOffSpring(population, offSpring)
      runIteration(newPopulation,iteration+1)
    }

  }

}
