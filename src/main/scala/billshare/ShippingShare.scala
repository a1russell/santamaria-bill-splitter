package billshare

private[billshare] class ShippingShare extends (Int => BigDecimal) {
  def apply(numberOfWinesInShare: Int): BigDecimal = {
    BigDecimal("0")
  }
}

private[billshare] object ShippingShare {
  def apply(): ShippingShare = new ShippingShare
}
