package bean;

public class HomeDto {
    private AddressDto addressDto;

    private boolean isXxx;

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public boolean isXxx() {
        return isXxx;
    }

    public void setXxx(boolean xxx) {
        isXxx = xxx;
    }
}
