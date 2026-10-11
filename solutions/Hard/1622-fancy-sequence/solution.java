// ──────────────────────────────────────────────────
// Problem  : 1622. Fancy Sequence
// Difficulty: Hard
// Tags     : Math, Design, Segment Tree, Number Theory, Fermat's Little Theorem
// Link     : https://leetcode.com/problems/fancy-sequence/
// Runtime  : 50 ms (beats 72%)
// Memory   : 121140000 (beats 71%)
// Language : java
// Copyright: (c) 2026 SIVA-K003. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Fancy {
    private List<Long> list;
    private List<Long> mult;
    private List<Long> add;
    private static final long MOD = 1_000_000_007;

    public Fancy() {
        list = new ArrayList<>();
        mult = new ArrayList<>();
        add = new ArrayList<>();
        mult.add(1L);
        add.add(0L);
    }
    
    public void append(int val) {
        list.add((long) val);
        mult.add(mult.get(mult.size() - 1));
        add.add(add.get(add.size() - 1));
    }
    
    public void addAll(int inc) {
        int n = add.size();
        add.set(n - 1, (add.get(n - 1) + inc) % MOD);
    }
    
    public void multAll(int m) {
        int n = mult.size();
        mult.set(n - 1, (mult.get(n - 1) * m) % MOD);
        add.set(n - 1, (add.get(n - 1) * m) % MOD);
    }
    
    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        
        long m = mult.get(mult.size() - 1) * power(mult.get(idx), MOD - 2) % MOD;
        long a = (add.get(add.size() - 1) - add.get(idx) * m % MOD + MOD) % MOD;
        
        return (int) ((list.get(idx) * m + a) % MOD);
    }
    
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}