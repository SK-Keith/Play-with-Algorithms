package kgyy.com.keith.volatileDemo;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/01/3 0003 13:43
 */
public class SharedVariableExample {
    private static volatile int abc = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread writer = new Thread(() -> {
            abc = 3;
            System.out.println("abc is set to 3");
        });

        Thread reader = new Thread(() -> {
           while (1 == 1) {
               // 等待
               System.out.println("abc is now " + abc);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }

        });

        writer.start();
        reader.start();
    }
}
