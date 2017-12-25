package hacker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLFlipkart {
	static final String E = "<!ENTITY";
	public static void main(String[] args) {
		String[] xml = new String[] {
				"<!ENTITY a1 100>",
				"<!ENTITY a2 a1;a1>",
				"<!ENTITY a3 a2;a2>"
		};
		parser(10L, xml);
	}
	
	static class Entity{
		String name;
		String value;
		List<String> elements;
	}
	
	
	
	static void parser(Long l,String[] entities) {
		Map<String, Long> entitiesMap = new HashMap<String,Long>();
		long total = 0;
		for(int i=0;i<entities.length;i++) {
			String entity = entities[i];
			Entity e = parseEntity(entity);
			if(e == null) {
				System.out.println("0");
				System.exit(0);
			}else {
				long numberOfLines = 0;
				if(e.value != null) {
					numberOfLines = 1;
				}else if(e.elements!=null) {
					for(String el :e.elements) {
						numberOfLines += entitiesMap.get(el);
					}
				}
				entitiesMap.put(e.name, numberOfLines);
				total += numberOfLines;
			}
			
		}
		System.out.println(1+" "+total);
	}



	private static Entity parseEntity(String entityStr) {
		Entity entity = null;
		entityStr = entityStr.trim();
		String[] parsed = entityStr.split(" ");
		if(parsed != null && parsed.length>0) {
			if(E.equals(parsed[0])) {
				String name = null;
				String value = null;
				List<String> el = null;
				for(String str : parsed) {
					if(E.equals(str)) {
						continue;
					}
					if(!str.isEmpty()) {
						if(name==null){
							name = str;
						}else if(value==null && el ==null){
							int indexOfC = str.indexOf(">");
							if(indexOfC != -1) {
								str = str.substring(0,indexOfC).trim();
							}
							try {
								Integer.parseInt(str);
								value = str;
							}catch(NumberFormatException e) {
								String[] es = str.split(";");
								el=new ArrayList<String>();
								for(String ee:es) {
									el.add(ee);
								}
							}
						}
					}
				}
				if(name != null && (value != null || el!=null)) {
					entity = new Entity();
					entity.name = name;
					entity.value = value;
					entity.elements = el;
				}
			}
		}else {
			System.out.println("0");
			System.exit(0);
		}
		return entity;
	}
}
