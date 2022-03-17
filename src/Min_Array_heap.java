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

    private int LEFT(int i){
        return(2*i)+1;
    }

    private int RIGHT(int i){
        return(2*i)+2;
    }

    private void BUILD_MIN_HEAP(int[] Q){
        for (int i = (Q.length/2) - 1; i >= 0; i-- ){
            MIN_HEAPIFY(Q,i,Q.length);
        }
    }

    private void MIN_HEAPIFY(int[] Q, int i, int n){
        int smallest;
        int l = LEFT(i);
        int r = RIGHT(i);
        if(l<n && Q[l] < Q[i]){
            smallest = l;
        }
        else{
            smallest = i;
        }
        if(l<n && Q[r] < Q[i]){
            smallest = r;
        }
        if(smallest != i){
            SWAP(Q, i, smallest);
            MIN_HEAPIFY(Q,smallest,n);
        }
    }

    private void SWAP(int[] Q, int i1, int i2){
        int temp = Q[i1];
        Q[i1] = Q[i2];
        Q[i2] = temp;
    }
}