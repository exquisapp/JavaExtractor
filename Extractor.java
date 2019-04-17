import java.io.*; 
import java.util.*;
import java.math.*;

class Extractor{
	public static void main(String args[]) throws Exception {
		String filePath = "C:\\Users\\user\\Documents\\dev\\myjavaextractor\\fileToExtractfrom.html";
  		File file = new File(filePath); 
  
 		BufferedReader br = new BufferedReader(new FileReader(file)); 
  
 		String st;
 		int counter = 0;
 		String htmlString = "";
 		while ((st = br.readLine()) != null) {

				String[] words= st.split("\\s");
 				for (int i=0;i< words.length; i++){
 					if (words[i].contains("gg-url=")){ 						
 						// System.out.println(words[i]);
 						String[] newWords = words[i].split("=");
 						htmlString = htmlString.concat("<a target=\"_blank\" href = " + newWords[1] +  ">"+ "<img src=" + newWords[1] +" style='width: 100px'/></a> <br />");

 					}

 				}


 			counter++;
 			
 		}

 		BufferedWriter writer = new BufferedWriter(new FileWriter("Extracted.html"));
    	writer.write(htmlString);
     
    	writer.close();
	}
}