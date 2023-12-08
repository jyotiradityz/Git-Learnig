// package DAAL.Assignment_3;

import java.util.Scanner;

public class TOH {
    static void towerOfHanoi(int n, char from_rod,char to_rod, char aux_rod){
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "+ from_rod + " to rod "+ to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }
  
    // Driver code
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        scn.close();
  
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}