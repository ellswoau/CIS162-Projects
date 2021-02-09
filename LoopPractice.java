
/*
 * Lab 8 Loop Practice
 * By Austin Ellsworth
 */
public class LoopPractice
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class LoopPractice
     */
    public LoopPractice()
    {
        // initialise instance variables
        x = 0;
    }

    // methods for lab
    public void displayMultiples(int num) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(num * i + " ");
        }   
        System.out.println("");
    }
    public int sumFor(int low, int high) {
        if (low > high) {
            return -1;
        }
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += i;
        }
        return sum;
    }
    public void drawRectangle(int rows, int cols) {
        //rows
        for (int i = 1; i <= rows; i++) {
            //columns
            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }  
    }
    public void drawOtherTriangle(int rows) {
        //loop for vertical lines
        for (int i = rows; i >= 1; --i) {
            //loop for horizontal lines
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            } 
            System.out.println("");
        }  
    }
    public void drawTriangle(int rows) {
        //loop for vertical lines
        for (int i = 1; i <= rows; i++) {
            //loop for horizontal lines
            for (int j = 1 ; j <= i; j++) {
                System.out.print("*");
            } 
            System.out.println("");
        }  
    }
    public static void main(String[] args) {
        LoopPractice loop1 = new LoopPractice();
        loop1.displayMultiples(3);
        System.out.println("");
        System.out.println(loop1.sumFor(4, 7));
        System.out.println("");
        loop1.drawRectangle(3, 6);
        System.out.println("");
        loop1.drawTriangle(4);
        System.out.println("");
        loop1.drawOtherTriangle(5);

    }
}
