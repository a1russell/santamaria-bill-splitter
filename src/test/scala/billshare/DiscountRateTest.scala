package billshare

import org.scalatest.{MustMatchers, WordSpec}

class DiscountRateTest extends WordSpec with MustMatchers {
  "The discount rate for 4 total wines" should {
    "be 5%" in new DiscountRateTest.context {
      discountRate(4) must be (BigDecimal("0.05"))
    }
  }
}

object DiscountRateTest {
  trait context {
    val discountRate = DiscountRate()
  }
}
