package com.shiva.challenges;

/*
  Program to convert Number to Roman Digits
  Author : Shiva
*/

public class NumberToRoman {
    
    private static char[] romanMap = {'I', 'V', 'X','L','C','D','M'};
    
    public static void main(String[] args) {        
        
        for(int i=1;i<=2000;i++){
            StringBuffer romanStr = new StringBuffer("");
            int r = 0;
            
            int n=i;
            
            while(n>0){                
                int rem_10 = n % 10;                
                switch(rem_10){
                    case 1: 
                    case 2: 
                    case 3:
                        romanStr.insert(0, repeatChar(romanMap[r], rem_10));
                        break;
                    case 4:
                        romanStr.insert(0,romanMap[r+1]);
                        romanStr.insert(0,romanMap[r]);                        
                        break;
                    case 5:                        
                    case 6:                        
                    case 7:
                    case 8:
                        romanStr.insert(0,repeatChar(romanMap[r], rem_10-5));
                        romanStr.insert(0,romanMap[r+1]);
                        break;
                    case 9:
                        romanStr.insert(0,romanMap[r+2]);
                        romanStr.insert(0,romanMap[r]);                        
                        break;
                }
                r=r+2;
                n=n/10;
            }
            
            System.out.println(i + "-" + romanStr.toString());
        }
        
    }
    
    private static String repeatChar(char c, int repeatCount){
        StringBuffer temp = new StringBuffer("");
        for(int i=1;i<=repeatCount;i++){
            temp.append(c);
        }
        return temp.toString();
    }

}
