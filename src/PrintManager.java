import java.util.HashMap;
import java.util.Map;

public final class PrintManager {

  private final Map<Class <?>, Formatter<?>> register = new HashMap<>();

  public <T> PrintManager(Class<T> type, Formatter<T> formatType){
    register(type, formatType);

  }

  public <T> void register(Class<T> type, Formatter<T> formatType) {
    register.put(type, formatType);
  }

  private Formatter<Object> findFormatter(Class<?> clas) {
  
    Formatter<?> form = register.get(clas);
    if (form != null) {
      return (Formatter<Object>) form;
    }
    return null;

  }

  public <T> void print(T model) {
    findFormatter((Class<T>) model.getClass()).printFormat(model);
  }
 
}
