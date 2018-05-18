package learnCloneable;


public class Student2 implements Cloneable {

    String name;
    int age;

    Professor professor;

    Student2(String name, int age, Professor pro) {
        this.name = name;
        this.age = age;
        this.professor = pro;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student2 stu = (Student2) super.clone();
        stu.professor = (Professor) professor.clone();
        return stu;
    }

    @Override
    public String toString() {
        return "student{name:" + name + "; age:" + age + "}," + professor.toString();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student2 st1 = new Student2("louhf", 28, new Professor("ll", 35));
        Student2 st2 = (Student2)st1.clone();
        st1.name = "louhf-1";
        st1.age = 27;
        st1.professor.name = "ll-1";
        st1.professor.age = 36;
        System.out.println(st2);
        System.out.println(st1);
    }
}


