public class Lapangan {
    // Encapsulation: Atribut dibuat private
    private String kodeLap;
    private double tarifPerJam;

    // Constructor
    public Lapangan(String kodeLap, double tarifPerJam) {
        this.kodeLap = kodeLap;
        this.tarifPerJam = tarifPerJam;
    }

    // Accessor (Getter)
    public String getKodeLap() {
        return kodeLap;
    }

    public double getTarifPerJam() {
        return tarifPerJam;
    }

    // Mutator (Setter)
    public void setKodeLap(String kodeLap) {
        this.kodeLap = kodeLap;
    }

    public void setTarifPerJam(double tarifPerJam) {
        this.tarifPerJam = tarifPerJam;
    }

    // Method untuk Polimorfisme (Overriding)
    public String ambilDetail() {
        return "Kode: " + kodeLap + " | Tarif Utama: Rp" + tarifPerJam + "/jam";
    }
}