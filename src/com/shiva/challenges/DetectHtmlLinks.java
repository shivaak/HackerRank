package com.shiva.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine(); 
		List<String> urls = new ArrayList<String>();
		for(int i=1;i<=n;i++) {
			String url = input.nextLine();
			urls.add(url);
		}
		input.close();
		new DetectHtmlLinks().process(urls);
	}

	public void process(List<String> urls) {

		
		//String regex = "<a [^<>]*href=\"(.*?)\"[^<>]*>([^<>]*?)<.*";
		String regex = "<a [^<>]*href=\"(.*?)\"[^<>]*>(?:(?:<(?:[^>]+?)>)+)?([^<]*)(?:(?:<[/][^>]+>)+?)?(?:<[/]a>)";
		final Pattern p = Pattern.compile(regex);
		
		for(String url : urls) {
			Matcher m = p.matcher(url);
			while(m.find()) {
				String link = m.group(1).trim();
				String linkText = m.group(2).trim();
				System.out.println(link + "," + linkText);
	        }
		}

	}

}
