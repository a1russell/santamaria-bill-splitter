package billshare

private[billshare] class DiscountRate extends (Int => BigDecimal) {
  def apply(totalNumberOfWines: Int): BigDecimal = BigDecimal("0.05")
}

private[billshare] object DiscountRate {
  def apply(): DiscountRate = new DiscountRate
}
