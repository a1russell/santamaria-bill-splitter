class BillShare extends (List[BigDecimal] => BigDecimal) {
  def apply(pricesOfSharesOfWines: List[BigDecimal]): BigDecimal = {
    BigDecimal("0")
  }
}

object BillShare {
  def apply(): BillShare = new BillShare
}