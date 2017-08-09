public class Figura 
{
    // Atributos
    private double base = 0;
    private double altura = 0;
    private double area = 0;
   
    // Constructor
    public Figura(){
    }
    
    // Métodos

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getArea() {
        this.area = (this.base * this.altura)/2;
        return area;
    }
}
