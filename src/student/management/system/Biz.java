package student.management.system;

public class Biz extends Person {
    private double sale;
    private double marketing;

    public Biz(String id, String name, int age, String major, double sale, double marketing) {
        super(id, name, age, major);
        this.sale = sale;
        this.marketing = marketing;
    }

    @Override
    public double calculateAverageMark() {
        return (sale + 2 * marketing) / 3;
    }

    // Getters & Setters
    public double getSale() { return sale; }
    public void setSale(double sale) { this.sale = sale; }

    public double getMarketing() { return marketing; }
    public void setMarketing(double marketing) { this.marketing = marketing; }
}