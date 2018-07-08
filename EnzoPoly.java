/**
 * firs parameter degree second coefficent
 */

import utils.MapGrammar;

public class EnzoPoly implements Polynomial{

    public MapGrammar<Double,Double> map;

    public EnzoPoly(){
        this.map = new MapGrammar<Double,Double>();
    }

    public void add(Polynomial b){
        
    }

    public void add(Double coeff, Double degree){
        this.map.add(degree, coeff);
    }

    public Polynomial mult(Polynomial a){
        
        return new EnzoPoly();
    }
}