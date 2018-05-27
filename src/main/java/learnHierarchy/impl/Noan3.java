package learnHierarchy.impl;

import learnHierarchy.AbstractNoan;

public class Noan3 extends AbstractNoan {

    @Override
    public void method1() {
        method();
    }

    @Override
    public void method2() {
        method();
    }

    @Override
    protected void method() {
        System.out.println("change method");
    }
}
