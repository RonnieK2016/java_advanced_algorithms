package webcrawler;

import com.sun.jndi.toolkit.url.UrlUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> webSites;
    private HashSet<String> visited;

    private static final int THRESHOLD = 500;

    public WebCrawler() {
        webSites = new LinkedList<String>();
        visited = new HashSet<String>();
    }

    public void discoverWeb(String rootSite) {
        webSites.add(rootSite);
        visited.add(rootSite);

        while (!webSites.isEmpty()) {
            String site = webSites.poll();
            webSites.addAll(readUrls(readRawHtml(site)));
            if(webSites.size() == THRESHOLD) {
                System.out.println("Threshold reached");
                break;
            }
        }
    }

    private List<String> readUrls(String rawHtml) {
        List<String> result = new ArrayList<String>();

        if(rawHtml.length() > 0) {
            Pattern pattern = Pattern.compile("http://(www)?\\.\\w+\\.[a-zA-Z.]+/");
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String url = matcher.group(0);
                if (!visited.contains(url)) {
                    System.out.println("Discovered: " + url);
                    result.add(url);
                    visited.add(url);
                }
            }
        }

        return result;
    }

    private String readRawHtml(String site) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(site);

            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while ((line = bufferedInputStream.readLine()) != null) {
                result.append(line);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
