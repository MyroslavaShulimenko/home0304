package home1904;

import java.util.List;

public class CountryApp {
    public static void main(String[] args) {
      CountryLanguageImpl countryLanguage=new CountryLanguageImpl();
      CountryLanguage countryLanguageDel=new CountryLanguage("ABW","English","T","0.0");

        List<CountryLanguage> allcountry = countryLanguage.getAll();
        allcountry.forEach(System.out::println);
        System.out.println("Get by countryLahquage" + "ABW"+ countryLanguage.get("ABW"));
        List<CountryLanguage> english = countryLanguage.getLanguage("English");
        System.out.println("Get by Lahquage ");
        english.forEach(System.out::println);
      //  countryLanguage.deleteCode("ABW");
        countryLanguage.save(countryLanguageDel);
    }
}
