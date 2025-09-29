/**
 * creator: rishit chatterjee
 * Strategy for computing final price for a given subscription tier.
 * Overloads avoid if/switch by using double dispatch.
 */
public interface PricingPolicy {
  double apply(double subtotal, Subscription s);
}


