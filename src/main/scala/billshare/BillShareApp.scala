package billshare

import scala.language.postfixOps
import org.rogach.scallop.ScallopConf

object BillShareApp extends App with Context {

  class CommandLineInterface(arguments: Seq[String]) extends ScallopConf(arguments) {
    val total = opt[Int](required = true, validate = 0<)
    val pricesOfShareOfWines = trailArg[List[Double]](required = true)
  }

  val cli = new CommandLineInterface(args)
  val pricesOfShareOfWines = cli.pricesOfShareOfWines().map(BigDecimal.apply)

  println(billShare(pricesOfShareOfWines, cli.total()))
}
