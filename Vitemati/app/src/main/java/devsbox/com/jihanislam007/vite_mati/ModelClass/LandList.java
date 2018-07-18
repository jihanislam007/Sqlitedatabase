package devsbox.com.jihanislam007.vite_mati.ModelClass;

public class LandList {

    public  int id;
    String wonner_name;
    String land_address;
    String land_price;

    public LandList() {
    }

    public LandList(int id, String wonner_name, String land_address, String land_price) {
        this.id = id;
        this.wonner_name = wonner_name;
        this.land_address = land_address;
        this.land_price = land_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWonner_name() {
        return wonner_name;
    }

    public void setWonner_name(String wonner_name) {
        this.wonner_name = wonner_name;
    }

    public String getLand_address() {
        return land_address;
    }

    public void setLand_address(String land_address) {
        this.land_address = land_address;
    }

    public String getLand_price() {
        return land_price;
    }

    public void setLand_price(String land_price) {
        this.land_price = land_price;
    }
}
