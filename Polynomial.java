public interface Polynomial{

    /**
     * Performs the sum between Polynomials
     * @param b the polinomial to add to this
     */
    public void add(Polynomial b);

    /**
     * This method adds coeffx^(degree) to the polinomial
     */
    public void add(Double coeff, Double degree);

    /**
     * This method multyply this * a
     * @param a the first polynomial
     * @return a new Polynomial c = this*a
     */
    public Polynomial mult(Polynomial a);
}