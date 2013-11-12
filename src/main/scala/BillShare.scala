import scala.math.BigDecimal.RoundingMode

class BillShare private (taxShare: TaxShare,
                         discountShare: DiscountShare,
                         shippingShare: ShippingShare)
extends (List[BigDecimal] => BigDecimal) {

  def apply(pricesOfSharesOfWines: List[BigDecimal]): BigDecimal = {
    val subtotal = pricesOfSharesOfWines.sum
    val tax = taxShare()
    val discount = discountShare()
    val shipping = shippingShare()
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