public class HighFeverException extends RuntimeException {

    private Integer kitNumber;
    private String neighborhood;

    public HighFeverException(Integer kitNumber, String neighborhood) {
        super("HIGH FEVER DETECTED IN KIT NUMBER: "+ kitNumber+
                " NEIGHBORHOOD: "+ neighborhood);
        this.kitNumber=kitNumber;
        this.neighborhood=neighborhood;

    }
}
