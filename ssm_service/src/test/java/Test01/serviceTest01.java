package Test01;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-service.xml")
public class serviceTest01 {

    @Autowired
    private ProductService productService;

   /* @Test
    public void findAll(){
        List<Product> productList = productService.findAll();
        System.out.println(productList);
    }*/
}
