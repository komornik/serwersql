package pl.projektDB.model;

import java.lang.reflect.Method;

/**
 * Pomocnicze metody do konwersji typów
 * 
 * @author pawel@kasprowski.pl
 * 
 */
public class ReflectionHelper {
	
	/**
	 * Zwraca typ pierwszego parametru metody o podanej nazwie dla podanego obiektu
	 * @param obj
	 * @param metName
	 * @return
	 */
	public static Class<?> findParamClass(Object obj,String metName) {
		Class<?> c = obj.getClass();
		Method[] methods = c.getDeclaredMethods();
		for(Method m:methods) {
			System.out.println("Metoda: "+m.getName());
			if(m.getName().equals(metName))
				return m.getParameterTypes()[0];
		}
		return null;
	}
	
	/**
	 * Konwertuje podany String na obiekt podanej klasy (odwrotnoœæ toString())
	 * @param txt
	 * @param clazz
	 * @return obiekt klasy clazz o wartoœci ze Stringa txt
	 */
	public static Object convertStringToClass(String txt,Class<?> clazz) {
		if(clazz.equals(String.class))
			return txt;
		if(clazz.equals(Integer.class) || clazz.equals(int.class))
			return Integer.parseInt(txt);
		if(clazz.equals(Double.class) || clazz.equals(double.class))
			return Double.parseDouble(txt);
		return null;
	}

}
