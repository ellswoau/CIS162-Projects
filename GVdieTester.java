
/**
 * Write a description of class GVdieTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GVdieTester
{

    public static void main(String[] args) {
        GVdie d1 = new GVdie();
        System.out.println(d1.getValue());

        d1.roll();
        System.out.println(d1.getValue());
               
        d1.setBlank();
        System.out.println(d1.getValue());

    }
}
