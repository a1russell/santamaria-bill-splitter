package billshare

private[billshare] class DiscountShare extends (() => BigDecimal) {
  def apply(): BigDecimal = throw new NotImplementedError
}
