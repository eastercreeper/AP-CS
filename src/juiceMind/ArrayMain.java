package juiceMind;

import javax.annotation.processing.SupportedSourceVersion;

public class ArrayMain {
    public static void main(String[] args) {
        int [][] a1 = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        traverse1(a1);

        int [][] a2 = {{ 1, 5,  9, 13},
                       { 2, 6, 10, 14},
                       { 3, 7, 11, 15},
                       { 4, 8, 12, 16}};
      traverse2(a2);

        int [][] a3 = {{  1,  2,  9, 10},
                       {  3,  4, 11, 12},
                       {  5,  6, 13, 14},
                       {  7,  8, 15, 16}};
      traverse3(a3);

        int [][] a4 = {{  1,  3,  5,  7},
                       {  9, 11, 13, 15},
                       {  2,  4,  6,  8},
                       { 10, 12, 14, 16}};
      traverse4(a4);

      int [][] a5 =   {{  1,  3,  6, 10},
                       {  2,  5,  9, 13},
                       {  4,  8, 12, 15},
                       {  7, 11, 14, 16}};
      traverse5(a5);

      int [][] a6 =   {{  7,  4,  2,  1},
                       { 13,  8,  5,  3},
                       { 15, 12,  9,  6},
                       { 16, 14, 11, 10}};
      traverse6(a6);

      int [][] flat = flatten(a4);
      System.out.println(flat);
    }

      /*  COMPLETE THE METHODS BELOW  */

      public static void traverse1(int[][] matrix) {
          for (int[] ints : matrix) {
              for (int anInt : ints) {
                  System.out.print(anInt + " ");
              }
          }
          System.out.println();
      }
      public static void traverse2(int[][] matrix) {
       for(int i = 0; i < matrix[0].length; i++) {
           for (int[] ints : matrix) {
               System.out.print(ints[i] + " ");
           }
       }
       System.out.println();

      }
      public static void traverse3(int[][] matrix) {
          for (int[] value : matrix) {
              for (int j = 0; j < value.length / 2; j++) {
                  System.out.print(value[j] + " ");
              }
          }
          for (int[] ints : matrix) {
              for (int j = matrix.length / 2; j < ints.length; j++) {
                  System.out.print(ints[j] + " ");
              }
          }
          System.out.println();
      }
      public static void traverse4(int[][] matrix) {
        for(int i = 1; i <= 16; i++) {
          for(int j = 0; j < matrix.length; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
              if(matrix[j][k] == i) {
                System.out.print(i + " ");
              }
            }
          }
        }
        System.out.println();
      }
      public static void traverse5(int[][] matrix) {
        for(int i = 1; i <= 16; i++) {
          for(int j = 0; j < matrix.length; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
              if(matrix[j][k] == i) {
                System.out.print(i + " ");
              }
            }
          }
        }
        System.out.println();
      }
      public static void traverse6(int[][] matrix) {
        for(int i = 1; i <= 16; i++) {
          for(int j = 0; j < matrix.length; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
              if(matrix[j][k] == i) {
                System.out.print(i + " ");
              }
            }
          }
        }
        System.out.println();
      }

      public static int [][] flatten(int[][] inArray) {
        int n = inArray.length/2;
        int[][] o =  new int[n][n*4];

        for (int i = 0; i < n; i++) {
          for (int j = 0; j < 2 * n; j++) {
            o[i][j] = inArray[2 * i][j];
            o[i][j + 2 * n] = inArray[2 * i + 1][j];
          }
        }
        return o;
      }

}