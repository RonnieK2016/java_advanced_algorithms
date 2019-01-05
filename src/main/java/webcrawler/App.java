package webcrawler;

public class App {

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();

        webCrawler.discoverWeb("http://www.bbc.com");
    }
}
