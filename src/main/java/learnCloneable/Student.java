package learnCloneable;

public class Student implements Cloneable {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "name:" + name + "; age:" + age;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student st1 = new Student("louhf", 28);
        Student st2 = (Student)st1.clone();
        st1.name = "louhf-1";
        st1.age = 27;
        System.out.println(st1);
        System.out.println(st2);
    }
}
