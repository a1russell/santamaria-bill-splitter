package billshare

import org.scalatest.{MustMatchers, WordSpec}

class TaxShareSpec extends WordSpec with MustMatchers {

  trait Setup {
    val taxShare = TaxShare()
  }

  "The share of the tax for a $0 share of the subtotal" should {
    "be $0" in new Setup {
      taxShare(0) must be (BigDecimal("0"))
    }
  }

  "The share of the tax for a $43.98 share of the subtotal" should {
    "be $2.969" in new Setup {
      taxShare(BigDecimal("43.98")) must be (BigDecimal("2.969") +- BigDecimal("0.0005"))
    }
  }
}