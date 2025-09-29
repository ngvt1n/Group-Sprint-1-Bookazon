<p align="center">
  <em>“SOLID Code”</em>
</p>

<h1 align="center">Bookazon — Group Sprint 1</h1>
<p align="center">
  Pricing & Subscription refactor via small interfaces and strategies — no magic strings, no if/else pyramids.
</p>

---

## What this branch delivers
- Type-safe **subscriptions** (no raw strings) and a pure **pricing strategy**.
- `Order` now **depends on abstractions**: it computes a subtotal and delegates pricing.
- **Collections correctness**: `CartItem.equals(Object)/hashCode()` fixed; `Order` copies cart items defensively.
- Clean integration with the team’s **printing layer** (`Printer<T>`, `PrintManager`) and media model.

---

## Contributor Spotlight — @AgentQuantum (Rishit Chatterjee)
I authored the **Pricing & Subscription** redesign and the related **cart/order fixes** in this sprint.  
PR: **#14 — _Refactor: Pricing & Subscription via interfaces (+ cart/order fixes)_**

---

## What I Built (My Contribution)
- **`Subscription` interface** with concrete tiers: `NormalSubscription`, `SilverSubscription`, `GoldSubscription`, `PlatinumSubscription`.  
  → Eliminates magic strings and normalizes tier identity.
- **`PricingPolicy` strategy** with **`TablePricingPolicy`** (named constants; **double-dispatch overloads**).  
  → No `if/else`, no `switch`, no `Map` needed for selecting discounts.
- **`Order` integration**:  
  ```java
  public Order(Cart cart, Subscription sub, PricingPolicy policy) {
    this.items = new java.util.ArrayList<>(cart.getItems());
    double subtotal = 0.0;
    for (CartItem it : items) subtotal += it.getTotalPrice();
    this.orderPrice = sub.price(subtotal, policy);            // delegate
  }
