import com.company.project.service.SysOutOrderService;
import com.conpany.project.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by Logan on 2018/7/15.
 */
public class NewTest extends Tester {
    @Autowired
    private SysOutOrderService sysOutOrderService;

    @Test
    public void testSomthing() {
        BigDecimal bg = sysOutOrderService.getPayable("2018-07-01","2018-09-01");
        System.out.println(bg);
    }
}
