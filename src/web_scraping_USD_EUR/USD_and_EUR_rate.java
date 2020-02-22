package web_scraping_USD_EUR;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class USD_and_EUR_rate {

	public static void main(String[] args) {
		try{
			Document docUsd = Jsoup.connect("https://www.bank.lv/statistika/dati-statistika/valutu-kursi/aktualie").userAgent("Mozilla/72.0.2").get();
			Document docEur = Jsoup.connect("https://www.exchangerates.org.uk/Dollars-to-Euros-currency-conversion-page.html").userAgent("Mozilla/72.0.2").get();
			///////////////////////////////////////////
			Elements curValUsd=docUsd.select("td.value");
			double USD=Double.parseDouble(curValUsd.get(510).getElementsByTag("td").first().text());
			System.out.println(USD);
			///////////////////////////////////////////
			Element curValEur = docEur.getElementById("shd2b;");
			double EUR=Double.parseDouble(curValEur.getElementsByTag("span").first().text());
			System.out.println(EUR);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
