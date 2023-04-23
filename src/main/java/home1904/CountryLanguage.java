package home1904;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CountryLanguage {
  private String  countryCode;
  private String  language;
   private String isOfficial;
  private String  percentage ;
}
