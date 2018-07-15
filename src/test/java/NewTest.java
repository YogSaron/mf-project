import com.company.project.service.SysOutOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Created by Logan on 2018/7/15.
 */
@SpringBootTest
public class NewTest {
    @Autowired
    private SysOutOrderService sysOutOrderService;

    @Test
    public void testSomthing() {
        BigDecimal bg = sysOutOrderService.getPayable("2018-07-01","2018-09-01");
        System.out.println(bg);
    }
}
