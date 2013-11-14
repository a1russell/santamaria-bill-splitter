package billshare

private[billshare] class DiscountShare private(discountRate: DiscountRate)
  extends ((BigDecimal, Int) => BigDecimal) {

  def apply(subtotalShare: BigDecimal, totalNumberOfWines: Int): BigDecimal = {
    0
  }
}

private[billshare] object DiscountShare {
  def apply(discountRate: DiscountRate): DiscountShare = {
    new DiscountShare(discountRate)
  }
}