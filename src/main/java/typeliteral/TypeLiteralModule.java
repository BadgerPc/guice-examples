package typeliteral;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import java.util.ArrayList;
import java.util.List;

public class TypeLiteralModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<List<String>>() {
        }).toInstance(new ArrayList<String>() {{
            add("hello");
        }});

        bind(new TypeLiteral<List<Integer>>() {
        }).toInstance(new ArrayList<Integer>() {{
            add(123);
        }});

        bind(new TypeLiteral<MyGenericService<Integer>>(){}).to(MyIntegerService.class);
        bind(new TypeLiteral<MyGenericService<Double>>(){}).to(MyDoubleService.class);
    }
}
