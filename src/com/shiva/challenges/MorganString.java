package com.shiva.challenges;
import java.io.IOException;

public class MorganString {

	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {

		int p1 = 0, p2 = 0;
        a = a + 'z';
        b = b + 'z';

        int alen = a.length();
        int blen = b.length();
        StringBuilder result = new StringBuilder();
        result.setLength(0);

        while(p1< alen && p2 < blen) {
            char c1 = a.charAt(p1);
            char c2 = b.charAt(p2);

            if(c1<c2) {
                result.append(c1);
                p1++;
            }else if(c1>c2) {
                result.append(c2);
                p2++;
            }else {
                //When both characters are equal
                if(a.charAt(p1)=='z') { p1++; p2++; continue; }

                int t1 = p1;
                int t2 = p2;

                while(a.charAt(p1) == b.charAt(p2)) {
                    ++p1; ++p2;

                    if(p1==alen && p2==blen){
                        p1=t1;
                        p2=t2;
                        break;
                    }else if(p1 >= alen) {
                        char prev = b.charAt(t2);
                        while(b.charAt(t2) <= prev) {
                            result.append(b.charAt(t2));
                            prev=b.charAt(t2);
                            t2++;
                        }
                        p2 = t2;
                    }else if(p2 >= blen) {
                        char prev = b.charAt(t1);
                        while(a.charAt(t1) <= prev) {
                            result.append(a.charAt(t1));
                            prev=a.charAt(t1);
                            t1++;
                        }
                        p1 = t1;
                    }

                }


                if(a.charAt(p1) <= b.charAt(p2)) {
                    char prev = a.charAt(t1);
                    while(a.charAt(t1) <= prev) {
                        result.append(a.charAt(t1));
                        prev = a.charAt(t1);
                        t1++;
                    }
                    p1 = t1;
                    p2 = t2;
                }

                if(a.charAt(p1) > b.charAt(p2)) {
                    char prev = b.charAt(t2);
                    while(b.charAt(t2) <= prev) {
                        result.append(b.charAt(t2));
                        prev = b.charAt(t2);
                        t2++;
                    }
                    p1 = t1;
                    p2 = t2;
                }

            }
        }

        if(p1<alen) {
            result.append(a.substring(p1));
        }
        if(p2<blen) {
            result.append(b.substring(p2));
        }
        return result.toString();
	}


	public static void main(String[] args) throws IOException {
		String[][] inputs = {
				{"MADY", "MADYB", "MADMADYBY"},
				{"MADYB", "MADY", "MADMADYBY"},
				{"DAD", "DAD", "DADADD"},
				{"JACK","DANIEL", "DAJACKNIEL"},
				{"ABACABA","ABACABA", "AABABACABACABA"},
				{"ABCBA","BCBA","ABBCBACBA"},
				{"BAC","BAB","BABABC"},
				{"DAD","DABC","DABCDAD"},
				{"YZYYZYZYY","ZYYZYZYY","YZYYZYYZYZYYZYZYY"},
				{"DADE","DADE","DADADDEE"}
		};

		for (int tItr = 0; tItr < inputs.length; tItr++) {
			String output = morganAndString(inputs[tItr][0], inputs[tItr][1]);
			System.out.println("Expected : " + inputs[tItr][2] + " Actual : " + output + " : Matches : " + output.equals(inputs[tItr][2]));

		}
	}
}