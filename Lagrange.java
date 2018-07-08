import java.util.*;

/**
 * @author Giacomo
 *
 */
public class Lagrange {
	Polynomial starter;
	Vector<Point> points = new Vector<Point>();
	Vector<Polynomial> polinomiDelNumeratore = new Vector<Polynomial>();
	Vector<Double> denominatori = new Vector<Double>();
	Vector<Polynomial> yFrattoDen = new Vector<Polynomial>();

	/**
	 * @param x
	 * @param y
	 */
	public void addPolynomialPoint(double x, double y) {
		Polynomial p = new Polynomial();
		p.add(1, 1); // coefficente, esponente
		p.add(-x, 0);
		polinomiDelNumeratore.add(p);
		Point punt = new Point(x, y);
		points.add(punt);
	}

	public void creaDen(int n_termine) {
		double denominatore = 1;
		Iterator<Point> itg = points.iterator();
		for (int i = 0; itg.hasNext(); i++) {
			if (n_termine != i) {
				denominatore = denominatore * (points.get(n_termine).getX() - points.get(i).getX());
			}
			itg.next();
		}
	}

	public void creaNumeratore() {
		Polynomial numeratore = new Polynomial();
		numeratore.add(1,0);
		Iterator<Polynomial> itg = polinomiDelNumeratore.iterator();
		for (int i = 0; itg.hasNext(); i++) {
			numeratore = numeratore.mult(polinomiDelNumeratore.get(i));
			itg.next();
		}
	}

	/**
	 * 
	 */
	public void creaYFrattoDen() {
		Iterator<Point> itg = points.iterator();
		Polynomial p = new Polynomial();
		for (int i = 0; itg.hasNext(); i++) {
			p.add( points.get(i).getY() / denominatori.get(i), 0);
			yFrattoDen.add(p);
			itg.next();
		}
	}
	
	public Polynomial completa(){
		Polynomial lagrange = new Polynomial();
		Iterator<Polynomial> itg = polinomiDelNumeratore.iterator();
		Polynomial temp;
		for (int i = 0; itg.hasNext(); i++) {
			temp = polinomiDelNumeratore.get(i).mult(yFrattoDen.get(i));
			lagrange.add(temp);
			itg.next();
		}
		return lagrange;
	}
}
