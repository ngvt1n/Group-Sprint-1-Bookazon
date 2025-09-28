/** 
 * creator: rishit chatterjee
 * Discounts without a map: normal 0%, silver 5%, gold 15%, platinum 10%. 
 */


public class TablePricingPolicy implements PricingPolicy {
  @Override
  public double apply(double subtotal, Subscription sub) {
    if (subtotal < 0) throw new IllegalArgumentException("subtotal < 0");
    String code = sub.code();     // should be lower-case from NamedSubscription
    double factor = 1.0;          // default: no discount

    if ("gold".equals(code)) {
      factor = 0.85;              // 15% off
    } else if ("platinum".equals(code)) {
      factor = 0.90;              // 10% off
    } else if ("silver".equals(code)) {
      factor = 0.95;              // 5% off
    }
    return subtotal * factor;
  }
}
