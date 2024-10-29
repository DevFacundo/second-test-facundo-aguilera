import java.util.List;

public class HealthReport {

    private List<Person> healthy;
    private List<TemperatureRegister> isolate;

    public HealthReport() {
    }

    public HealthReport(List<Person> healthy, List<TemperatureRegister> isolate) {
        this.healthy = healthy;
        this.isolate = isolate;
    }

    public List<Person> getHealthy() {
        return healthy;
    }

    public void setHealthy(List<Person> healthy) {
        this.healthy = healthy;
    }

    public List<TemperatureRegister> getIsolate() {
        return isolate;
    }

    public void setIsolate(List<TemperatureRegister> isolate) {
        this.isolate = isolate;
    }

    @Override
    public String toString() {
        return "HealthReport{" +
                "healthy=" + healthy +
                ", isolate=" + isolate +
                '}';
    }

}
