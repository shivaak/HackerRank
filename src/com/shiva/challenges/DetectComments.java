package com.shiva.challenges;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectComments {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine().trim());
            sb.append("\n");
        }
        process(sb.toString());
    }
    
    public static void process(String lines) {
        
        final String regex = "(?:\\/\\/[^/].*\\n)|(?:\\/\\*[\\s\\S]*?\\*\\/)";
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        
        Matcher m = p.matcher(lines);
        StringBuilder output = new StringBuilder();
        while(m.find()) {
            String e = lines.substring(m.start(), m.end()).trim();
            output.append(e);
            output.append("\n");
        }
        System.out.println(output.toString());
    }
}