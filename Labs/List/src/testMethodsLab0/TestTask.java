package testMethodsLab0;

import methodsLab0.List;
import methodsLab0.List.Begin15;
import methodsLab0.List.While15;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* @org.testng.annotations.Test
    public void testBegin19() throws Exception {
    }*/

public class TestTask {
    private List temp=new List();
    /////////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][]beginProvider(){
        return new Object[][]{{824.0616,32.4,101.736},{181.3664,15.2,47.728}};
    }
    @Test(dataProvider="beginProvider")
    public  void beginTest(double S,double D,double L){
        Assert.assertEquals(temp.begin15(S),new Begin15(D,L));
    }

   /* public void negativeBegin15Test() throws Exception {
        temp.begin15(-2);
    }*/
    @Test(expectedExceptions = AssertionError.class)
    public void negativeBeginTest(){
        temp.begin15(2);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] whileProvider(){
        return new Object[][]{{4,3,1124.8639999999998},{7,2,1144.9}};
    }
    @Test(dataProvider="whileProvider")
    public void whileTest(double P,int k,double S){
        Assert.assertEquals(temp.while15(P),new While15(k,S));
    }
    /*@Test
    public void negativeWhileTest()throws Exception {
        temp.while15(-2.2222);
    }*/
    /*@Test(expectedExceptions = AssertionError.class)
    public void negativeWhileTest(){
        temp.while15(-2);
    }*/
    //////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] integerProvider(){
        return new Object[][] {{165,615},{255,525}};
    }
    @Test(dataProvider="integerProvider")
    public void integerTest(int abc,int bac){
        Assert.assertEquals(temp.integer15(abc),bac);
    }
    @Test
    public void negativeIntegerTest() throws Exception {
        temp.integer15(-2);
    }
   /* @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        temp.integer15(-2);
    }*/
    /////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] booleanProvider(){
        return new Object[][] {{15,-65,10,true},{-55,-525,-55,false}};
    }
    @Test(dataProvider="booleanProvider")
    public void booleanTest(int A,int B,int C,boolean flag) {
        Assert.assertEquals(temp.boolean15(A,B,C), flag);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] ifProvider(){
        return new Object[][]{{15,16,17,33},{1,2,8,10}};
    }
    @Test(dataProvider="ifProvider")
    public void ifTest(int a,int b,int c,int summury){
        Assert.assertEquals(temp.if15(a, b, c),summury);
    }
    ////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] caseProvider(){
        return new Object[][]{{6,1,"Шість піки"},{7,2,"Сім хреста"},{8,3,"Вісім бубна"},{9,4,"Дев'ять чірви"},{10,1,"Десять піки"},{11,2,"Валет хреста"},{12,3,"Дама бубна"},{13,4,"Король чірви"},{14,1,"Туз піки"}};
    }
    @Test(dataProvider="caseProvider")
    public void caseTest(int number, int mast, String card){
        Assert.assertEquals(temp.case15(number,mast),card);
    }
    @Test
    public void negativeCaseTest()throws Exception{
        temp.case15(-2,-2);
    }
   /* @Test(expectedExceptions = AssertionError.class)
    public void negativeCaseTest(){
        temp.case15(-2,-2);
    }*/
    /////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] forProvider(){
        return new Object[][]{{2,2,4},{4.2,2,17.64}};
    }
    @Test(dataProvider="forProvider")
    public void forTest(double A,int N,double AN){
        Assert.assertEquals(temp.for15(A, N),AN);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] arrayProvider(){
        return new Object[][]{{new int[] {3,2,3,1}, 2},{new int[]{1,2,4,3,2,2,2,40,30,60,80},30}};
    }
    @Test(dataProvider="arrayProvider")
    public void arrayTest(int [] array,int localMinimum){
        Assert.assertEquals(temp.array32(array),localMinimum);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @DataProvider
    public Object[][] matrixProvider(){
        int[][]arr4={{1,1,1}};
        int[][]arr5={{}};
        int[][]arr1={{1,1,1},{2,2,2},{3,3,3},{4,4,4},{5,5,5},{6,6,6}};
        int[][]arr2={{1,1,1},{3,3,3},{4,4,4},{5,5,5},{6,6,6}};
        int[][]arr3={{1,1,1},{2,2,2},{3,3,3},{5,5,5},{6,6,6}};
        return new Object[][]{{arr4,1,arr5},{arr1,4,arr3}};
    }
    @Test(dataProvider="matrixProvider")
    public void matrixTest(int [][] array,int k,int [][]rezultArray){
        rezultArray.equals(temp.matrix61(array,k));
    }
    @DataProvider
    public Object[][]negativeMatrixProvider(){
        int [][]arr={{0,0,0},{0,0,0}};
        return new Object[][] {{arr,-2},{arr,-3}};
    }
    @Test(dataProvider = "negativeMatrixProvider" )
    public void negativeMatrixTest(int [][] array,int k)throws Exception {
        temp.matrix61(array, k);
    }
    /*@Test(expectedExceptions = AssertionError.class)
    public void negativeMatrixTest(){
        temp.matrix61(null,-2);
    }*/
}








