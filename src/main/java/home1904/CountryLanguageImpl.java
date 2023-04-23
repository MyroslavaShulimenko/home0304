package home1904;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryLanguageImpl implements CountryLanguageDAO<CountryLanguage>{
    private static final String GET_ALL = "SELECT * FROM countrylanguage";
    private static final String GET_BY_COUNTRYCODE = "SELECT * FROM countrylanguage WHERE CountryCode = ?";
    private static final String GET_BY_LANGUAGE= "SELECT * FROM countrylanguage WHERE Language = ?";
    private static final String DELETE_CODE = "DELETE FROM countrylanguage where CountryCode = ?";
    private static final String SAVE_LANGUAGE = "INSERT INTO countrylanguage VALUES (?,?,?,?)";
    @Override
    public List<CountryLanguage> getAll() {
        List<CountryLanguage> countryLanguages=new ArrayList<>();
        try (Connection connection= ConnectorDB.getConnection();
             Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(GET_ALL);
           while (resultSet.next()){
                CountryLanguage countryLanguage=getCountry(resultSet);
                countryLanguages.add(countryLanguage);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return countryLanguages;
    }

    private static CountryLanguage getCountry( ResultSet resultSet) throws SQLException {
        CountryLanguage countryLanguage= new CountryLanguage(resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4));
        return countryLanguage;
    }

    @Override
    public Optional<CountryLanguage> get(String countryCode) {

        try (Connection connection= ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_COUNTRYCODE);

        ){
            preparedStatement.setString(1,countryCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                CountryLanguage countryLanguage= getCountry(resultSet);
                return Optional.of(countryLanguage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      //  return countryLanguages;
        return Optional.empty();
    }
    @Override
    public List<CountryLanguage> getLanguage(String language) {
        List<CountryLanguage> countryLanguages=new ArrayList<>();
        try (Connection connection= ConnectorDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LANGUAGE);

        ){
            preparedStatement.setString(1,language);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CountryLanguage countryLanguage= getCountry(resultSet);
                countryLanguages.add(countryLanguage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //  return countryLanguages;
        return countryLanguages;
    }

    @Override
    public void save(CountryLanguage countryLanguage) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_LANGUAGE);
        ){
            statement.setString(1, countryLanguage.getCountryCode());
            statement.setString(2, countryLanguage.getLanguage());
            statement.setString(3, countryLanguage.getIsOfficial());
            statement.setString(4, countryLanguage.getPercentage());
            int result = statement.executeUpdate();
            System.out.println("Result - save : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCode(String countryCode) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CODE);
        ){
            statement.setString(1, countryCode);
            int result = statement.executeUpdate();
            System.out.println("Delete countryCode : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }





