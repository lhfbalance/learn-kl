package learnCloneable;


public class Student1 implements Cloneable {

    String name;
    int age;

    Professor professor;

    Student1(String name, int age, Professor pro) {
        this.name = name;
        this.age = age;
        this.professor = pro;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "student{name:" + name + "; age:" + age + "}," + professor.toString();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student1 st1 = new Student1("louhf", 28, new Professor("ll", 35));
        Student1 st2 = (Student1)st1.clone();
        st1.name = "louhf-1";
        st1.age = 27;
        st1.professor.name = "ll-1";
        st2.professor.age = 36;
        System.out.println(st2);
        System.out.println(st1);
    }
}


