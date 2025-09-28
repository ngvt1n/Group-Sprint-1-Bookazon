/** 
 * creator: rishit chatterjee
 * Discounts without a map: normal 0%, silver 5%, gold 15%, platinum 10%. 
 */


public class TablePricingPolicy implements PricingPolicy {
  // discount factors (no magic numbers in code paths)
  private static final double FACTOR_GOLD     = 0.85; // 15% off
  private static final double FACTOR_PLATINUM = 0.90; // 10% off
  private static final double FACTOR_SILVER   = 0.95; //  5% off
  private static final double FACTOR_NORMAL   = 1.00; //  0% off

  @Override
  public double apply(double subtotal, Subscription sub) {
    if (subtotal < 0) throw new IllegalArgumentException("subtotal < 0");
    String code = sub.code(); // already lower-case from NamedSubscription
    double factor = switch (code) {
      case "gold"     -> FACTOR_GOLD;
      case "platinum" -> FACTOR_PLATINUM;
      case "silver"   -> FACTOR_SILVER;
      default         -> FACTOR_NORMAL;
    };
    return subtotal * factor;
  }
}

