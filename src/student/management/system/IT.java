package student.management.system;

public class IT extends Person {
    private double html;
    private double css;
    private double math;

    public IT(String id, String name, int age, String major, double html, double css, double math) {
        super(id, name, age, major);
        this.html = html;
        this.css = css;
        this.math = math;
    }

    @Override
    public double calculateAverageMark() {
        return (html + css + 2 * math) / 4;
    }
    // Getters & Setters
    public double getHtml() { return html; }
    public void setHtml(double html) { this.html = html; }

    public double getCss() { return css; }
    public void setCss(double css) { this.css = css; }

    public double getMath() { return math; }
    public void setMath(double math) { this.math = math; }
}