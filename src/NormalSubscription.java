/**
 * creator: rishit chatterjee
 * normal subscription tier
 */

public class NormalSubscription implements Subscription {
  @Override public String code() { return "normal"; }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public String toString() { return code(); }
}
