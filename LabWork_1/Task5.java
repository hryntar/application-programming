package LabWork_1;

public class Task5 {
   public static void main(String[] args) {
      final String[][] matrix = {
            { "abc", "def", "ghi" },
            { "jkl", "mno", "pqr nof" },
            { "stu", "vwx", "ynono" }
      };

      final String substring = "no";

      int occurrences = countSubstrings(matrix, substring);
      System.out.println("Occurrences of '" + substring + "': " + occurrences);
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
