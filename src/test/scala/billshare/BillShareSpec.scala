package billshare

import org.mockito.Mockito.when
import org.scalatest.mock.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}

class BillShareSpec extends WordSpec with MustMatchers with MockitoSugar {

  trait Context {
    val taxShare = mock[TaxShare]
    val discountShare = mock[DiscountShare]
    val shippingShare = mock[ShippingShare]
    val billShare = BillShare(taxShare, discountShare, shippingShare)
  }

  "The share of the bill for no wines" should {
    trait Setup extends Context {
      when(taxShare(BigDecimal("0"))) thenReturn BigDecimal("0")
      when(discountShare(BigDecimal("0"), BigDecimal("0"), 4)) thenReturn BigDecimal("0")
      when(shippingShare(0, 4)) thenReturn BigDecimal("0")
    }

    "be $0" in new Setup {
      billShare(List(), 4) must be (BigDecimal("0"))
    }
  }

  "The share of the bill for two wines costing $21.99 each out of " +
      "four wines total" should {
    trait Setup extends Context {
      val pricesOfShareOfWines = List(BigDecimal("21.99"), BigDecimal("21.99"))

      private val subtotal: BigDecimal = BigDecimal("43.98")
      private val tax: BigDecimal = BigDecimal("2.969")
      private val totalNumberOfWines: Int = 4

      when(taxShare(subtotal)) thenReturn tax
      when(discountShare(subtotal, tax, totalNumberOfWines)) thenReturn BigDecimal("2.347")
      when(shippingShare(pricesOfShareOfWines.length, totalNumberOfWines)) thenReturn BigDecimal("10.00")
    }

    "be $54.60" in new Setup {
      billShare(pricesOfShareOfWines, 4) must be (BigDecimal("54.60"))
    }
  }
}