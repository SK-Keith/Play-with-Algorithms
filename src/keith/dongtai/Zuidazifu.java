package dongtai;

/**
 * @author MX.Y
 * @DATE 2021/12/28 22:37
 */
public class Zuidazifu {
    public static void main(String[] args) {
        Zuidazifu z = new Zuidazifu();
        String babad = z.longestPalindrome("babad");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int minLength = 1;
        int index = 0;
        boolean[][] flag = new boolean[length][length];
        for(int i = 0;i < length;i++) {
            flag[i][i] = true;
        }
        char[] ss = s.toCharArray();
        for(int L =2; L <= length;L++) {
            for(int i = 0;i< length;i++) {
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }

                if(ss[i] != ss[j]) {
                    flag[i][j] = false;
                } else {
                    if (j - i < 3) {
                        flag[i][j] = true;
                    } else {
                        // 从四位开始，要跟第二位的布尔值相同，否则，里面为false，外面为true，也是false
                        flag[i][j] = flag[i+1][j-1];
                    }
                }

                if(flag[i][j] && minLength < j - i +1 ){
                    minLength = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + minLength);
    }
}
