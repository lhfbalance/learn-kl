package learnJavaFunctional;

import java.util.function.Supplier;

public class SupplierHolder<S> {

    private final Supplier<S> supplier;

    SupplierHolder(final Supplier<S> supplierMethod) {
        this.supplier = supplierMethod;
    }

    public Supplier<S> getSupplier() {
        return supplier;
    }
}
