package test01;

import com.itheima.dao.OrdersMapper;
import com.itheima.dao.ProductMapper;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void findAll(){
        List<Product> productList = productMapper.findAll(1,3);
        System.out.println(productList);
    }

    @Test
    public void test1(){
        Orders byId = ordersMapper.findById("2FF351C4AC744E2092DCF08CFD314420");
        System.out.println(byId);
    }
}
