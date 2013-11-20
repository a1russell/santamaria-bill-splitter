package billshare

private[billshare] class DiscountShare private(discountRate: DiscountRate)
  extends ((BigDecimal, BigDecimal, Int) => BigDecimal) {

  def apply(subtotalShare: BigDecimal,
            taxShare: BigDecimal,
            totalNumberOfWines: Int): BigDecimal = {
    BigDecimal("0")
  }
}

private[billshare] object DiscountShare {
  def apply(discountRate: DiscountRate): DiscountShare = {
    new DiscountShare(discountRate)
  }
}