/**
 * Pricing decorator that rounds totals produced by a base PricingPolicy.
 * name: rishit chatterjee
 */
public final class RoundingPricingPolicy implements PricingPolicy {
  /** Underlying policy to delegate to first. */
  private final PricingPolicy base;
  /** Number of fractional digits (e.g., 2 for cents). */
  private final int scale;

  /**
   * @param base delegate policy (must not be null)
   * @param scale fractional digits to round to (>= 0)
   * @throws IllegalArgumentException if base is null or scale < 0
   */
  public RoundingPricingPolicy(PricingPolicy base, int scale) {
    if (base == null) throw new IllegalArgumentException("base null");
    if (scale < 0) throw new IllegalArgumentException("scale < 0");
    this.base = base; this.scale = scale;
  }

  /** Round using HALF_UP to the configured scale. */
  private double r(double v) {
    java.math.BigDecimal bd = java.math.BigDecimal.valueOf(v);
    return bd.setScale(scale, java.math.RoundingMode.HALF_UP).doubleValue();
  }

  @Override 
  public double apply(double s, NormalSubscription x)   { 
    return r(base.apply(s, x)); 
  }
  @Override 
  public double apply(double s, SilverSubscription x)   { 
    return r(base.apply(s, x)); 
  }
  @Override 
  public double apply(double s, GoldSubscription x)     { 
    return r(base.apply(s, x)); 
  }
  @Override 
  public double apply(double s, PlatinumSubscription x) { 
    return r(base.apply(s, x)); 
  }
}
