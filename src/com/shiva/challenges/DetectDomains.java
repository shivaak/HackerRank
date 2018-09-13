package com.shiva.challenges;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDomains {

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
        String regex = "https?://(?:(?:www|ww2)\\.)?([\\w\\d.\\-]+?\\.[\\w\\d]+)[/?#\"]";
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        
        Matcher m = p.matcher(lines);
        List<String> domains = new ArrayList<String>();
        while(m.find()){
            String e = m.group(1);
            if(!domains.contains(e)){
                domains.add(e);
            }
        }
        Collections.sort(domains);
        String join = String.join(";", domains);
        System.out.println(join);
    }
}