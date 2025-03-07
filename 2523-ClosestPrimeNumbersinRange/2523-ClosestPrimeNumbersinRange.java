class Solution {
    boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i<=n; i++){
            for(int j = i*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }

        return isPrime;
    }   

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = left; i<=right; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        int n = primes.size();
        int ans = (int)(1e6), l = -1, r = -1;
        for(int i = 0; i<n-1; i++){
            int diff = primes.get(i+1) - primes.get(i);

            if(ans > diff){
                ans = primes.get(i+1) - primes.get(i);

                l = primes.get(i);
                r = primes.get(i+1);
            }
        }

        return new int[]{l, r};
    }
}