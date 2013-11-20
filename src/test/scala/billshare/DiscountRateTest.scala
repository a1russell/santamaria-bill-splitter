package billshare

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class DiscountRateTest extends Specification {
  "The discount rate for 4 total wines" should {
    "be 5%" in new DiscountRateTest.context {
      discountRate(4) must be_==(BigDecimal("0.05"))
    }
  }
}

object DiscountRateTest {
  trait context extends Scope {
    val discountRate = DiscountRate()
  }
}
