public class TemperatureRegister {
    private Integer dni;
    private Double temperature;
    private String neighborhood;

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public TemperatureRegister() {
    }

    public TemperatureRegister(Integer dni, Double temperature, String neighborhood) {
        this.dni = dni;
        this.temperature = temperature;
        this.neighborhood = neighborhood;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "TemperatureRegister{" +
                "dni=" + dni +
                ", temperature=" + temperature +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }
}
