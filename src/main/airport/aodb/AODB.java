package airport.aodb;


public class AODB {
    private AODB aodb = new AODB();


    private AODB() {

    }

    public AODB getInstance() {
        return aodb;
    }

}
