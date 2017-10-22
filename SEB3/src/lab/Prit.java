package lab;

import java.util.Scanner;

/**
 * Created by Tom on 22.09.2017.
 */
public class Prit {
    static Scanner readType ;
    static ConsoleRead type;
    public static void main(String[] args) {
        System.out.println("Fixed-point iteration Lab1");

        while(true) {
            type = defineReadTp();
            if(type != null)break;
        }
        if ( type.getType() == 1 ){
            type.readSZ();
            type.readAcc();
            if (type.randomizer())
            type.readMassive();
            else type.readRez();
        } else {
            if (type.getType() == 2){
                type.setPath1(readType.next());
                type.getData();
            }
        }

        Algorythm alg = new Algorythm(type.getN() , type.getAcc() , type.getKfc() , type.getRez());
        if (alg.diagChk(type.getKfc())){
            alg.divRez();
            alg.divKfc();
            if(alg.chkShd()) alg.iter();
            else {
                System.out.println("System does not converge");
                System.exit(-1);
            }
        } else {
            if(alg.canBe())
                alg.makeDiag();
            else System.out.println("System can't have diagonal predominance");
            alg.divRez();
            alg.divKfc();
            if(alg.chkShd()) alg.iter();
            else {
                System.out.println("System does not converge");
                System.exit(-1);
            }
        }


        }
        /** method define type of input chosen by user **/
        public static ConsoleRead defineReadTp (){
            System.out.println("Choose how to load input data . 1 - console , 2 - file ");
            int rT;
            try {
                readType = new Scanner(System.in);
                rT = readType.nextInt();
            if ( rT == 1 ) {
                ConsoleRead R = new ConsoleRead(1);
                System.out.println("You chose console input");
                return R;
            }else {
                if  ( rT == 2 ) {
                    ConsoleRead R = new ConsoleRead(2);
                    System.out.println("You chose file input");
                    return R;
                } else {
                    System.err.println("Wrong input please choose 1 or 2");
                    return null;
                }}
            }catch (Exception e){
                System.err.println("Please choose a number");
                return null;
            }
        }

}

