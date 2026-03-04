import java.util.*;

public class StudentManager {

    public static void removePoorStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Влад Откав", "Группа А", 2, Arrays.asList(5, 4, 5, 4));
        Student s2 = new Student("Юрий Пурий", "Группа А", 2, Arrays.asList(3, 2, 4, 3)); // средний 3.0? (3+2+4+3=12/4=3.0)
        Student s3 = new Student("Сидор Пивов", "Группа Б", 2, Arrays.asList(2, 2, 3, 2)); // средний 2.25
        Student s4 = new Student("Анна Вах", "Группа Б", 3, Arrays.asList(5, 5, 5, 5)); // средний 5.0

        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println("=== Исходный список студентов ===");
        for (Student s : students) {
            System.out.println(s);
        }

        removePoorStudents(students);
        System.out.println("\n=== После удаления студентов с баллом < 3 ===");
        for (Student s : students) {
            System.out.println(s);
        }

        promoteStudents(students);
        System.out.println("\n=== После перевода на следующий курс ===");
        for (Student s : students) {
            System.out.println(s);
        }

        printStudents(students, 3);
    }
}