/**
* creator: rishit chatterjee
*/

public class SilverSubscription implements Subscription {
  @Override public String code() { return "silver"; }
  @Override public double price(double subtotal, PricingPolicy p) { return p.apply(subtotal, this); }
  @Override public String toString() { return code(); }
}
