package LabWork_1;

public class Task5 {
   private static final String[][] MATRIX = {
           { "abc", "def", "ghi" },
           { "jkl", "mno", "pqr nof" },
           { "stu", "vwx", "ynono" }
   };

   private static final String SUBSTRING = "no";

   public static void main(String[] args) {
      int occurrences = countSubstrings(MATRIX, SUBSTRING);
      System.out.println("Occurrences of '" + SUBSTRING + "': " + occurrences);
   }

   public static int countSubstrings(String[][] matrix, String substring) {
      int count = 0;
      for (String[] row : matrix) {
         for (String str : row) {
            int pos = str.indexOf(substring);
            while (pos != -1) {
               count++;
               pos = str.indexOf(substring, pos + 1);
            }
         }
      }
      return count;
   }
}
