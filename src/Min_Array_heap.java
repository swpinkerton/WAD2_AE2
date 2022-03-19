public class Min_Array_heap {
    static private int[] Q = new int[100];
    private static int length = 0;

    private static void INSERT(int[] Q, int x) {
        Q[length] = x;
        length += 1;
        moveUp(length - 1);
    }

    private static int MIN(int[] Q) {
        return (Q[0]);
    }

    private static int EXTRACT_MIN(int[] Q) {
        int temp = Q[0];
        Q[0] = Q[length-1];
        length = length -1;
        moveDown(0);
        return (temp);
    }

    private static int LEFT(int i) {
        return (2 * i) + 1;
    }

    private static int RIGHT(int i) {
        return (2 * i) + 2;
    }

    private static int PARENT(int i) {
        return (i - 1) / 2;
    }

    private static void SWAP(int i, int j) {
        int temp = Q[i];
        Q[i] = Q[j];
        Q[j] = temp;
    }

    private static void moveUp(int minPosition) {
        while (minPosition > 0 && Q[PARENT(minPosition)] > Q[minPosition]) {
            SWAP(PARENT(minPosition), minPosition);
            minPosition = PARENT(minPosition);
        }
    }

    private static void moveDown(int i)
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

    public static void main(String[] args)
    {

  /*           45
            /        \
           31      14
          /  \    /  \
         13  20  7   11
        /  \
       12   7
    Create a priority queue shown in
    example in a binary max heap form.
    Queue will be represented in the
    form of array as:
    45 31 14 13 20 7 11 12 7 */

        // Insert the element to the
        // priority queue
        INSERT(Q,45);
        INSERT(Q,20);
        INSERT(Q,14);
        INSERT(Q,12);
        INSERT(Q,31);
        INSERT(Q,7);
        INSERT(Q,11);
        INSERT(Q,13);
        INSERT(Q,7);

        int i = 0;

        // Priority queue before extracting max
        System.out.print("Priority Queue : ");
        while (i <= length-1)
        {
            System.out.print(Q[i] + " ");
            i++;
        }

        System.out.print("\n");

        // Node with maximum priority
        System.out.print("Node with maximum priority : " +
                EXTRACT_MIN(Q) + "\n");

        // Priority queue after extracting max
        System.out.print("Priority queue after " +
                "extracting maximum : ");
        int j = 0;
        while (j <= length-1)
        {
            System.out.print(Q[j] + " ");
            j++;
        }

        System.out.print("\n");
    }
}