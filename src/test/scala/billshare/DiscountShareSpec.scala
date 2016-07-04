package billshare

import org.mockito.Mockito.when
import org.scalatest.mock.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}

class DiscountShareSpec extends WordSpec with MustMatchers with MockitoSugar {

  trait Context {
    val discountRate = mock[DiscountRate]
    val discountShare = DiscountShare(discountRate)
  }

  trait Setup extends Context {
    when(discountRate(4)) thenReturn BigDecimal("0.05")
  }

  "The share of the discount for no bottles of wine" should {
    "be $0" in new Setup {
      discountShare(BigDecimal("0"), BigDecimal("0"), 4) must be (BigDecimal("0"))
    }
  }

  "The share of the discount for a $43.98 share of the subtotal" should {
    "be $2.347" in new Setup {
      discountShare(BigDecimal("43.98"), BigDecimal("2.969"), 4) must
        be (BigDecimal("2.347") +- BigDecimal("0.0005"))
    }
  }
}