package lr9.ex1;

public class Test3 {
    private static int step = 0;
    private static void count(int x){
        space();
        System.out.println(" " + x + "-> ");
        step++;
        if ((2 * x + 1) < 20){
            count(2 * x + 1);
        }
        step--;
        space();
        System.out.println(" " + x + " <-");
    }

    private static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        count(1);
    }
}
