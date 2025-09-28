/**
 * creator: rishit chatterjee
 * Strategy that computes the final price from a subtotal and a subscription tier.
 * Pure function: no I/O or hidden state.
 * 
 */
public interface PricingPolicy {
  /**
   * @param subtotal      pre-discount total (>= 0)
   * @param subscription  subscription tier influencing discounts
   * @return final price after discounts
   * @throws IllegalArgumentException if subtotal < 0
   */
  double apply(double subtotal, Subscription subscription);
}
