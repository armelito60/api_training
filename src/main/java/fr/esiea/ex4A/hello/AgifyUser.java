package fr.esiea.ex4A.hello;

public class AgifyUser {
    private final String name;
    private final Integer age;
    private final Integer count;
    private final String countryId;

    public AgifyUser(String name, Integer age, Integer count, String countryId) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.countryId = countryId;
    }

    public final String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
    public Integer getCount() {
        return count;
    }

    public String getCountryId() {
        return countryId;
    }
}
