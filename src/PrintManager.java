import java.util.HashMap;
import java.util.Map;

public final class PrintManager {

  private final Map<Class <?>, Printer<?>> register = new HashMap<>();

  public <T> PrintManager(Class<T> type, Printer<T> formatType){
    register(type, formatType);

  }

  public <T> void register(Class<T> type, Printer<T> formatType) {
    register.put(type, formatType);
  }

  private Printer<Object> findPrinter(Class<?> clas) {
  
    Printer<?> form = register.get(clas);
    if (form != null) {
      return (Printer<Object>) form;
    }
    return null;

  }

  public <T> void print(T model) {
    findPrinter((Class<T>) model.getClass()).printFormat(model);
  }
 
}
