public class Main{
    public static void main(String[] args){
        
        Polynomial a = new EnzoPoly();

        a.add(new Double(10),new Double(2));
        a.add(new Double(1),new Double(3));
        Polynomial b = new EnzoPoly();

        b.add(new Double(10),new Double(3));
        
        a.add(b);
        System.out.println(a.toString());

    }
}