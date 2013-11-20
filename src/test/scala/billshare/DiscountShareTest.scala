package billshare

import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class DiscountShareTest extends Specification {
  "The share of the discount for no bottles of wine" should {
    "be $0" in new DiscountShareTest.fourTotalBottlesOfWine {
      discountShare(BigDecimal("0"), BigDecimal("0"), 4) must be_==(BigDecimal("0"))
    }
  }
}

object DiscountShareTest {
  trait context extends Scope with Mockito {
    val discountRate = mock[DiscountRate]
    val discountShare = DiscountShare(discountRate)
  }

  trait fourTotalBottlesOfWine extends context {
    discountRate(4) returns BigDecimal("0.05")
  }
}