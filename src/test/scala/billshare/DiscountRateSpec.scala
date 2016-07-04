package billshare

import org.scalatest.{MustMatchers, WordSpec}

class DiscountRateSpec extends WordSpec with MustMatchers {

  trait Setup {
    val discountRate = DiscountRate()
  }

  "The discount rate for 4 total wines" should {
    "be 5%" in new Setup {
      discountRate(4) must be (BigDecimal("0.05"))
    }
  }
}