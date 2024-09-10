package LabWork_1;

public class Task5 {
   public static void main(String[] args) {
      String[][] matrix = {
            { "abc", "def", "ghi" },
            { "jkl", "mno", "pqr" },
            { "stu", "vwx", "yno" }
      };

      String substring = "no";

      int occurrences = countSubstringInMatrix(matrix, substring);
      System.out.println("Occurrences of '" + substring + "': " + occurrences);
   }

   public static int countSubstringInMatrix(String[][] matrix, String substring) {
      int count = 0;

      for (int i = 0; i < matrix.length; i++) {
         String row = String.join("", matrix[i]);
         count += countOccurrences(row, substring);
      }

      return count;
   }

   public static int countOccurrences(String text, String substring) {
      int count = 0;
      int index = 0;
      while ((index = text.indexOf(substring, index)) != -1) {
         count++;
         index += substring.length();
      }
      return count;
   }
}
