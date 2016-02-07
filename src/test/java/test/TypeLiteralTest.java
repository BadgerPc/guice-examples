package test;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;
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
}
