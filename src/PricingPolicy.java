/**
 * creator: rishit chatterjee
 * Strategy for computing final price for a given subscription tier.
 * Overloads avoid if/switch by using double dispatch.
 */
public interface PricingPolicy {
  double apply(double subtotal, NormalSubscription s);
  double apply(double subtotal, SilverSubscription s);
  double apply(double subtotal, GoldSubscription s);
  double apply(double subtotal, PlatinumSubscription s);
}

