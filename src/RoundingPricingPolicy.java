import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Pricing decorator that rounds totals produced by a base PricingPolicy
 * to a fixed number of fractional digits using HALF_UP.
 * Inert until explicitly used (adding this file does not change behavior).
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
  private double round(double v) {
    return BigDecimal.valueOf(v).setScale(scale, RoundingMode.HALF_UP).doubleValue();
  }

  @Override public double apply(double s, NormalSubscription x)   { return round(base.apply(s, x)); }
  @Override public double apply(double s, SilverSubscription x)   { return round(base.apply(s, x)); }
  @Override public double apply(double s, GoldSubscription x)     { return round(base.apply(s, x)); }
  @Override public double apply(double s, PlatinumSubscription x) { return round(base.apply(s, x)); }
}
