package home1904;

import java.util.List;
import java.util.Optional;

public interface CountryLanguageDAO <T>{
List<T>getAll();

   // List<CountryLanguage> get(String countryCode);
   Optional<T> get(String countryCode);
   List<T> getLanguage(String language);

    void save(T t);

   // void delete(String language);
    void deleteCode(String countryCode);

}
