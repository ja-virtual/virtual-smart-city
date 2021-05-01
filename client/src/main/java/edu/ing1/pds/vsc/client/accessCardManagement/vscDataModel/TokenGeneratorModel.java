package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

public class TokenGeneratorModel {

    private int id_token;

    private enum token {
        frojfoejzf4484ezaerth,
        frojfoejzf4484ezae86d,
        frojfoejzf4484ezaezef,
        frojfoejzf4484ezae862,
        frojfoejzf4484ezaeze5
    };

    private int id_accesslevel;

    public int getId_token() {
        return id_token;
    }

    public void setId_token(int id_token) {
        this.id_token = id_token;
    }

    public int getId_accesslevel() {
        return id_accesslevel;
    }

    public void setId_accesslevel(int id_accesslevel) {
        this.id_accesslevel = id_accesslevel;
    }

}
