import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DZS21{
    public static void main(String[] args) {
        class Gc {
            public static String inputStr;
        }
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))){
            Gc.inputStr = br.readLine();
            br.close();
        }
        catch(IOException ex){
            System.out.print("Ошибка :"+ex);
        }

        Gc.inputStr = Gc.inputStr.substring(1, Gc.inputStr.length() - 1);
        System.out.println(Gc.inputStr);

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM students WHERE ");

        String[] parts = Gc.inputStr.split (", ");
        boolean isFirst = true;

        for (String part : parts) {
            String[] keyValue = part.split (":");
            String key = keyValue[0];
            key = key.substring (1, key.length() - 1);
            String value = keyValue[1];
            System.out.println(key);
            System.out.println(value);

            if (value.equals ("\"null\""))
                continue;
            if (!isFirst)
                builder.append(" AND ");
            builder.append (String.format ("%s = %s", key, value));
            isFirst = false;
        }
        System.out.println(builder.toString());
    }
}
