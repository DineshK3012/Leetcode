class ProductOfNumbers {
private:
    vector<vector<int>> factorPrefixCount;
    vector<int> zeroCount;
    vector<int> primes;

    int streamSize;
    int primeArraySize;
    const int MAX_NUM_SIZE = 100;

    int power(long long a, long long b) {
        long long ans = 1;
        while(b > 0) {
            if(b & 1) ans *= a;
            a = a * a;
            b >>= 1;
        }
        return ans;
    }

public:
    ProductOfNumbers() {
        vector<bool> seive(MAX_NUM_SIZE + 1, true);
        for(int idx = 2; idx <= MAX_NUM_SIZE; idx++) {
            if(seive[idx]) {
                primes.push_back(idx);
                for(int fidx = idx * 2; fidx <= MAX_NUM_SIZE; fidx += idx) {
                    seive[fidx] = false;
                }
            }
        }
        primeArraySize = primes.size();
        streamSize = 0;
    }

    void add(int num) {
        vector<int> curFactorCount(primeArraySize, 0);
        if(num != 0) {
            for(int idx = 0; idx < primeArraySize; idx++) {
                while((num % primes[idx]) == 0) {
                    curFactorCount[idx]++;
                    num = num / primes[idx];
                }
                if(streamSize > 0) curFactorCount[idx] += factorPrefixCount[streamSize - 1][idx];
            }
        }
        factorPrefixCount.push_back(curFactorCount);
        if(num == 0) zeroCount.push_back(1);
        else zeroCount.push_back(0);
        if(streamSize > 0) zeroCount[streamSize] = zeroCount[streamSize] + zeroCount[streamSize - 1];
        streamSize++;
    }
    
    int getProduct(int k) {
        int r = streamSize - 1, l = max(0, streamSize - k);
        int zeros = zeroCount[r] - (l == 0 ? 0 : zeroCount[l - 1]);
        if(zeros > 0) return 0;
        int prod = 1;
        for(int idx = 0; idx < primeArraySize; idx++) {
            int exp = factorPrefixCount[r][idx];
            exp -= (l == 0 ? 0 : factorPrefixCount[l - 1][idx]);
            prod *= power(primes[idx], exp);
        }
        return prod;
    }
};