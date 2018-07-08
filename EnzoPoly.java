/**
 * firs parameter degree second coefficent
 */

import utils.MapGrammar;
import utils.MapNode;
import java.util.Iterator;

public class EnzoPoly implements Polynomial{

    public MapGrammar<Double,Double> map;

    public EnzoPoly(){
        this.map = new MapGrammar<Double,Double>();
    }
    /**
     * This method add 2 polynoial together as in classic matematics
     */
    public void add(Polynomial b) throws UnsupportedOperationException{
        EnzoPoly tmp = (EnzoPoly) b;
        Iterator<MapNode<Double,Double>> it = tmp.map.map.iterator();

        if(it == null){
            throw new UnsupportedOperationException("Il polinomio inserito non ha coefficenti");
        }else{
            MapNode<Double,Double> x = it.next();
            while( x != null){
                Double degree = x.getKey();

                Double y = this.map.getValue(degree);
                if(y == null){
                    this.map.add(degree,x.getValue());
                }else{
                    this.map.add(degree,(y + x.getValue()));
                }
                x = it.next();
            }
        }
    }
    /**
     * This method returns a string representing the polynomial
     */
    public String toString(){
        Iterator<MapNode<Double,Double>> it = this.map.map.iterator();
        String out = "";
        if(it == null){
            out = "Null Polynomial";
        }else{
            MapNode<Double,Double> x = it.next();
            while(x != null){
                out += x.getValue()+"x^"+x.getKey()+ " ";
                x = it.next();
            }
        }
        return out;
    }

    public void add(Double coeff, Double degree){
        EnzoPoly b = new EnzoPoly();
        b.map.add(degree,coeff);
        this.add(b);
    }

    public Polynomial mult(Polynomial a){
        
        return new EnzoPoly();
    }
}