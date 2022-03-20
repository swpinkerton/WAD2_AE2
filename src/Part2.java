import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
    private static Min_Array_heap ropes = new Min_Array_heap();

//    public static int connect(ArrayList<Integer> tbc){
//
//        for (int e = 1; e < tbc.size(); e++) {
//            tbc.set(e, tbc.get(e) + tbc.get(e - 1));
//        }
//        if(tbc.size()>1) {
//            return (tbc.get(tbc.size() - 1));
//        }
//        return 0;
//    }
//
//    public static ArrayList<Integer> choose(int total){
//        int remaining = total;
//        int temp;
//        ArrayList<Integer> chosen = new ArrayList<>();
//        while(remaining>0){
//            temp = 0;
//            for(int e=ropes.length-1; e>=0; e--){
//                if(ropes.getInstance(e) <= remaining){
//                    if(ropes.getInstance(e) > ropes.getInstance(temp)) {
//                        temp = e;
//                    }
//                }
//            }
//            remaining -= ropes.getInstance(temp);
//            chosen.add(ropes.getInstance(temp));
//            System.out.println(ropes.getInstance(temp));
//            ropes.remove(temp);
//        }
//        Collections.sort(chosen);
//        return chosen;
//    }
//
//    public static int min_cost(){
//        int big_rope = 0;
//        int cost = 0;
//        int temp;
//        while(ropes.length>0){
//            if((ropes.getInstance(2) > ropes.getInstance(1) && ropes.length > 2) || ropes.length == 2 ){
//                temp = ropes.MIN() + ropes.getInstance(1);
//            }
//            else if((ropes.getInstance(2) < ropes.getInstance(1) && ropes.length > 2)){
//                temp = ropes.MIN() + ropes.getInstance(2);
//            }
//            else {
//                temp = big_rope +1;
//            }
//            if(temp<big_rope){
//                int min1 = ropes.EXTRACT_MIN();
//                int min2 = ropes.EXTRACT_MIN();
//                cost = cost + min1 + min2;
//                ropes.INSERT(min1+min2);
//            }
//            else if (cost != 0){
//                int min1 = ropes.EXTRACT_MIN();
//                cost += big_rope + min1;
//                big_rope += min1;
//            }
//            else{
//                int min1 = ropes.EXTRACT_MIN();
//                int min2 = ropes.EXTRACT_MIN();
//                cost = cost + min1 + min2;
//                big_rope += min1+min2;
//            }
//        }
//        return cost;
//    }

    public static int min_cost2(){
        int cost = 0;
        while(ropes.length>1){
            int min1 = ropes.EXTRACT_MIN();
            int min2 = ropes.EXTRACT_MIN();
            cost = cost + min1 + min2;
            ropes.INSERT(min1+min2);
        }
        return cost;
    }

    public static void main(String[] args)
    {
////        4,8,3,1,6,9,12,7,2
        ropes.INSERT(4);
        ropes.INSERT(8);
        ropes.INSERT(3);
        ropes.INSERT(1);
        ropes.INSERT(6);
        ropes.INSERT(9);
        ropes.INSERT(12);
        ropes.INSERT(7);
        ropes.INSERT(2);
//        ropes.INSERT(10);
//        ropes.INSERT(1);
//        ropes.INSERT(1);
        int j = 0;
        while (j <= ropes.length-1) {
            System.out.print(ropes.getInstance(j) + " ");
            j++;
        }
        System.out.println("cost " + min_cost2());
    }
}