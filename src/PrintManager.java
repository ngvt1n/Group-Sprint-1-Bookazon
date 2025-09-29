import java.util.HashMap;
import java.util.Map;

public final class PrintManager {

  private final Map<Class <?>, Printer<?>> register = new HashMap<>();

  public <T> void register(Class<T> type, Printer<T> formatType) {
    register.put(type, formatType);
  }

  @SuppressWarnings("unchecked")
  private Printer<Object> findPrinter(Class<?> clas) {
  
    Printer<?> form = register.get(clas);
    if (form != null) {
      return (Printer<Object>) form;
    }
    return null;

  }

  @SuppressWarnings("unchecked")
  public <T> void print(T model) {
    findPrinter((Class<T>) model.getClass()).printFormat(model);
  }
 
}
