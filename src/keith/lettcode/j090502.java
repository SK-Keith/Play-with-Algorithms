package lettcode;

/**
 * @author MX.Y
 * @DATE 2021/9/5 19:03
 * @qq 2690399241
 */
public class j090502 {
    public static void main(String[] args) {
        int[] guess = new int[]{1, 2, 3};
        int game = game(guess, guess);
        System.out.println(game);
    }

    public static int game(int[] guess, int[] answer) {
        int num = 0;
        for(int i=0;i<guess.length;i++) {
            if (guess[i] == answer[i])
                num++;
        }
        return num;
    }
}
