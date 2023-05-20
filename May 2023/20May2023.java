class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        Map<Integer,Integer> map= new HashMap<>();
        Arrays.sort(hand);
        for(int ele:hand) map.put(ele,map.getOrDefault(ele,0)+1);
        for(int i=0;i<hand.length;i++)
        {
           
             if(map.get(hand[i])==0)continue;
            if(!isPossible(hand[i],map,groupSize))return false;
            
        }
        return true;
        
    }
    static boolean isPossible (int st, Map<Integer,Integer>map,int size)
    {
        for(int i=0;i<size;i++)
        {
            if(!map.containsKey(i+st)|| map.get(i+st)==0) return false;
            map.put(i+st,map.get(i+st)-1);
            
        }
        return true;
    }
}
