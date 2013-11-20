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

  "The share of the discount for a $43.98 share of the subtotal" should {
    "be $2.347" in new DiscountShareTest.fourTotalBottlesOfWine {
      discountShare(BigDecimal("43.98"), BigDecimal("2.969"), 4) must
        beCloseTo(BigDecimal("2.347"), BigDecimal("0.0005"))
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