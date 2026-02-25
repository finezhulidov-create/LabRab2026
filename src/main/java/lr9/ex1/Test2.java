package lr9.ex1;

public class Test2 {
    private static void reverseCount(int x){
        if ((2 * x + 1) < 20){
            reverseCount(2 * x + 1);
        }
        System.out.println("x= " + x);
    }

    public static void main(String[] args) {
        reverseCount(1);
    }
}
