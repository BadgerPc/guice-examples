package test;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;
import typeliteral.MyGenericService;
import typeliteral.TypeLiteralModule;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypeLiteralTest {

    @Inject
    List<String> stringList;
    @Inject
    List<Integer> integerList;
    @Inject
    MyGenericService<Integer> integerService;
    @Inject
    MyGenericService<Double> doubleService;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new TypeLiteralModule()).injectMembers(this);
    }

    @Test
    public void stringListShouldContainsHello() throws Exception {
        assertThat(stringList.get(0), is("hello"));
    }

    @Test
    public void integerListShouldContainsHello() throws Exception {
        assertThat(integerList.get(0), is(123));
    }

    @Test
    public void integerServiceShouldReturn123() throws Exception {
        assertThat(integerService.get(), is(123));
    }

    @Test
    public void doubleServiceShouldReturn0_5() throws Exception {
        assertThat(doubleService.get(), is(0.5));
    }
}
