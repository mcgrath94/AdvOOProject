package gmit.sw.ie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StopWords {
	public static HashSet<String> stopWords = new HashSet<String>(); 
	int i;

	public StopWords(){
		// TODO Auto-generated constructor stub
		super();
		try {
			Parse("stopwords.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//check if word is a stopword
	public boolean isStopWord(String word)
	{
		boolean onList = false;
		if(stopWords.contains(word))
		{
			onList = true;
		}
		
		return onList;
	}
	
	// Add stopwords to set
	private void Parse(String filename) throws Exception {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer stringBuff = new StringBuffer();
		
		while((i = buffReader.read())!=-1)
		{
			char next = (char)i;
			if (next != '\n')
			{
				stringBuff.append(next);
			}
			
			else
			{
				String thisWord = stringBuff.toString().toUpperCase();
				stringBuff = new StringBuffer();				
				stopWords.add(thisWord);
			}
		}
		buffReader.close();
		System.out.println(stopWords);
	}
}


