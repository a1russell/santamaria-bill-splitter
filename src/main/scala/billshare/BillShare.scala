package billshare

import scala.math.BigDecimal.RoundingMode

class BillShare private(taxShare: TaxShare,
                        discountShare: DiscountShare,
                        shippingShare: ShippingShare)
  extends ((List[BigDecimal], Int) => BigDecimal) {

  def apply(pricesOfShareOfWines: List[BigDecimal], totalNumberOfWines: Int): BigDecimal = {
    val subtotal = pricesOfShareOfWines.sum
    val tax = taxShare(subtotal)
    val discount = discountShare(subtotal, tax, totalNumberOfWines)
    val shipping = shippingShare(pricesOfShareOfWines.length, totalNumberOfWines)
    (subtotal + tax - discount + shipping).setScale(2, RoundingMode.HALF_UP)
  }
}

object BillShare {

  def apply(taxShare: TaxShare,
            discountShare: DiscountShare,
            shippingShare: ShippingShare): BillShare = {
    new BillShare(taxShare, discountShare, shippingShare)
  }
}