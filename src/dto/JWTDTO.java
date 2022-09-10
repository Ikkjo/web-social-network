package dto;

public class JWTDTO {
    private String jwt;

    public JWTDTO() {
    }

    public JWTDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
