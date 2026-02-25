package lr9.ex1;

public class Test1 {
    private static void count(int x){
        System.out.println("x= " + x);
        if ((2 * x + 1) < 20){
            count(2 * x + 1);
        }
    }
    public static void main(String[] args) {
        count(1);
    }


}
