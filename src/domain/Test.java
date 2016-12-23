    package domain;  
      
    import java.io.IOException;  
    import java.io.Reader;  
    import org.apache.ibatis.io.Resources;  
    import org.apache.ibatis.session.SqlSession;  
    import org.apache.ibatis.session.SqlSessionFactory;  
    import org.apache.ibatis.session.SqlSessionFactoryBuilder;  
    import domain.tmpUser;  
      
    public class Test {  
        public static void main(String[] args) throws IOException {  
            String resource = "domain/configuration.xml";  
            Reader reader = Resources.getResourceAsReader(resource);  
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
            SqlSession session = ssf.openSession();  
            try {  
                tmpUser user = (tmpUser) session.selectOne("selectUser", "2");  
                System.out.println(user);  
            } catch (Exception e) {  
                e.printStackTrace();  
            } finally {  
                session.close();  
            }  
        }  
    }  