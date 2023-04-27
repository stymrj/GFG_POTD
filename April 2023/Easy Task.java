/*

Menu






























































Easy Task
MediumAccuracy: 63.46%Submissions: 8K+Points: 4
Explore Job Fair for students & freshers for daily new opportunities. Find A Job Today! 

Given a string s whose length is n and array queries of length q where each elements of queries is either of type 1 query or type 2 query which is explained ahead.

There are two types of query.

Query type 1 : ["1",ind,char]  "1" denotes this is type 1 query. In this query you have to change the character at index ind in s to character char.(Data type of ind,char is string in input)

Query Type 2: ["2",left,right,k]  "2" denotes this is type 2 query. In this query you have to return kth lexographically largest character  in the subtring of s (it is the kth largest character in sorted order , not the kth distinct character) starting from index left and ending at index right both left and right are inclusive. (Data type of left,right,k is string in input)

You have to perform each query in the same order as given in  queries and return an array res such that res array contains the answer for each type2 query in same order as it appeared in queries.

Note : 0 based indexing is used.

Example 1:

Input:
n=4
s="abab"
q=2
queries={{"1","2","d"},{"2","1","3","1"}}
Output: 
{"d"}
Explanation:
First query is of type 1 so after changing character at index 2 
to d  s becomes abdb . Now Second query is of type 2 in which 
the 1st(k=1) lexographically largest character is "d" in substring "bdb"(s[1:3]). So we 
returned a array with result of type 2 query {"d"}.
Example 2:

Input:
n=3
s="aaa"
q=3
queries={{"1","1","e"},{"1","2","c"},{"2","1","2","2"}}
Output:
{"c"}
Explanation:
After applying first two queries s becomes aec. Now for 
the last query which is a type 2 second largest character 
in subtring s starting from index 1 to ending at index 2 is "c".
Your Task:
You don't need to read input or print anything. Your task is to complete the function easyTask() which takes an integer n,string s,an integer q and an array queries which contains  queries of type1 and type2  respectively and returns an array res such that res array contains the answer for each type2 query in same order as it appeared in queries.

Expected Time Complexity: O(N+(Q*logN))
Expected Space Complexity: O(N)


Constraints:
1<=n<=5*10^4
1<=q<=10^5
0<=int(left)<=int(right)<=n-1
0<=int(index)<=n-1
1<=int(k)<=right-left+1
s and char contains lowercase english letters
The sum of n over all test cases won't exceed 5*10^4.


*/





//User function Template for Java

class Solution {
    static int seg[][];
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        seg=new int[4*n][26];
        char c[]=s.toCharArray();
        buildTree(c,0,0,n-1);
        ArrayList<Character> ans=new ArrayList<>();
        for(int i=0;i<q;i++){
            if(queries[i].type.equals("1")){
                int ind=Integer.parseInt(queries[i].a);
                char val=queries[i].b.charAt(0);
                update(0,0,n-1,ind,val);
            }else{
                int l=Integer.parseInt(queries[i].a);
                int r=Integer.parseInt(queries[i].b);
                int k=Integer.parseInt(queries[i].c);
                int arr[]=query(0,0,n-1,l,r);
                for(int j=25;j>=0;j--){
                    for(int kk=0;kk<arr[j];kk++){
                        k--;
                        if(k==0){
                            ans.add((char)(j+'a'));
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void buildTree(char a[],int si,int ss,int se)
	{
		if(ss==se){
			seg[si][a[ss]-'a']++;
			return;
		}
		int mid=(ss+se)/2;
		buildTree(a,2*si+1,ss,mid);
		buildTree(a,2*si+2,mid+1,se);
        int a1[]=seg[2*si+1];
        int a2[]=seg[2*si+2];
        for(int i=0;i<26;i++){
            seg[si][i]=a1[i]+a2[i];
        }
	}
    public static void update(int si,int ss,int se,int pos,char val)
	{
		if(ss==se){
            int in=0;
            for(int i=0;i<26;i++){
                if(seg[si][i]>=1){
                    in=i;
                    break;
                }
            }
            seg[si][in]--;
			seg[si][val-'a']++;
			return;
		}
		int mid=(ss+se)/2;
		if(pos<=mid){
			update(2*si+1,ss,mid,pos,val);
		}else{
			update(2*si+2,mid+1,se,pos,val);
		}
		int a1[]=seg[2*si+1];
        int a2[]=seg[2*si+2];
        for(int i=0;i<26;i++){
            seg[si][i]=a1[i]+a2[i];
        }
	}
    public static int[] query(int si,int ss,int se,int qs,int qe)
	{
		if(qs>se || qe<ss)return new int[26];
		if(ss>=qs && se<=qe)return seg[si];
		int mid=(ss+se)/2;
		int a1[]=query(2*si+1,ss,mid,qs,qe);
		int a2[]=query(2*si+2,mid+1,se,qs,qe);
		// return max(p1,p2);
        int ans[]=new int[26];
        for(int i=0;i<26;i++){
            ans[i]=a1[i]+a2[i];
        }
        return ans;
	}
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
