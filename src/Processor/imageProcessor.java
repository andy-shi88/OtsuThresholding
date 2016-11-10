package Processor;

import constants.imageConfiguration;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class imageProcessor {
    
    public imageProcessor() {
        
    }
    
    public BufferedImage convertMatToBM(ArrayList<ArrayList<Double>> input){
        BufferedImage result = new BufferedImage(input.size(), input.get(0).size(), BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i< input.size(); i++){
            for (int j = 0; j<input.get(i).size(); j++) {
                int gray = (int)Math.round(input.get(i).get(j));
                Color c = new Color(gray, gray, gray);
                result.setRGB(i, j, c.getRGB());
            } 
        }
        return result;
    }
    
    public ArrayList<ArrayList<Double>> getBinarizeArrayList(ArrayList<ArrayList<Double>> input, double threshold, int mode) {
       ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Double> temp_row = new ArrayList<Double>();
            for (int j = 0; j < input.get(i).size(); j++) {
                double curr_val = input.get(i).get(j);
                if(curr_val < threshold) {
                    if(mode == imageConfiguration.BLACK_WHITE) {
                        temp_row.add(255.0);
                    } else if (mode == imageConfiguration.BLACK_ORI) {
                        temp_row.add(curr_val);
                    }
                } else {
                    temp_row.add(0.0);
                }
            }
            result.add(temp_row);
        }
        return result;
    }
    
    public static ArrayList<ArrayList<Double>> getPixelArrayList(BufferedImage input)
    {
	ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
	for(int i = 0; i< input.getHeight(); i++) {
            ArrayList<Double> temp_row = new ArrayList<Double>();
            for (int j = 0; j < input.getWidth(); j++) {
                Color c = new Color(input.getRGB(i, j));
                int red = (int)(c.getRed() * 0.299);
                int green = (int)(c.getGreen() * 0.587);
                int blue = (int)(c.getBlue() *0.114);
                int gray = red + green + blue;
                temp_row.add((double)gray); //retrieve gray scale pixel value of the image
            }
            result.add(temp_row);
	}
	return result;
    }
    public static BufferedImage scale(BufferedImage src, int w, int h)
    {
	  BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  int x, y;
	  int ww = src.getWidth();
	  int hh = src.getHeight();
	  for (x = 0; x < w; x++) {
	    for (y = 0; y < h; y++) {
	      int col = src.getRGB(x * ww / w, y * hh / h);
	      img.setRGB(x, y, col);
	    }
	  }
	  return img;
    }
}
