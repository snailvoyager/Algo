package LeetCode.Easy;

public class CountPrimes {
    public int countPrimes2(int n) {
        if(n == 0)  return 0;
        boolean[] isPrime = new boolean[n+1];
        isPrime[1] = true;      //false가 소수
        
        for(int i=2; i<n; i++){
            if(isPrime[i])  continue;       //소수가 아닌 true 건너뜀
            for(int j=i+i; j<n; j+=i){     //소수가 아닌 배수 체크
                isPrime[j] = true;
            }
        }
        int result = 0;
        for(int i=2; i<n; i++){
            if(!isPrime[i])
                result++;
        }
        
        return result;
    }
    
    public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
       // Loop's ending condition is i * i < n instead of i < sqrt(n)
       // to avoid repeatedly calling an expensive function sqrt().
       for (int i = 2; i * i < n; i++) {
          if (!isPrime[i]) continue;
          for (int j = i * i; j < n; j += i) {
             isPrime[j] = false;
          }
       }
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
       return count;
    }
}
