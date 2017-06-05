package angularbackend;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.niit.dao.UserDao;

@WebAppConfiguration
public class UserTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		UserDao ud = ctx.getBean(UserDao.class);
		assertNotNull(ud);
		ctx.close();
	}

}
