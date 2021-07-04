
public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "BC";
		String str2 = "BANGALORE";
		String unMatchedString1 = "";
		String unMatchedString2 = "";
		
		//checking unmatched chars for first string
		for(int i = 0; i< str1.length(); i++) {
			boolean isCharPresent = false;
			for(int j = 0; j< str2.length(); j++) {
				char firstChar = str1.charAt(i);
				char secondChar = str2.charAt(j);
				if(firstChar == secondChar) {
					isCharPresent = true;
					break;
				}
				
			}
			if(!isCharPresent) {
				unMatchedString1 += str1.charAt(i);
			}
		}
		
		//checking unmatched chars for first string
				for(int i = 0; i< str2.length(); i++) {
					boolean isCharPresent = false;
					for(int j = 0; j< str1.length(); j++) {
						char firstChar = str2.charAt(i);
						char secondChar = str1.charAt(j);
						if(firstChar == secondChar) {
							isCharPresent = true;
							break;
						}
						
					}
					if(!isCharPresent) {
						unMatchedString2 += str2.charAt(i);
					}
				}
				
	 System.out.println("Option 1 : " + unMatchedString1);		
	 
	 System.out.println("Option 2 : " + unMatchedString2);	
	}

}
