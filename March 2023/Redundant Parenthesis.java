/*
Given a valid expression containing only binary operators '+', '-', '*', '/' and operands, remove all the redundant parenthesis.

A set of parenthesis is said to be redundant if, removing them, does not change the value of the expression.

Note: The operators '+' and '-' have the same priority. '*' and '/' also have the same priority. '*' and '/' have more priority than '+' and '-'.


Example 1:

Input:
Exp = (A*(B+C))
Output: A*(B+C)
Explanation: The outermost parenthesis
are redundant.
Example 2:

Input:
Exp = A+(B+(C))
Output: A+B+C
Explanation: All the parenthesis
are redundant.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function removeBrackets() which takes the string Exp as input parameters and returns the updated expression.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 < Length of Exp < 105
Exp contains uppercase english letters, '(' , ')', '+', '-', '*' and '/'.
*/

//User function Template for Java

class Solution
{
    public static String removeBrackets(String expression) {
        char[] expressionArr = expression.toCharArray();
        int n = expression.length();
    
        int[] ans = new int[n + 1];
        Arrays.fill(ans, 1);
        int[] lastOperator = new int[n + 1];
        int[] nextOperator = new int[n + 1];
    
        int l = -1;
        for (int i = 0; i < n; i++) {
            lastOperator[i] = l;
            if (expressionArr[i] == '*' || expressionArr[i] == '+' || expressionArr[i] == '-' || expressionArr[i] == '/') {
                l = expressionArr[i];
            }
        }
        l = -1;
        for (int i = n - 1; i >= 0; i--) {
            nextOperator[i] = l;
            if (expressionArr[i] == '*' || expressionArr[i] == '+' || expressionArr[i] == '-' || expressionArr[i] == '/') {
                l = expressionArr[i];
            }
        }
    
        Stack<Integer> stack = new Stack<>();
        int[] sign = new int[256];
        int[] mp = new int[256];
        Arrays.fill(sign, -1);
        char[] operators = {'*', '+', '-', '/'};
    
        for (int p = 0; p < n; p++) {
            for (char x : operators) {
                mp[x] = 0;
                if (x == expressionArr[p]) {
                    sign[x] = p;
                }
            }
            if (expressionArr[p] == '(') {
                stack.push(p);
            } else if (expressionArr[p] == ')') {
                int i = stack.pop();
                int j = p;
    
                int nxt = nextOperator[j];
                int last = lastOperator[i];
    
                for (char x : operators) {
                    if (sign[x] >= i) {
                        mp[x] = 1;
                    }
                }
                int ok = 0;
    
                if (i > 0 && j + 1 < n && expressionArr[i - 1] == '(' && expressionArr[j + 1] == ')') {
                    ok = 1;
                }
                if (mp['+'] == 0 && mp['*'] == 0 && mp['-'] == 0 && mp['/'] == 0) {
                    ok = 1;
                }
    
                if (last == -1 && nxt == -1) {
                    ok = 1;
                }
                if (last == '/') {
                    // Handle division
                } else if (last == '-' && (mp['+'] == 1 || mp['-'] == 1)) {
                    // Handle subtraction
                } else if (mp['-'] == 0 && mp['+'] == 0) {
                    ok = 1;
                } else {
                    if ((last == -1 || last == '+' || last == '-') && (nxt == -1 || nxt == '+' || nxt == '-')) {
                        ok = 1;
                    }
                }
                if (ok == 1) {
                    ans[i] = 0;
                    ans[j] = 0;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ans[i] > 0) {
                result.append(expressionArr[i]);
            }
        }
        return result.toString();
    }
}
