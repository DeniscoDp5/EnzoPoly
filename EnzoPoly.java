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

    public void add(double coeff, double degree){
        EnzoPoly b = new EnzoPoly();
        b.map.add((Double) degree,(Double) coeff);
        this.add(b);
    }

    public Polynomial mult(Polynomial a){
        
        Polynomial res = new EnzoPoly();
        Iterator<MapNode<Double,Double>> it= this.map.map.iterator();
        MapNode x = it.next();
        while(x != null){
            EnzoPoly tmp = (EnzoPoly) a;
            Iterator<MapNode<Double,Double>> it2 = tmp.map.map.iterator();
            MapNode y = it2.next();
            while(y != null){
                Double degree = (double)x.getKey() + (double)y.getKey();
                Double coeff = (double) x.getValue() * (double)y.getValue();
                res.add(coeff,degree);
                 
                y= it2.next();
            }
            x = it.next();
        }
        return res;
    }
}