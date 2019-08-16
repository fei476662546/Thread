import com.dao.UserMapper;
import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Create by mysteriousTime
 * time on 2019/8/13  14:25
 */
public class TestInsert {
    SqlSessionFactory factory;

    @Before
    public void init() {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("config.xml");
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   @Test
    public void insert(){
       SqlSession session=factory.openSession();
      UserMapper mapper= session.getMapper(UserMapper.class);
       User user=new User(1,"李白","123");
      int result=mapper.addUser(user);
       System.out.println("插入结果："+result);
       session.commit();
       session.close();

   }

}
