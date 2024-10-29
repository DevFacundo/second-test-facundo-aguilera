import java.util.Objects;

public class Person {
    private Integer id;
    private static Integer nextId=1;
    private String name;
    private String surname;
    private Integer age;
    private String neighborhood;
    private Integer dni;
    private String ocuppation;
    private Integer kitNumber;

    public Person(String surname, String name, Integer age, String neighborhood, Integer dni, String ocuppation, Integer kitNumber) {
        this.id=nextId++;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.ocuppation = ocuppation;
        this.kitNumber=kitNumber;
    }

    public Integer getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Integer kitNumber) {
        this.kitNumber = kitNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getOcuppation() {
        return ocuppation;
    }

    public void setOcuppation(String ocuppation) {
        this.ocuppation = ocuppation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", neighborhood='" + neighborhood + '\'' +
                ", dni=" + dni +
                ", ocuppation='" + ocuppation + '\'' +
                ", kitNumber=" + kitNumber +
                '}';
    }
}
