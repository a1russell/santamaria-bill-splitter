package billshare

private[billshare] class DiscountShare private(discountRate: DiscountRate)
  extends ((BigDecimal, BigDecimal, Int) => BigDecimal) {

  def apply(subtotalShare: BigDecimal,
            taxShare: BigDecimal,
            totalNumberOfWines: Int): BigDecimal = {
    discountRate(totalNumberOfWines) * (subtotalShare + taxShare)
  }
}

private[billshare] object DiscountShare {
  def apply(discountRate: DiscountRate): DiscountShare = {
    new DiscountShare(discountRate)
  }
}