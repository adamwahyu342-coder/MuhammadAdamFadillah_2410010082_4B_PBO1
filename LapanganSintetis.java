// Inheritance: LapanganSintetis mewarisi Lapangan
public class LapanganSintetis extends Lapangan {
    private double bonusPapanSkor;

    // Constructor Subclass
    public LapanganSintetis(String kodeLap, double tarifPerJam, double bonusPapanSkor) {
        super(kodeLap, tarifPerJam); // Memanggil superclass constructor
        this.bonusPapanSkor = bonusPapanSkor;
    }

    public double getBonusPapanSkor() {
        return bonusPapanSkor;
    }

    // Polymorphism: Mengubah perilaku method ambilDetail() milik induk
    @Override
    public String ambilDetail() {
        return super.ambilDetail() + " + Charge Papan Skor Digital (Rp" + bonusPapanSkor + ") [Sintetis]";
    }
}