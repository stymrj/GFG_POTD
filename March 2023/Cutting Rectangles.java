class Solution{

    static long solve(long a, long b){

        if(b==0){

            return a;

        }

        return solve(b, a % b);

    }

    

    static List<Long> minimumSquares(long L, long B)

    {

        //caluclate gcd

        long k=solve(L, B);

        //calculate n

        long n=(L*B) / (k*k);

        

        //store res

        List<Long> res=new ArrayList<>();

        res.add(Long.valueOf(n));

        res.add(Long.valueOf(k));

        

        return res;

    }

}
