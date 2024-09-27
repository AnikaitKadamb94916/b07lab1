
public class Polynomial{

    double [] coeff;
    int [] expo;

    public Polynomial(){

        this.coeff = new double []{0};
        this.expo = new int []{0};

    }

    public Polynomial(double[] coeffarray, int[] expoarray){

        this.coeff = coeffarray;
        this.expo = expoarray;

    }


    public int highestIndex(){
        int highest = 0;
        int len = this.expo.length;
        for(int x = 0; x < len; x++){
            if(highest <= this.expo[x]) highest = this.expo[x];
        }
        return highest;
    }

    public double exists(int exp){
        int len = this.expo.length;
        for(int x = 0; x < len; x++){
            if(this.expo[x] == exp) return this.coeff[x];
        }
        return -1;
    }

    public Polynomial add(Polynomial obj2){

        Polynomial objnew = new Polynomial();
        int highest = Math.max(this.highestIndex(),obj2.highestIndex());
        int longest = 0;
        if(this.expo.length >= obj2.expo.length) longest = this.expo.length;
        else longest = obj2.expo.length;
        objnew.coeff = new double [longest];
        objnew.expo = new int [longest];
        double var2 = 0;
        double var1 = 0;
        int counter = 0;
        for(int x=0; x <= highest; x++){
            if(counter >= longest) break;
            if(this.exists(x) != -1) var1 = this.exists(x);
            if(obj2.exists(x) != -1) var2 = obj2.exists(x);
            if(var1 != -1 || var2 != -1){
                objnew.coeff[counter] = var1 + var2;
                objnew.expo[counter] = x;
                counter++;
            }
            var1 = 0;
            var2 = 0;
        }
        return objnew;

    }

    public double evaluate(double x){
        int len = this.expo.length;
        double sum = 0;
        for(int y = 0; y < len; y++){
            sum += coeff[y] * (Math.pow(x,expo[y]));
        }
        return sum;
    }

    public boolean hasRoot(double x){
        int len = this.expo.length;
        double sum = 0;
        for(int y = 0; y < len; y++){
            sum += coeff[y] * (Math.pow(x,expo[y]));
        }

        if(sum == 0) return true;
        else return false;
    }

}