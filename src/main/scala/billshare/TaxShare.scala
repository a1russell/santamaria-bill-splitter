package billshare

class TaxShare extends (BigDecimal => BigDecimal) {
  private val taxRate = BigDecimal("0.0675")

  def apply(subtotalShare: BigDecimal): BigDecimal = {
    subtotalShare * taxRate
  }
}

object TaxShare {
  def apply(): TaxShare = new TaxShare
}
