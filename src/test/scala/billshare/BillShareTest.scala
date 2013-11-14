package billshare

import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class BillShareTest extends Specification {
  "The share of the bill for no wines" should {
    "be $0" in new BillShareTest.noBottlesOfWine {
      billShare(List()) must be_==(BigDecimal("0"))
    }
  }

  "The share of the bill for two wines costing $21.99 each out of " +
    "four wines total" should {
    "be $54.60" in new BillShareTest.twoBottlesOf2199Wine {
      billShare(pricesOfShareOfWines) must be_==(BigDecimal("54.60"))
    }
  }
}

object BillShareTest {
  trait context extends Scope with Mockito {
    val taxShare = mock[TaxShare]
    val discountShare = mock[DiscountShare]
    val shippingShare = mock[ShippingShare]
    val billShare = BillShare(taxShare, discountShare, shippingShare)
  }

  trait noBottlesOfWine extends context {
    taxShare(any[BigDecimal]) returns BigDecimal("0")
    discountShare() returns BigDecimal("0")
    shippingShare() returns BigDecimal("0")
  }

  trait twoBottlesOf2199Wine extends context {
    val pricesOfShareOfWines = List(BigDecimal("21.99"), BigDecimal("21.99"))

    taxShare(any[BigDecimal]) returns BigDecimal("2.969")
    discountShare() returns BigDecimal("2.347")
    shippingShare() returns BigDecimal("10.00")
  }
}
