package test;

import asssitedinject.MyAssistedInjectModule;
import asssitedinject.MyFactory;
import asssitedinject.MyProduct;
import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssistedInjectTest {

    @Inject
    MyFactory factory;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new MyAssistedInjectModule()).injectMembers(this);
    }

    @Test
    public void test() throws Exception {
        final MyProduct product = factory.create("kyle");

        assertThat(product.greetings(), is("hello, kyle"));
    }
}
