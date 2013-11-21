package billshare

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class ShippingShareTest extends Specification {
  "The share of the shipping for no bottles of wine" should {
    "be $0" in new ShippingShareTest.context {
      shippingShare(0) must be_==(BigDecimal("0"))
    }
  }
}

object ShippingShareTest {
  trait context extends Scope {
    val shippingShare = ShippingShare()
  }
}
