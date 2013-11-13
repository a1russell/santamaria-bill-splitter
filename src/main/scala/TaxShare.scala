class TaxShare extends (BigDecimal => BigDecimal) {
  def apply(subtotalShare: BigDecimal): BigDecimal = {
    0
  }
}

object TaxShare {
  def apply(): TaxShare = new TaxShare
}
