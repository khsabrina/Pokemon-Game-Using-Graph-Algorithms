package ex4_java_client.ex4_java_client;


public class GeoLocation {
    private final double x;
    private final double y;
    private final double z;

    public GeoLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public double distance(GeoLocation g) {
        return Math.sqrt(Math.pow(g.x() - this.x, 2) + Math.pow(g.y() - this.y, 2) + Math.pow(g.z() - this.z, 2));
    }

    @Override
    public boolean equals(Object ot) {
        if (ot == this) return true;
        if (ot == null || ot.getClass() != this.getClass()) return false;
        GeoLocation other = (GeoLocation) ot;
        return this.x() == other.x() && this.y == other.y() && this.z == other.z();
    }
}
