
public class Tools {
   public int findExponent(int num) {

      if (num == 1) {

         return 0;
      }

      return 1 + findExponent(num / 2);
   }

}
