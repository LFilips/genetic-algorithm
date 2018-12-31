# genetic-algorithm

Example of using a genetic algorithm to find a sequence of boolean that will maximise the fitness function. Despite is a simple example shows how with genetic algorithm we can achieve a fast result where brute force will be too slow.

Lots of things need to be refactored and the code is a bit naive, but works.

The default is a population of 500 chromosome of 500 genes. Any chromosome is composed by 500 boolean genes. The fitness function will be the sum of the true of the genes. So to fittest genes will be composed only by 1.

## How to run

``sbt run`