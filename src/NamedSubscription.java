/** 
 * creator: rishit chatterjeee
 * Subscription backed by a normalized string code. 
 */

/**
 * Subscription backed by a normalized string code and an explicit factor.
 * No magic numbers: pass factors or percent-offs from named constants (e.g., Discounts.*).
 */
public class NamedSubscription implements Subscription {
  private final String code;
  private final double factor; // multiplicative factor, e.g., 0.85 for 15% off

  public NamedSubscription(String code, double factor) {
    if (code == null || code.isBlank()) {
      throw new IllegalArgumentException("subscription code blank");
    }
    if (factor <= 0.0) {
      throw new IllegalArgumentException("factor must be positive");
    }
    this.code = code.toLowerCase();
    this.factor = factor;
  }

  public static NamedSubscription fromPercentOff(String code, double percentOff) {
    if (percentOff < 0.0 || percentOff >= 1.0) {
      throw new IllegalArgumentException("percentOff must be in [0,1)");
    }
    double f = Discounts.BASE_MULTIPLIER - percentOff;
    return new NamedSubscription(code, f);
  }

  @Override public String code() { return code; }

  @Override public double price(double subtotal, PricingPolicy p) {
    return p.apply(subtotal, this);
  }

  @Override public double factor() { return factor; }

  @Override public String toString() { return code; }
}
