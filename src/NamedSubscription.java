/** 
 * creator: rishit chatterjeee
 * Subscription backed by a normalized string code. 
 */

public class NamedSubscription implements Subscription {
  private final String code;

  public NamedSubscription(String code) {
    if (code == null || code.isBlank()) {
      throw new IllegalArgumentException("subscription code blank");
    }
    this.code = code.toLowerCase(); // normalize once
  }

  @Override public String code() { return code; }

  @Override public String toString() { return code; }
}