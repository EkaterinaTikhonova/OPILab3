package lab;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Tom on 22.09.2017.
 */
public class ConsoleRead{
    private int n;
    private double acc;
    private double kfc [] [] ;
    private double rez [];
    private Scanner readMx = new Scanner(System.in);
    private String path1 ;
    private double data [];
    private int type;

    public ConsoleRead(int type) {
        this.type = type;
    }

    public void readRez () {
        Scanner tt = new Scanner(System.in);
        for (int i = 0 ; i < n ; i++){
            System.out.println("Enter the result for line " + (i+1));
            try {
                rez[i] = tt.nextDouble();
            }catch (Exception e){
                System.out.println("Wrong input");
                e.printStackTrace();
            }
        }
    }

    /** method randomize matrix coefficients **/
    public boolean randomizer () {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("Do you want to randomize the coefficients?(yes/no)");
        String s1 = sc.next();
        if (s1.toLowerCase().equals("yes") || s1.toLowerCase().equals("y")){
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    kfc[i][j] = rnd.nextDouble();
                }
            }

            return false;
        } else {

            return true;
        }
    }
    /** method reads square matrix size by console **/
    public void readSZ (){
        try {
            System.out.println("Enter matrix size:");
            n = readMx.nextInt();
        }catch (Exception e){
            System.err.println("Wrong input");
            System.exit(0);
        }
        kfc = new double [n] [n] ;
        rez = new double[n];
        }
    /** method reads accuracy for result by console **/
    public void readAcc () {
        try {
            System.out.println("Enter accuracy for result with delimiter  \",\" :");
            acc = readMx.nextDouble();
        }catch (Exception e){
            System.err.println("Wrong input");
            System.exit(0);
        }
    }
    /** method reads matrix coefficients by console **/
    public void readMassive() {
        for (int i =0 ; i < n ; i++){
            System.out.println("Enter the coefficients for line:" + (i+1) +"\n");
            for (int j = 0 ; j <= n ; j++){
                    try{
                        if(j == n){
                            System.out.println("Enter the result of line "+(i+1)+"\n");
                            rez[i] = readMx.nextDouble();
                        }else{
                            System.out.println("Enter the "+ (j+1) +" coefficient\n");
                            kfc[i][j] = readMx.nextDouble();
                        }
                    }catch (Exception e){
                        System.err.println("Wrong input");
                        System.exit(0);
                    }
            }
        }
    }
    /** method reads data from csv file **/
    public void getData () {
        try {
            Scanner sc = new Scanner(new File(path1));
            n = sc.nextInt();
            acc = sc.nextDouble();
            data = new double[(n*n)+n];
            kfc = new double[n][n];
            rez = new double[n];
            int k = 0;
            while (sc.hasNext()){
                data[k++] = sc.nextDouble();
            }
            k = 0;
            for (int i = 0 ; i < n ; i++){
                for (int j = 0 ; j <= n ; j++){
                    if (j == n) rez[i] = data[k++];
                    else
                        kfc[i][j] = data [k++];
                }
            }
        }catch (Exception e ){
            System.err.println("Wrong input plz check file");
            System.exit(-1);
        }
    }
    public int getN() {
        return n;
    }
    public double getAcc() {
        return acc;
    }
    public double[][] getKfc() {
        return kfc;
    }

    public double[] getRez() {
        return rez;
    }

    public int getType() {
        return type;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }
}
