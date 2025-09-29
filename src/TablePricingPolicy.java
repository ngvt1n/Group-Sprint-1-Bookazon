/** 
 * creator: rishit chatterjee
 * Discounts without a map: normal 0%, silver 5%, gold 15%, platinum 10%. 
 */


/**
 * Branch-free policy
 * 
 */
public class TablePricingPolicy implements PricingPolicy {
  private static final double FACTOR_NORMAL   = 1.00;
  private static final double FACTOR_SILVER   = 0.95; // 5% off
  private static final double FACTOR_GOLD     = 0.85; // 15% off
  private static final double FACTOR_PLATINUM = 0.90; // 10% off

  @Override public double apply(double subtotal, NormalSubscription   s) { 
    return subtotal * FACTOR_NORMAL; 
  }
  @Override public double apply(double subtotal, SilverSubscription   s) { 
    return subtotal * FACTOR_SILVER; 
  }
  @Override public double apply(double subtotal, GoldSubscription     s) { 
    return subtotal * FACTOR_GOLD; 
  }
  @Override public double apply(double subtotal, PlatinumSubscription s) { 
    return subtotal * FACTOR_PLATINUM; 
  }
}


