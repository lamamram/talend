package routines;

import java.util.HashSet;

public class Slugyfier {

	/*
	 *  clean characters to fit in url
	 *  String.replaceAll remplace tous les motifs correspondant à une expression régulière en une chaîne de remplacement
	 */
	private static String clean(String subject) {
		return subject.replaceAll("[^\\w]", "-")
				.replaceAll("-+", "-")
				.replaceAll("^-|-$", "");
	}
	
	private static String join(String[] elements) {
		int limit = elements.length;
		String result = "";
		for (int i=0; i< limit; i++){
		    result += clean(elements[i]) + "-";
		}
		return result.replaceAll("-$", "").toLowerCase();
	}
	
	/**
	* {Category} User Defined
	*/
	public static String unique(String[] elements, HashSet<String> slugs) {
		String slug = join(elements);
		String slug0 = slug;
		for(int i=1; slugs.contains(slug); i++) {
			slug = slug0 + "-" + i;
		}
		return slug;
	}
}
