package com.shiva.challenges;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmails {

    public static void main(String str[]){
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> set = new TreeSet<>();
        StringBuilder lines = new StringBuilder();
        scanner.nextLine();
        for(int i=1;i<=n;i++){
            String line = scanner.nextLine();
            lines.append(line).append(System.getProperty("line.separator"));
        }
        scanner.close();
        process(lines.toString());        
    }
    
    public static void process(String lines){
        String regex = "(\\w\\S+@\\w\\S+\\.\\S\\w+)";
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        
        Matcher m = p.matcher(lines);
        List<String> emails = new ArrayList<String>();
        while(m.find()){
            String e = m.group(1);
            if(!emails.contains(e)){
                emails.add(e);
            }
        }
        Collections.sort(emails);
        String join = String.join(";", emails);
        System.out.println(join);
    }
}