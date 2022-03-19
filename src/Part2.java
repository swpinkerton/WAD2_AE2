public class Part2 {
    private Min_Array_heap ropes;

    public int connect(int rope1,int rope2){
        int lengths =ropes.getInstance(rope1)+ropes.getInstance(rope2);
        ropes.remove(rope1);
        ropes.remove(rope2);
        ropes.INSERT(lengths);
        return(lengths);
    }

    public void choose(){
        int l = ropes.length;
        int parent = ropes.PARENT(l);
        int last = ropes.getInstance(ropes.length);
        if(l>=3){
            if(parent%2==0) {

            }
        }
    }
}
