package gmit.sw.ie;


import java.io.*;
import java.util.*;

public class Parser {
	
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private StopWords stopWordsSet = new StopWords();
	
	int i, freq=0;
	
	public Parser(String filename){
		
		super();
		try {
			parse(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void Parse(String filename) throws Exception
	private Map<String, Integer> parse(String filename) throws Exception
	{
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer stringBuff = new StringBuffer();
		
		while((i = buffReader.read())!=-1)
		{
		char next = (char)i;
		
		if ((next <= 'z' && next >= 'A') || next == '\''){
			stringBuff.append(next);
		}
		else 
		{
			String word = stringBuff.toString().toUpperCase();
			stringBuff = new StringBuffer();
			
			//if word not stopword, add to map
			if(!stopWordsSet.isStopWord(word) && word.length()>1)
			{		
				if(wordMap.containsKey(word))
				{
					freq = wordMap.get(word);
				}
				freq++;
				wordMap.put(word, freq);
			}
		}
		}
	for(String word : wordMap.keySet())  {
	
	
	}
	buffReader.close();
	setWordMap(wordMap);
	return wordMap;
	}		
	
	public Map<String, Integer> getWordMap() throws Exception {
	return wordMap;
	}

	public void setWordMap(Map<String, Integer> wordMap) {
	this.wordMap = wordMap;
	}

}
	

