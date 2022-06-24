package routines;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class Convert {
	
	// attributs statiques
	public static String[] old_roles = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	public static String[] new_roles = {"dev", "admin", "test", "marketing", "other", "other", "other","other","other"};
	
	public static HashMap<String, String> mapping = new HashMap<>();
	static {
		mapping.put("0", "dev");
		mapping.put("1", "dev");
		mapping.put("2", "dev");
		mapping.put("3", "dev");
		mapping.put("4", "dev");
		mapping.put("5", "other");
		mapping.put("6", "other");
		mapping.put("7", "other");
		mapping.put("8", "other");
	}
	

    /**
     * toBoolean: converts a string to boolean depending on a certain value.
     * 
     * 
     * {talendTypes} String, String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") target: The string to convert.
     * {param} string("on") pivot: The string to be compared to.
     * 
     * {example} toBoolean("world", "on") # false.
     */
    public static boolean toBoolean(String target, String pivot) {
        return  pivot.equals(target); 
    }
    
	/**
     * toMap: converts a String to another String depending on association tabs.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") target: old value.
     * 
     * {example} toMap("0") # dev.
     */
    public static String toMap(String target) {
		List<String> l = Arrays.asList(old_roles);
		if (! l.contains(target)){
			return "other";
		}
		return new_roles[l.indexOf(target)];
    }
    
    public static String toMap2(String target) {
		if(! mapping.containsKey(target)) {
			return "other";
		}
		return mapping.get(target);
    }
    
    
    
}
