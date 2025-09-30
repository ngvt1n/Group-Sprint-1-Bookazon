/**
 * creator: rishit chatterjee
 * normal subscription tier
 */

public class NormalSubscription implements Subscription {
  private static final double PERCENT_OFF = Discounts.NORMAL_PERCENT_OFF;
  private static final double FACTOR = Discounts.BASE_MULTIPLIER - PERCENT_OFF;

  @Override public String code() { 
    return "normal"; 
  }
  
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public double factor() { return FACTOR; }
  @Override public String toString() { return code(); }
}

