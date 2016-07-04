package billshare

import org.scalatest.{MustMatchers, WordSpec}

class ShippingShareSpec extends WordSpec with MustMatchers {

  trait Setup {
    val shippingShare = ShippingShare()
  }

  "The share of the shipping for no bottles of wine" should {
    "be $0" in new Setup {
      shippingShare(0, 4) must be (BigDecimal("0"))
    }
  }

  "The share of the shipping for two of four bottles of wine" should {
    "be $10.00" in new Setup {
      shippingShare(2, 4) must be (BigDecimal("10.00"))
    }
  }
}