public class Main {
   
   public String mixString(String a, String b) {
      /* Type your code here. */
      String longerString = b;
      String shorterString = a;
      if (a.length() > b.length()) {
         longerString = a;
         shorterString = b;
      }

      int numberSwaps = shorterString.length();
      String finalString = "";

      int i;     
      for (i = 0; i < numberSwaps; ++i) {
         finalString = new StringBuilder(finalString).append(a.charAt(i)).append(b.charAt(i)).toString();
      }
      String remainingChars = longerString.substring(shorterString.length());
      finalString = finalString.concat(remainingChars);
      return finalString;
   }
   
   
   public static void main(String[] args) {
      Main test = new Main();
      System.out.Println(test.mixString("aaa", "BBBBB"));

   }
}
