package methodsLab0;
//

public class List {

    public static class Begin15 {
        private double diametr;
        private double length;

        public Begin15() {
            this.diametr = 0;
            this.length = 0;
        }

        public Begin15(double D, double L) {
            this.diametr = D;
            this.length = L;
        }

        public void setDiametr(double diametr){
            this.diametr=diametr;
        }
        public void setLength(double length){
            this.length=length;
        }
        public double getD(){
            return this.diametr;
        }
        public double getL(){
            return this.length;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Begin15 myobj = (Begin15) obj;
            return (this.diametr == myobj.diametr) && (this.length == myobj.length);

        }
    }

    public static class While15 {
        private int amountOfMonths;
        private double totalDeposit;

        public While15() {
            amountOfMonths = 0;
            totalDeposit = 1000;
        }

        public While15(int amountOfMonths, double totalDeposit) {
            this.amountOfMonths = amountOfMonths;
            this.totalDeposit = totalDeposit;
        }
        public void setAmountOfMonths(int amountOfMonths) {
            this.amountOfMonths = amountOfMonths;
        }
        public void setTotalDeposit(double totalDeposit){
            this.totalDeposit=totalDeposit;
        }
        public int getAmountOfMonths(){
            return this.amountOfMonths;
        }
        public double getTotalDeposit(){
            return this.totalDeposit;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            While15 myobj = (While15) obj;
            return (this.amountOfMonths == myobj.amountOfMonths) && (this.totalDeposit == myobj.totalDeposit);

        }
    }// end of inner class

    public void simple_output(){
        System.out.println("This is my first lab !");
    }

    // methods
    public While15 while15(double interest) {
        assert(interest<=0 || interest>=25) : "Incorect input data";
        While15 ob=new While15();
        double temp,totalDeposit=1000;
        int amountOfMonths=0;
        while(totalDeposit<1100){
            temp=(totalDeposit*interest)/100;
            totalDeposit+=temp;
            amountOfMonths++;
        }
        ob.setAmountOfMonths(amountOfMonths);
        ob.setTotalDeposit(totalDeposit);
        return ob;
    }
   public Begin15 begin15(double square) {
       assert(square<=0) : "Incorect input data";
       Begin15 ob=new Begin15();
       final double PI = 3.14;
       double radius=Math.sqrt(square / PI);
       ob.setLength(2 * PI * radius);
       ob.setDiametr(radius+radius);
       return ob;
    }

    public int integer15(int k) {
        assert (k>100 && k < 1000) : "Incorect input data";
        int  a = k % 10;
        k = k / 10;
        int b = k % 10;
        int c = k / 10;
        return b * 100 + c * 10 + a;
    }

    public boolean boolean15(int A, int B, int C) {
        if (A > 0 || B > 0) {
            if (B > 0 || C > 0)
                return true;
        }
        return false;
    }

    public int if15(int a, int b, int c) {
        int min, max;
        if (a > b) {
            min = b;
            max = a;
        } else {
            min = a;
            max = b;
        }
        if (min < c)
            return c + max;
        else
            return min + max;

    }

    public String case15(int N, int M) {
        assert(N<6 || N>14 || M<1 ||M>4) : "Incorect input data";
        String Ncard = "", Mcard = "";
        switch (N) {
            case 6:
                Ncard = "Шість ";
                break;
            case 7:
                Ncard = "Сім ";
                break;
            case 8:
                Ncard = "Вісім ";
                break;
            case 9:
                Ncard = "Дев'ять ";
                break;
            case 10:
                Ncard = "Десять ";
                break;
            case 11:
                Ncard = "Валет ";
                break;
            case 12:
                Ncard = "Дама ";
                break;
            case 13:
                Ncard = "Король ";
                break;
            case 14:
                Ncard = "Туз ";
                break;
        }
        switch (M) {
            case 1:
                Mcard = "піки";
                break;
            case 2:
                Mcard = "хреста";
                break;
            case 3:
                Mcard = "бубна";
                break;
            case 4:
                Mcard = "чірви";
                break;
        }
        return (Ncard + Mcard);
    }

    public double for15(double A, int N) {
        for (int i = 1; i < N; i++) {
            A *= A;
        }

        return A;
    }



    public int array32(int[] array)  {
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i + 1] < array[i] & array[i + 1] < array[i + 2]) {
                return array[i + 1];
            }
        }
        //return -1; // if local minimum doesn`t exist
        throw new RuntimeException("Local minimum doesnt exist");
    }

    public int[][] matrix61(int[][] matrix, int k) {
        assert(k<1 || k>matrix.length || matrix.length==0) : "Incorect input data";
        int matrix1[][] = new int[matrix.length - 1][matrix[0].length];
        int i=0,i1=0;
        while(i<matrix.length-1)
        {
            if(i-1==k){
                i++;
            }
            for(int j=0;j<matrix[0].length;j++){
                matrix1[i1][j]=matrix[i][j];
            }i++;
        }
        return matrix1;



        /*for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + 1;
            }
        }*/

       /* for (int i = 0, i1 = 0; i < matrix.length; i++, i1++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 1 == k && i + 1 != matrix.length) {
                    i++;
                } else if (i + 1 == matrix.length && k == matrix.length) {
                    break;
                }
                matrix1[i1][j] = matrix[i][j];
            }
        }*/
        /*for(int x[]:matrix1){
            for(int y: x){
                System.out.print(matrix1[i][j] + " ");
            }System.out.println();
        }*/

    }

}
