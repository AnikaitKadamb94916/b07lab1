public class Polynomial{

    double [] polycoeff;

    public Polynomial(){

        this.polycoeff = new double []{0};

    }

    public Polynomial(double[] array){

        this.polycoeff = array;

    }

    public Polynomial add( Polynomial obj2){

        Polynomial objnew = new Polynomial();
        int len = 0;
        if(obj2.polycoeff.length > this.polycoeff.length) len = obj2.polycoeff.length;
        else len = this.polycoeff.length;

        objnew.polycoeff = new double [len];
        for(int x = 0; x < len; x++){
            double ob1 = 0;
            double ob2 = 0;
            if(x < this.polycoeff.length){
                ob1 = this.polycoeff[x];
            }
            if(x < obj2.polycoeff.length ){
                ob2 = obj2.polycoeff[x];
            }
            objnew.polycoeff[x] = ob1 + ob2;

        }
        return objnew;
    }

    public double evaluate(double x){
        int power = 0;
        int len = this.polycoeff.length;
        double sum = 0;
        for(int y= 0; y < len; y++){
            sum += (this.polycoeff[y]*(Math.pow(x,power)));
            power += 1;
        }
        return sum;
    }

    public boolean hasRoot(double x){
        int power = 0;
        int len = this.polycoeff.length;
        double sum = 0;
        for(int y= 0; y < len; y++){

            sum += (this.polycoeff[y]*(Math.pow(x,power)));
            power += 1;
        }

        if(sum == 0) return true;
        else return false;
    }

}