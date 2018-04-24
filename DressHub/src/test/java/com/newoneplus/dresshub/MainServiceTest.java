package com.newoneplus.dresshub;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.applet.Main;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class MainServiceTest {

    private MainService mainService;

    @Before
    public void setup() throws ClassNotFoundException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        mainService = applicationContext.getBean("mainService", MainService.class);
    }

    @Test
    public void getProductList() throws ClassNotFoundException {
        ArrayList<Product> productList = new ArrayList<>();
        productList= mainService.getProductList();
        assertThat(productList.size(), is(6));
    }

    @Test
    public void getProduct() throws ClassNotFoundException {
        Product product = new Product();
        product = mainService.getProduct(1);
        assertThat(product.getName(), is("changedName"));
    }
}