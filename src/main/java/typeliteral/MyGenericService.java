package typeliteral;

public interface MyGenericService<T extends Number> {
    T get();
}
