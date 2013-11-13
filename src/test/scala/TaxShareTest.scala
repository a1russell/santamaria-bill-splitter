import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class TaxShareTest extends Specification {

  trait context extends Scope {
    val taxShare = TaxShare()
  }

  "The share of the tax for a $0 share of the subtotal" should {
    "be $0" in new context {
      taxShare(0) must be_==(BigDecimal("0"))
    }
  }
}
