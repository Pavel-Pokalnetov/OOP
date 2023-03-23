package HomeWorks.hw7;

public abstract class EnterpriseGSMModem extends BaseModem {

    private InterfaceType type;

    public EnterpriseGSMModem(String model, InterfaceType type) {
        this.model = model;
        this.type = type;
    }
}
