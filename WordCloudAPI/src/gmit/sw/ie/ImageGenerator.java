package gmit.sw.ie;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageGenerator{
	
	Parser parser;
	int i;
	Graphics graphics;
	//BufferedImage img;
	
	public ImageGenerator(String filename, String imagename) throws Exception {
		super();
		parser = new Parser(filename);
		generateImage(imagename);
	}
	
	private void generateImage(String imagename) throws Exception {
		
		BufferedImage img = new BufferedImage(1080, 1080, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = img.getGraphics();
		
		Map<String, Integer> iMap = new HashMap<String, Integer>();
		iMap = parser.getWordMap();
		int x, y=50;
		//x = (int) Math.random();
		for(String word : iMap.keySet())
		{
			
			if(iMap.get(word) >= 1)
			{
				x = word.length();
				int height = wordWrite(word, iMap.get(word), x, y);
				y+=height;
			}
		}
		
		graphics.dispose();
		ImageIO.write(img, "png", new File("test1.png"));
	}
	
	private int wordWrite(String word, int freq, int x, int y)
	{
		int size = (int)(Math.log(freq)*20);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, size);
		Color color = changeColour();
		
		graphics.setColor(color);
		graphics.setFont(font);
		
		FontMetrics fm = graphics.getFontMetrics(font);
		int height=fm.getAscent()-(int)(fm.getDescent());			
		graphics.drawString(word, x, y+height);
		return height;
	}
	
	private static Color changeColour()
	{
		Color col = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		return col;
	}
}

