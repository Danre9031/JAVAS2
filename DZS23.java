
// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, 
// используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DZS33 {
    public static void main(String[] args) {
        class Gc {
            public static String inputStr;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("test2.txt"))) {
            Gc.inputStr = br.readLine();
            br.close();
        } catch (IOException ex) {
            System.out.print("Ошибка :" + ex);
        }

        Gc.inputStr = Gc.inputStr.substring(1, Gc.inputStr.length() - 1);
        String[] students = Gc.inputStr.split(", ");

        for (String student : students) {
            student = student.substring(1, student.length() - 1);
            String[] keyValues = student.split(",");
            String name = "", mark = "", subject = "";

            for (String keyValue : keyValues) {
                String[] keyValueParts = keyValue.split(":");

                String key = keyValueParts[0];
                key = key.substring(1, key.length() - 1);
                String value = keyValueParts[1];
                value = value.substring(1, value.length() - 1);

                if (key.equals("фамилия"))
                    name = value;
                else if (key.equals("оценка"))
                    mark = value;
                else if (key.equals("предмет"))
                    subject = value;
                else
                    throw new IllegalStateException("Ошибка ввода(неправильное поле)");
            }
            System.out.printf("Студнт %s получил %s по предмету %s \n", name, mark, subject);
        }
    }
}
