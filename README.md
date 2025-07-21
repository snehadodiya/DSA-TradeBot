## 📈 DSA-Based TradeBot

An intelligent stock trading simulation bot built using **Java** and core **Data Structures & Algorithms (DSA)**. This bot simulates buy/sell decisions based on stock price trends and implements algorithmic strategies like Greedy, Dynamic Programming (DP), and K-Transaction Profit Maximization to maximize simulated returns.

---

### 📦 Features

* 📊 **Simulates Market Conditions**: Uses synthetic or predefined stock price inputs.
* 🧠 **Algorithmic Trading Strategies**:

  * Greedy Buy/Sell Logic
  * Max Profit with Cooldown (DP).
  * Max Profit with K Transactions (DP Tabulation)
* 📈 **Trade Execution Logging**: Logs actions (buy/sell/hold) with calculated profit.
* 🧪 **Testable Logic**: Cleanly separated logic makes it easy to plug in different price arrays and verify outcomes.
* ⚡ **DSA Optimized**: Efficient algorithms designed for performance with large inputs.

---

### 🧠 How It Works

1. The bot receives an array of stock prices (daily prices).
2. Based on the chosen strategy, it analyzes when to **buy**, **sell**, or **hold**.
3. Tracks and logs the profit made during the simulation.

Example:

> “Buy when the price dips and sell when it peaks — maximizing profit using classic DSA patterns.”

---

### 🛠️ Algorithms Used

| Strategy Name                 | DSA Concept         | Description                                             |
| ----------------------------- | ------------------- | ------------------------------------------------------- |
| **Greedy Buy/Sell**           | Greedy              | Buys at local minima, sells at maxima                   |
| **Max Profit with Cooldown**  | Dynamic Programming | No two trades on consecutive days                       |
| **K Transactions Max Profit** | DP Tabulation       | Maximizes profit under a limited number of transactions |

---

### 📊 Sample Output

```text
Day 0: Price = 100 → Buy
Day 3: Price = 150 → Sell → Profit = 50
Day 4: Price = 120 → Buy
Day 6: Price = 160 → Sell → Profit = 40
Total Profit: 90
```

---

### 🚀 Future Improvements

* 🔁 Add real-time market data APIs (like Alpha Vantage, Yahoo Finance)
* 🤖 ML-enhanced strategy selection
* 📱 Convert to Android or Web-based simulator
