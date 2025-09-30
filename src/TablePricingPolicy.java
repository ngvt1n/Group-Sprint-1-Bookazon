/** 
 * creator: rishit chatterjee
 * Discounts without a map: normal 0%, silver 5%, gold 15%, platinum 10%. 
 */


/**
 * Branch-free policy
 * 
 */
public class TablePricingPolicy implements PricingPolicy {
  @Override
  public double apply(double subtotal, Subscription s) {
    return subtotal * s.factor();
  }
}



