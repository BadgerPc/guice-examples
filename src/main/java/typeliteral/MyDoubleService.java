package typeliteral;

public class MyDoubleService implements MyGenericService<Double> {
    @Override
    public Double get() {
        return 0.5;
    }
}
