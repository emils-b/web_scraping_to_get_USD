package web_scraping_USD_EUR;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class USD_and_EUR_value {

	public static void main(String[] args) {
		try{
			Document doc = Jsoup.connect("https://www.bank.lv/statistika/dati-statistika/valutu-kursi/aktualie").userAgent("Mozilla/72.0.2").get();
			Elements curVal=doc.select("td.value");
			double USD=Double.parseDouble(curVal.get(510).getElementsByTag("td").first().text());
			System.out.println(USD);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
