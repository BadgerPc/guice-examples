package test;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;
import privatemodule.English;
import privatemodule.Japanese;
import privatemodule.MyPrivateModules;
import privatemodule.MyService;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrivateModuleTest {

    // (1) call for injection of MyService annotated as @English
    @Inject
    @English
    MyService englishService;

    // (2) call for injection of MyService annotated as @Japanese
    @Inject
    @Japanese
    MyService japaneseService;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new MyPrivateModules()).injectMembers(this);
    }

    @Test
    public void englishServiceShouldSayHello() throws Exception {
        assertThat(englishService.greetings(), is("Hello"));
    }

    @Test
    public void japaneseServiceShouldSayKonnichiwa() throws Exception {
        assertThat(japaneseService.greetings(), is("Konnichiwa"));
    }
}
