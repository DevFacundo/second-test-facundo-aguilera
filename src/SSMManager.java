import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SSMManager {

    private Set<Person> personList;
    private Map<Integer, TemperatureRegister> temperatureRegisters;
    private Integer kitsQuantity=0;
    private Integer kitNumber;
    private static Integer nextKit=1;

    public SSMManager(Integer kitsQuantity) {
        this.personList=new LinkedHashSet<>();
        this.temperatureRegisters= new HashMap<>();
        this.kitsQuantity=kitsQuantity;
        kitNumber=nextKit++;
    }

    public Set<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(Set<Person> personList) {
        this.personList = personList;
    }

    public Map<Integer, TemperatureRegister> getTemperatureRegisters() {
        return temperatureRegisters;
    }

    public void setTemperatureRegisters(Map<Integer, TemperatureRegister> temperatureRegisters) {
        this.temperatureRegisters = temperatureRegisters;
    }

    public Integer getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Integer kitNumber) {
        this.kitNumber = kitNumber;
    }

    public Integer getKitsQuantity() {
        return kitsQuantity;
    }

    public void setKitsQuantity(Integer kitsQuantity) {
        this.kitsQuantity = kitsQuantity;
    }

    public void personRegister (String name, String surname, Integer age, String neighborhood, Integer dni, String ocuppation) throws ItDoesntHaveKitsException
    {
        if (kitsQuantity>0)
        {
            personList.add(new Person(name,surname,age,neighborhood,dni,ocuppation,nextKit));
            nextKit++;
            kitsQuantity--;
        }else
        {
            throw new ItDoesntHaveKitsException("It doesnt have more kits");
        }
    }

    public void tester()
    {
        Random random = new Random();
        for (Person p : personList)
        {
            double temperature = 36 +(random.nextDouble()*3);
            temperatureRegisters.put(p.getKitNumber(), new TemperatureRegister(p.getDni(),temperature,p.getNeighborhood()));
        }
    }

    public void isolate()
    {

        for (Map.Entry<Integer, TemperatureRegister> entry : temperatureRegisters.entrySet()) {
            TemperatureRegister register = entry.getValue();
            if (register.getTemperature() >= 38.0) {
                throw new HighFeverException(entry.getKey(),register.getNeighborhood());

            }
        }
    }

    public void generateJson(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> healthy = new ArrayList<>();
        List<TemperatureRegister> isolate=new ArrayList<>();

        for (Map.Entry<Integer, TemperatureRegister> entry : temperatureRegisters.entrySet()) {
            TemperatureRegister register = entry.getValue();
            Integer dni = (register.getDni());

            if (register.getTemperature() < 38.0) {
                for (Person p : personList)
                {
                    if (p.getDni().equals(dni))
                    {
                        healthy.add(p);
                    }
                }

            } else {
                isolate.add(register);
            }
        }
        HealthReport report = new HealthReport(healthy, isolate);

        try
        {
            mapper.writeValue(file, report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
