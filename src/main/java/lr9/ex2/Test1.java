package lr9.ex2;

public class Test1 {
    private static void binarySystem(int n){
        if (n > 1){
            binarySystem(n / 2);
        }
        System.out.print(n % 2);
    }
public static void main(String[] args) {
    binarySystem(13);
}
}
