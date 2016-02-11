package typeliteral;

public class MyIntegerService implements MyGenericService<Integer> {
    @Override
    public Integer get() {
        return 123;
    }
}
