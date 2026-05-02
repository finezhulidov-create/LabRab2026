package lr13.ex1;

public class ex7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
          try{
              throw new ArithmeticException();
          } catch(ArithmeticException a){
              System.out.println("2" + a.getMessage());
          }
        } catch (ArithmeticException e) {
            System.out.println("2");
        }
        System.out.println("3");
    }

}
