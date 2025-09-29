/**
 * creator: rishit chatterjee
 * Customer subscription tier (e.g., normal, silver, gold, platinum).
 * Implementations should be immutable.
 */
public interface Subscription {
  String code();                                   // e.g., "gold"
  double price(double subtotal, PricingPolicy p);  // double-dispatch entry
}

