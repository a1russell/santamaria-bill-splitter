package billshare

trait Context {
  private[billshare] val discountRate = DiscountRate()
  private[billshare] val discountShare = DiscountShare(discountRate)
  private[billshare] val shippingShare = ShippingShare()
  private[billshare] val taxShare = TaxShare()
  val billShare = BillShare(taxShare, discountShare, shippingShare)
}
