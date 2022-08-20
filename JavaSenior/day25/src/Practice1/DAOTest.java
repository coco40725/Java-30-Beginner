package Practice1;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Yu-Jing
 * @create 2022-07-29-AM 09:20
 */
public class DAOTest {
    @Test
    public void test(){
        DAO dat = new DAO();
        User user1 = new User("Gary",1,23);
        User user2 = new User("Marry",2,15);
        User user3 = new User("IB",3,12);
        User user4 = new User("Writer",4,57);

        dat.save("1",user1);
        dat.save("2",user2);
        dat.update("2",user4);
        List<User> list = dat.list();

        list.forEach(System.out::println);
    }
}
