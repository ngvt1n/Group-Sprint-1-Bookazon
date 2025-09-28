/**
 * creator: rishit chatterjee
 * Customer subscription tier (e.g., "normal", "silver", "gold", "platinum").
 * Implementations should be immutable and normalize the code (e.g., lower-case).
 */
public interface Subscription {
  /** 
   * Tiers. 
   */
  String code();
}

