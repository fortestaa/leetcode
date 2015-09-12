package easy;

/**
 * 204	Count Primes
 * https://leetcode.com/problems/count-primes/
 * Description: Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 2];	// n+2
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                int c = i * i;
                while (c < n) {
                    notPrime[c] = true;
                    c += i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!notPrime[i]) {
                ans++;
            }
        }
        return ans;
    }
    //http://cache.baiducontent.com/c?m=9d78d513d9921ce804ab837e7c54973d4603c1777b978e1a2592d50a8465285c5a23a6fe30226742949e2d3a5cf15e5c9da16b2d2a5060f1c099d61d9ca6c65f7bf7776b03&p=b460cf1d85cc43b708e2977e0e54c9&newp=882a9645d58c0ef00be2963a557abb231610db2151d4d016309bcc&user=baidu&fm=sc&query=Count+Primes&qid=89d421800001ffe3&p1=2
    //埃拉托色尼筛法 ( http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes )

    public int countPrimes0(int n) {
        boolean[] a = new boolean[n];
        for (int i = 2; i * i < n; i++) {
        	if (!a[i]) {
        		for (int j = i; i * j < n; j++) {
        			a[i * j] = true;
        		}
        	}
        }
        int c = 0;
        
        for (int i = 2; i < n; i++) {
        	if (a[i] == false)	c++;
        }
        return c;
    }
    //http://blog.csdn.net/xudli/article/details/45361471
}