import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * author: MaiShuRen
 * site: http://www.maishuren.top
 * since: 2021-03-24 23:18
 **/
public class Student implements Serializable {
    //学号
    private int no;
    //姓名
    private String name;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String home = System.getProperty("user.home");
        String basePath = home + "/Desktop";
        FileOutputStream fos = new FileOutputStream(basePath + "student.dat");
        Student student = new Student();
        student.setNo(100);
        student.setName("TEST_STUDENT");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream(basePath + "student.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student deStudent = (Student) ois.readObject();
        ois.close();
        System.out.println(deStudent);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
