/*
 * Class name: PrintManager
 * 
 * Class description: this implements a printmanager that keeps track of the printer types. 
 */

import java.util.HashMap;
import java.util.Map;

public final class PrintManager {

  private final Map<Class <?>, Printer<?>> register = new HashMap<>();

  //tracker for the printer types
  public <T> void register(Class<T> type, Printer<T> formatType) {
    register.put(type, formatType);
  }

  // printer type finder
  @SuppressWarnings("unchecked")
  private Printer<Object> findPrinter(Class<?> clas) {
  
    Printer<?> form = register.get(clas);
    if (form != null) {
      return (Printer<Object>) form;
    }
    return null;

  }
  // print method
  @SuppressWarnings("unchecked")
  public <T> void print(T model) {
    findPrinter((Class<T>) model.getClass()).printFormat(model);
  }
 
}
