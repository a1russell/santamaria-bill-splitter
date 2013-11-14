package billshare

private[billshare] class ShippingShare extends (() => BigDecimal) {
  def apply(): BigDecimal = throw new NotImplementedError
}
