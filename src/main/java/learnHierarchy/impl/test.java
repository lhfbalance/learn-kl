package learnHierarchy.impl;


import learnHierarchy.AbstractClass;

public class test {

    public static void main(String[] args) {
        Noan2 o = new Noan2();
        o.method1();

        Noan3 noan3 = new Noan3();
        noan3.method();
        noan3.method1();

        AbstractClass ac = new ClassImpl1();
        ac.method();

    }

}
