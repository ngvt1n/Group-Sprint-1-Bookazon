/**
 * creator: rishit chatterjee
 * gold subscription tier
 */

public class GoldSubscription implements Subscription {
  @Override public String code() { return "gold"; }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public String toString() { return code(); }
}
