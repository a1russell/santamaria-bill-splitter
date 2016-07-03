package billshare

import org.scalatest.{MustMatchers, WordSpec}

class TaxShareTest extends WordSpec with MustMatchers {
  "The share of the tax for a $0 share of the subtotal" should {
    "be $0" in new TaxShareTest.context {
      taxShare(0) must be (BigDecimal("0"))
    }
  }

  "The share of the tax for a $43.98 share of the subtotal" should {
    "be $2.969" in new TaxShareTest.context {
      taxShare(BigDecimal("43.98")) must be (BigDecimal("2.969") +- BigDecimal("0.0005"))
    }
  }
}

object TaxShareTest {
  trait context {
    val taxShare = TaxShare()
  }
}
