package learnHierarchy.impl;

import learnHierarchy.AbstractClass;

public class ClassImpl1 extends AbstractClass {

    @Override
    protected void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
