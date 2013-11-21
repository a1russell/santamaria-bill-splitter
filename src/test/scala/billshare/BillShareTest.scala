package billshare

import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class BillShareTest extends Specification {
  "The share of the bill for no wines" should {
    "be $0" in new BillShareTest.noBottlesOfWineOutOfFour {
      billShare(List(), 4) must be_==(BigDecimal("0"))
    }
  }

  "The share of the bill for two wines costing $21.99 each out of " +
    "four wines total" should {
    "be $54.60" in new BillShareTest.twoBottlesOf2199WineOutOfFour {
      billShare(pricesOfShareOfWines, 4) must be_==(BigDecimal("54.60"))
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

  trait noBottlesOfWineOutOfFour extends context {
    taxShare(BigDecimal("0")) returns BigDecimal("0")
    discountShare(BigDecimal("0"), BigDecimal("0"), 4) returns BigDecimal("0")
    shippingShare(0) returns BigDecimal("0")
  }

  trait twoBottlesOf2199WineOutOfFour extends context {
    val pricesOfShareOfWines = List(BigDecimal("21.99"), BigDecimal("21.99"))

    private val subtotal: BigDecimal = BigDecimal("43.98")
    private val tax: BigDecimal = BigDecimal("2.969")

    taxShare(subtotal) returns tax
    discountShare(subtotal, tax, 4) returns BigDecimal("2.347")
    shippingShare(pricesOfShareOfWines.length) returns BigDecimal("10.00")
  }
}
