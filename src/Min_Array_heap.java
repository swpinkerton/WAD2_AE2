public class Min_Array_heap<Item> {
    static private int[] Q;

    private void INSERT(int[] Q, int x){
        if (Q.length == 0){
            Q[0] = x;
        }
        else{
            Q[Q.length] = x;
        }
    }

    private int MIN(int[] Q){
        return(Q[0]);
    }

    static private int EXTRACT_MIN(int[] Q){
        int temp = Q[0];
        int newArr[] = new int[Q.length - 1];
        for (int i = 1; i < Q.length; i++) {
            newArr[i-1] = Q[i];
        }
        Q=newArr;
        return(temp);
    }
}
