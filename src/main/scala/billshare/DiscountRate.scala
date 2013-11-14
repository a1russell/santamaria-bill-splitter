package billshare

private[billshare] class DiscountRate extends (Int => BigDecimal) {
  def apply(totalNumberOfWines: Int): BigDecimal = throw new NotImplementedError
}
