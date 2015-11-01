package reflectSerializer;


import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Employee employee = new Employee("Roma","Mayun", "13300","First department", "developer",new Date(),10300.0);
        Employee friend = new Employee("Igor","XX", "13323","First department", "developer",new Date(),10000.0);
        List<String> list = new ArrayList<>();
        list.add("1-14-55");
        list.add("2-24-55");
        list.add("3-34-55");
        list.add("4-44-55");
        employee.setSupervisor(friend);
        employee.setPhoneNumbers(list);

        ParserRealization parser = new ParserRealization();
        try {
            parser.saveObject(createFile("D:/my.xml"),employee);

            Employee employee1 = (Employee)parser.getObject(new File("D:/my.xml"),Employee.class);
            System.out.println(employee1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static File createFile(String path){
        File file = null;
            try {
                file = new File(path);
                if (!file.exists()){
                file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return file;

    }
}
