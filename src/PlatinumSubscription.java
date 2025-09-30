/**
 * creator: rishit chatterjee
 * platinum subscription tier
 */

public class PlatinumSubscription implements Subscription {
  private static final double PERCENT_OFF = Discounts.PLATINUM_PERCENT_OFF;
  private static final double FACTOR = Discounts.BASE_MULTIPLIER - PERCENT_OFF;

  @Override public String code() { 
    return "platinum"; 
  }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public double factor() { return FACTOR; }
  @Override public String toString() { return code(); }
}
