package minMax3;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MX.Y
 * @DATE 2021/11/25 1:23
 * @qq 2690399241
 */
public class Demo {
    public static void main(String[] args) {
//        String msg = "0->2;2->4;4->3;";
//        String[] split = msg.split(";");
//        int valueSum = 0;
//        for (String s : split) {
//            String[] split1 = s.split("->");
//            valueSum += Integer.parseInt(split1[1]);
//        }
//        System.out.println(valueSum);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.forEach(System.out::print);
        System.out.println();
        System.out.println(StringUtils.join(list, ","));
    }
}
