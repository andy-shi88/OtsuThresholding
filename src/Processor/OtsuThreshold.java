package Processor;

import java.util.ArrayList;

public class OtsuThreshold {
    private ArrayList<Integer> histogram;
    private ArrayList<Double> inClassVariance;
    private ArrayList<ArrayList<Double>> input_image;
    
    private final int max_pix_val = 255;
    private int hist_threshold;
    private int n_level;
    int total_pixel;
    int threshold = 128;
    
    public OtsuThreshold() {
        this.histogram = new ArrayList<>();
        this.input_image = new ArrayList<ArrayList<Double>>();
        this.n_level = 2;
    }
    public OtsuThreshold(ArrayList<ArrayList<Double>> input) {
        this.n_level = 2;
        this.histogram = new ArrayList<Integer>(this.n_level);
        this.inClassVariance = new ArrayList<Double>(this.n_level);
        for(int i = 0; i <= n_level; i++) {
            this.histogram.add(0);
            this.inClassVariance.add(0.0);
        }
        this.input_image = input;  
        this.total_pixel = input.size() * input.get(0).size();
    }
    /*
    *@param: input is the arraylist of bufferedImage (grayscale)
    *@param: n_levels is the number of histogram category we want to calculate
    */
    public OtsuThreshold(ArrayList<ArrayList<Double>> input, int n_level) { 
        this.n_level = n_level;
        this.histogram = new ArrayList<>(n_level);
        this.inClassVariance = new ArrayList<>(this.n_level);
        for(int i = 0; i < n_level; i++) {
            this.histogram.add(0);
            this.inClassVariance.add(0.0);
        }
        this.input_image = input;
        double temp_ = (double)this.max_pix_val / (double)n_level;
        this.hist_threshold = (int)Math.ceil(temp_);
//        this.total_pixel = 36;
        this.total_pixel = this.input_image.size() * this.input_image.get(0).size();
    }
    private int getMinimumIndex() {
        int result = 0;
        double temp_min = Double.MAX_VALUE;
        for (int i = 0; i < this.histogram.size(); i++) {
            if(this.inClassVariance.get(i) < temp_min){
                temp_min = this.inClassVariance.get(i);
                result = i;
            }
        }
        return result;
    }
    /*
    * all calculation happens here, to get one (range of) threshold
    */
    public void calculateThreshold() {
        //fill the histogram
        this.generateHistogram();
        for (int i = 0; i < this.n_level; i++) { //calculate on every cat in the histogram
            double variance_back = 0.0;
            double variance_fore = 0.0;
            int sum_fore = 0;
            int sum_back = 0;
            double weight_fore = 0.0;
            double mean_fore = 0.0;
            double weight_back = 0.0;
            double mean_back = 0.0;
            for (int j = 0; j < i; j++) { //background
                int curr_val = this.histogram.get(j);
                //calculate weight
                weight_back += curr_val;
                //calculate mean
                mean_back += (j*curr_val);
                //get the total of pixel in range
                sum_back += curr_val;
            }
            weight_back = weight_back / this.total_pixel;
            mean_back = mean_back / sum_back;
            //calculate background variance 
            for (int j = 0; j < i; j++) { //background
                int curr_val = this.histogram.get(j);
                variance_back += (Math.pow((j - mean_back),2) * curr_val);
            }
            variance_back = variance_back / sum_back;
            
            for (int j = i; j < this.n_level; j++){ //background
                int curr_val = this.histogram.get(j);
                //calculate weight
                weight_fore += curr_val;
                //calculate mean
                mean_fore += (j*curr_val);
                //get the total of pixel in range
                sum_fore += curr_val;
            }
            weight_fore = weight_fore / this.total_pixel;
            mean_fore = mean_fore / sum_fore;
            //calculate foreground variance 
            for (int j = i; j < this.n_level; j++) { //foreground
                int curr_val = this.histogram.get(j);
                variance_fore += (Math.pow((j - mean_fore),2) * curr_val);
            }
            variance_fore = variance_fore / sum_fore;
            double in_classVar = (weight_back*variance_back) + (weight_fore*variance_fore);
            this.inClassVariance.set(i, in_classVar);
        }
        this.threshold = this.hist_threshold * (this.getMinimumIndex()+1);
    }
    public double getThreshold() {
        return this.threshold;
    }
    /*
    *Function: get the histogram, based on n_level variable to the histogram arraylist
    */
    private void generateHistogram() {
        for (int i = 0; i < this.input_image.size(); i++) { //loop through the whole input
            for (int j =0; j < this.input_image.get(i).size(); j++) {
                double curr_pixel = this.input_image.get(i).get(j);
                int hist_index = (int)Math.ceil(((curr_pixel-0.0001) / (double)this.hist_threshold - 1)); //get the range of current pixel value
                if(hist_index < 0){
                    hist_index++;
                }
                this.histogram.set(hist_index, this.histogram.get(hist_index) + 1); //increment at index = ceil(value / n-level)
            }
        }
    }
    
}
