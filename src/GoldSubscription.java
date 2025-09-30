/**
 * creator: rishit chatterjee
 * gold subscription tier
 */

public class GoldSubscription implements Subscription {
  private static final double PERCENT_OFF = Discounts.GOLD_PERCENT_OFF;
  private static final double FACTOR = Discounts.BASE_MULTIPLIER - PERCENT_OFF;

  @Override public String code() { 
    return "gold"; 
  }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public double factor() { return FACTOR; }
  @Override public String toString() { return code(); }
}
