class Solution{
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0l;
        int p = shop.get(0);
        while(k >= p){
            int s = 0; int e = n-1;
            while(s<=e){
                int mid = s + (e-s)/2;
                int val;
                if( map.containsKey(mid) ){ val = map.get(mid);
                    
                }
                else{ val = shop.get(mid); map.put(mid, val); 
                }
                if(val <= k){ 
                    s = mid+1; 
                }
                else{ e = mid-1; }
            }
            long val;
            if( map.containsKey(e) ){ val = (long) map.get(e); }
            else{ val = (long) shop.get(e); map.put(e, (int) val); }
            ans += k/val;
            k %= val;
            n = e;
        }
        return ans;
    }
}
