/**
 * creator: rishit chatterjee
 * platinum subscription tier
 */

public class PlatinumSubscription implements Subscription {
  @Override public String code() { return "platinum"; }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public String toString() { return code(); }
}
