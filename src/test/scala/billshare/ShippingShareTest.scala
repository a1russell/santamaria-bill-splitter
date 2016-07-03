package billshare

import org.scalatest.{MustMatchers, WordSpec}

class ShippingShareTest extends WordSpec with MustMatchers {
  "The share of the shipping for no bottles of wine" should {
    "be $0" in new ShippingShareTest.context {
      shippingShare(0, 4) must be (BigDecimal("0"))
    }
  }

  "The share of the shipping for two of four bottles of wine" should {
    "be $10.00" in new ShippingShareTest.context {
      shippingShare(2, 4) must be (BigDecimal("10.00"))
    }
  }
}

object ShippingShareTest {
  trait context {
    val shippingShare = ShippingShare()
  }
}
