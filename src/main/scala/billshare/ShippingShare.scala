package billshare

private[billshare] class ShippingShare extends ((Int, Int) => BigDecimal) {
  private val shippingRate = BigDecimal("20.00")

  def apply(numberOfWinesInShare: Int, totalNumberOfWines: Int): BigDecimal = {
    BigDecimal(numberOfWinesInShare) / BigDecimal(totalNumberOfWines) * shippingRate
  }
}

private[billshare] object ShippingShare {
  def apply(): ShippingShare = new ShippingShare
}
