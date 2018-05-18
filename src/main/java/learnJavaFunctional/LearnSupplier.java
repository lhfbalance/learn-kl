package learnJavaFunctional;

public class LearnSupplier {

    public static void main(String[] args) {

        SupplierHolder holder = new SupplierHolder(Bean1::new);

        System.out.println(holder.getSupplier().get());
        System.out.println(holder.getSupplier().get());
        System.out.println(holder.getSupplier().get());
        System.out.println(holder.getSupplier().get());

        SupplierHolder holder1 = new SupplierHolder(Bean1::createBean);

        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());

        SupplierHolder holder2 = new SupplierHolder(Bean1::new);

        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());
        System.out.println(holder1.getSupplier().get());

    }

}
