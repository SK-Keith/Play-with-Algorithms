package kgyy.com.keith.copy;

import java.io.*;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/12 0012 16:49
 */
public class DeepCopyUtil {

    public static <T> T deepCopy(T obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user);
        user.setId(1L);
        user.setName("111");
        System.out.println(user);
        User user1 = deepCopy(user);
        System.out.println(user1);
    }
}
