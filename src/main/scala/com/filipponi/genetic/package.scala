package com.filipponi

package object genetic {

  implicit val chromosomeOrdering: Ordering[Chromosome] = (x: Chromosome, y: Chromosome) => {
    x match {
      case Chromosome(_, Some(xValue)) => y.fitness match {
        case None => 1
        case Some(yValue) => xValue - yValue
      }
      case Chromosome(_, None) => -1
    }
  }

}
