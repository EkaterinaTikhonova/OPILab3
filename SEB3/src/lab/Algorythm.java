package lab;

import java.util.Arrays;
import static java.lang.Math.abs;

/**
 * Created by Tom on 23.09.2017.
 D:\learning\вычмат\Lab1\data.csv
 */
public class Algorythm {
    private int n;
    private double acc;
    private double kfc [] [] ;
    private double rez [] ;
    private int m[];


    public Algorythm( int n , double acc , double kfc [] [] , double rez []){
        this.n = n;
        this.acc = acc;
        this.kfc = kfc;
        this.rez = rez;
    }
    /** method checks if matrix has diagonal predominance **/
    public boolean diagChk (double kfc [] []) {
        double sum ;
        int p = 0;
        for (int i = 0 ; i < n ; i++){
            sum = 0 ;
            for (int j = 0 ; j < n ; j++ ){
                if (j != i) sum = sum + abs(kfc[i][j]);
                }
            if (abs(kfc[i][i]) < sum ) {
                return false;
            }
            if (abs(kfc[i][i]) == sum) p++;
        }
        if (p == n) return false;
        else
        return true;
    }
    /** define if matrix can have diagonal predominance **/
    public boolean canBe () {
        m = new int[n];
        double sum;
        int h = 0;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++) {
                sum = 0;
                for (int k = 0 ; k < n ; k ++) {
                    if (k != j) {
                        sum = sum + kfc[i][k];
                    }
                }
                if (kfc[i][j] >= sum) {
                    h++;
                    m[i] = j;
                }
            }
        }
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++ ){
                if (i != j){
                    if(m[i] == m[j]){
                        return false;
                    }
                }
            }
        }
        if ( h != n ){
            return false;
        }
        System.out.println("Matrix will be adducted to diagonal predominance");
        return true;
    }
    /** change matrix to have diagonal predominance **/
    public void makeDiag () {
        double c;
        double sum;
        for(int i = 0 ; i < n ; i++) {
           for (int j = 0 ; j < n ; j ++){
               sum = 0;
               for (int k = 0 ; k < n ; k ++) {
                   if (k != j) {
                       sum = sum + kfc[i][k];
                   }
               }
               if (kfc[i][j] >= sum) {
                   for (int str = 0 ; str < n ; str++){
                       c = kfc[str][j];
                       kfc[str][j] = kfc[str][i];
                       kfc[str][i] = c;
                   }
               }
           }
        }
    }

    public void divRez () {
        for (int i = 0 ; i < n ; i++){
            rez[i] = rez[i]/kfc[i][i];
        }
    }
    public void divKfc () {
        double h = kfc [0][0];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if ( i == j){
                    h = kfc[i][j];
                    kfc[i][j] = 0;
                }
                kfc[i][j] = -kfc[i][j]/h;
            }
        }
    }
    /** check matrix convergence **/
    public boolean chkShd () {
        double sum;
        for (int i = 0 ; i < n ; i++){
            sum = 0;
            for (int j = 0 ; j < n ; j++) {
               sum = sum + abs(kfc[i][j]);
            }
            if (sum > 1) return false;
        }
        return true;
    }
    /** iterations **/
    public void iter () {
        double x0 [] = rez;
        double xx [] = new double[n];
        double sum;
        double acc2;
        int counter = 0;
        System.out.println("X[0]:"+Arrays.toString(x0)+"      -");
        do {
            acc2 = x0[n-1];
             for (int i = 0 ; i < n ; i++){
                 sum = 0;
                 for (int j = 0 ; j < n ; j++){
                     sum = sum + kfc[i][j]*x0[j];
                 }
                 xx[i] = sum + rez[i];
             }
            x0 = Arrays.copyOf(xx ,n);
            counter++;
            System.out.printf("X[%d]:"+Arrays.toString(x0)+"     \u0394:%.10f%n" , counter , abs(acc2 - x0[n-1]));
        }while (abs(acc2 - x0[n-1]) > acc );

    }
}
