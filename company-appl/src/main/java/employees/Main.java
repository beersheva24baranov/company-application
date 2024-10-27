package employees;
import io.Persistable;
import view.*;
    public class Main {
        public static void main(String[] args) {
            try {
                Company company = new CompanyImpl();
    
                if (company instanceof Persistable persistable) {
                    persistable.restoreFromFile("employees.data");
                }
    
                Item[] items = CompanyItems.getItems(company);
                Menu menu = new Menu("Company Application", items);
                menu.perform(new StandardInputOutput());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }