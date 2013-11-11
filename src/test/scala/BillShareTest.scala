import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BillShareTest extends Specification with Mockito {

  val billShare = BillShare()

  "The share of the bill for no wines" should {
    "be $0" in {
      billShare(List()) must be_==(BigDecimal("0"))
    }
  }
}
