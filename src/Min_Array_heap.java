public class Min_Array_heap {
    static private int[] Q = new int[100];
    public static int length = 0;

    protected void INSERT(int x) {
        Q[length] = x;
        length += 1;
        moveUp(length - 1);
    }

    protected int MIN() {
        return (Q[0]);
    }

    protected int EXTRACT_MIN() {
        int temp = Q[0];
        Q[0] = Q[length-1];
        length = length -1;
        moveDown(0);
        return (temp);
    }

    protected static int LEFT(int i) {
        return (2 * i) + 1;
    }

    protected static int RIGHT(int i) {
        return (2 * i) + 2;
    }

    protected static int PARENT(int i) {
        return (i - 1) / 2;
    }

    protected static void SWAP(int i, int j) {
        int temp = Q[i];
        Q[i] = Q[j];
        Q[j] = temp;
    }

    protected static void moveUp(int minPosition) {
        while (minPosition > 0 && Q[PARENT(minPosition)] > Q[minPosition]) {
            SWAP(PARENT(minPosition), minPosition);
            minPosition = PARENT(minPosition);
        }
    }

    protected static void moveDown(int i)
    {
        int minI = i;
        int l = LEFT(i);
        int r = RIGHT(i);
        if (r <= length-1 && Q[r] < Q[minI])
        {
            minI = r;
        }
        if (l <= length-1 && Q[l] < Q[minI])
        {
            minI = l;
        }
        if (i != minI)
        {
            SWAP(i, minI);
            moveDown(minI);
        }
    }

    protected int getInstance(int i) {
        return(Q[i]);
    }

    protected void remove(int i) {
        Q[i] = this.MIN() + 1;
        moveUp(i);
        EXTRACT_MIN();
    }

    public static void main(String[] args)
    {
        Min_Array_heap Q = new Min_Array_heap();
        Q.INSERT(10);
        Q.INSERT(15);
        Q.INSERT(7);
        Q.INSERT(9);
        Q.INSERT(4);
        Q.INSERT(13);
//        Q.INSERT(50);

        int i = 0;
        System.out.print("Queue : ");
        while (i <= length-1) {
            System.out.print(Q.getInstance(i) + " ");
            i++;
        }
        System.out.print("\n");

        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        int j = 0;
        while (j <= length-1) {
            System.out.print(Q.getInstance(j) + " ");
            j++;
        }
        System.out.print("\n");
        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        System.out.print("min : " + Q.EXTRACT_MIN() + "\n");
        System.out.print("queue after " + "extracting min : ");

        System.out.print("\n");
    }
}