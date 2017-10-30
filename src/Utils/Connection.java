package Utils;

public class Connection {

    public String city1, city2;
    public int cost;

    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }

    public String getCity1() {
        return this.city1;
    }

    public String getCity2() {
        return this.city2;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.city1 + " " + this.city2 + " " + this.cost;
    }
}
