package com.filipponi.genetic

import com.filipponi.genetic.CrossOver.crossover
import com.filipponi.genetic.Fitness.calculateFitness
import com.filipponi.genetic.Mutation.mutation
import com.filipponi.genetic.OffSpring.{calculateFittestOffSpring, replaceLeastFitnessWithOffSpring}
import com.filipponi.genetic.Population.GENES_IN_CHROMOSOME
import com.filipponi.genetic.Selection.selection

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

  var population = computedFitnessPopulation
  var iteration = 0


  //since of the bad model i have to use the get at this point, the option was not a great idea
  while (population.chromosomes.max.fitness.get < GENES_IN_CHROMOSOME) {

    calculateFitness(population)

    val fittestParents = selection(population)
    printf(s"""Running iteration $iteration, fittest: ${fittestParents._1.fitness}, secondFittest: ${fittestParents._2.fitness} """)

    val crossedOver = crossover(fittestParents,randomGenerator)

    val mutated = mutation(crossedOver,randomGenerator)

    val offSpring = calculateFittestOffSpring(mutated)

    printf(s"""Offspring ${offSpring.fitness}""")

    println()

    val newPopulation = replaceLeastFitnessWithOffSpring(population, offSpring)

    population = newPopulation
    iteration = iteration + 1


  }



}
