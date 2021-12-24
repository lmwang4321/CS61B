public class ex3 {
   public static int max(int[] m) {
      int max = -2147483647;
      int idx = 0;
      for (idx = 0; idx <= m.length-1 ; ++ idx){
         if(m[idx]>max) {max = m[idx];}
      }
      return max;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      int max = max(numbers);
      System.out.format("max: %d", max);
   }
}
