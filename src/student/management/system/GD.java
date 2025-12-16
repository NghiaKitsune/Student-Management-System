package student.management.system;

public class GD extends Person {
    private double color;
    private double pts;
    private double ai;

    public GD(String id, String name, int age, String major, double color, double pts, double ai) {
        super(id, name, age, major);
        this.color = color;
        this.pts = pts;
        this.ai = ai;
    }

    @Override
    public double calculateAverageMark() {
        return (color + 2 * pts + ai) / 4;
    }

    // Getters & Setters
    public double getColor() { return color; }
    public void setColor(double color) { this.color = color; }

    public double getPts() { return pts; }
    public void setPts(double pts) { this.pts = pts; }

    public double getAi() { return ai; }
    public void setAi(double ai) { this.ai = ai; }
}