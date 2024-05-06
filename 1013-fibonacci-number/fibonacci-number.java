class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return recFib(1, 1, n-2);



    }
    
    private int recFib(int current, int prev, int n){
        if(n == 0){
            return current;
        }
        return recFib(current + prev, current, n-1);

    }
}