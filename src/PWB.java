import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PWB {

    public static void main(String[] args){
        try {
            BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please input the first file name: ");
            String instr1 = input1.readLine();
            BufferedReader br1 = new BufferedReader(new FileReader("src/"+instr1));

            BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please input the second file name: ");
            String instr2 = input2.readLine();
            BufferedReader br2 = new BufferedReader(new FileReader("src/"+instr2));

            Collection<Wine> wines = new ArrayList<>();
            int id = 1;



            String str1 = br1.readLine();
            while (str1 != null){

                str1 = br1.readLine();
                if (str1 != null) {
                    //This if is used for prevent str1 become null when read to the end of the stream

                    String spl = str1;
                    String[] item;
                    item = spl.split(";");
                    Double[] item_double = new Double[item.length];
                    //Use split to divide every single line with ";"
                    //define item_double to store the Double type array


                    for (int i = 0; i < 12; ) {
                        double value = Double.valueOf(item[i]);
                        item_double[i] = value;
                        i++;
                    }
                    //Transform String type to Double type in item array, then store in a new array item_double

                    Wine wine = new Wine();
                    wine.setFixed_acidity(item_double[0]);
                    wine.setVolatile_acidity(item_double[1]);
                    wine.setCitric_acid(item_double[2]);
                    wine.setResidual_sugar(item_double[3]);
                    wine.setChlorides(item_double[4]);
                    wine.setFree_sulfur_dioxide(item_double[5]);
                    wine.setTotal_sulfur_dioxide(item_double[6]);
                    wine.setDensity(item_double[7]);
                    wine.setpH(item_double[8]);
                    wine.setSulphates(item_double[9]);
                    wine.setAlcohol(item_double[10]);
                    wine.setQuality(item_double[11]);

                    wine.setID(id);
                    wine.setWineKind("RedWine");

                    wines.add(wine);
                    id = id + 1;

                }
                else {
                    break;
                }
            }

            String str2 = br2.readLine();
            while (str2 != null){
                str2 = br2.readLine();

                if (str2 != null) {

                    String spl = str2;
                    String[] item;
                    item = spl.split(";");
                    Double[] item_double = new Double[item.length];

                    for (int i = 0; i < 12; ) {
                        double value = Double.valueOf(item[i]);
                        item_double[i] = value;
                        i++;
                    }

                    Wine wine = new Wine();
                    wine.setFixed_acidity(item_double[0]);
                    wine.setVolatile_acidity(item_double[1]);
                    wine.setCitric_acid(item_double[2]);
                    wine.setResidual_sugar(item_double[3]);
                    wine.setChlorides(item_double[4]);
                    wine.setFree_sulfur_dioxide(item_double[5]);
                    wine.setTotal_sulfur_dioxide(item_double[6]);
                    wine.setDensity(item_double[7]);
                    wine.setpH(item_double[8]);
                    wine.setSulphates(item_double[9]);
                    wine.setAlcohol(item_double[10]);
                    wine.setQuality(item_double[11]);

                    wine.setID(id);
                    wine.setWineKind("WhiteWine");

                    wines.add(wine);
                    id = id + 1;

                }
                else {
                    break;
                }
            }





            System.out.println("Q1. Number of wine samples : " + id + "\n");


            int red = 0; int white = 0;
            Iterator<Wine> iterator_RedOrWhite = wines.iterator();
            while (iterator_RedOrWhite.hasNext()){
                Wine wine_iter = iterator_RedOrWhite.next();
                if (wine_iter.getWineKind().equals("RedWine")){
                    red = red + 1;
                }
                else {
                    white = white + 1;
                }
            }
            System.out.println("Q2. Number of red wine samples : " + red + " out of " + id + "\n");
            System.out.println("Q3. Number of white wine samples : " + white + " out of " + id + "\n");


            DecimalFormat df = new DecimalFormat("0");
            double top = 0;
            ArrayList<Double> TopIDList = new ArrayList<>();
            double topid;
            ArrayList<String> TopType = new ArrayList<>();
            String toptype = null;

            Iterator<Wine> iterator_best_quality = wines.iterator();
            while (iterator_best_quality.hasNext()){
                Wine wine_iter = iterator_best_quality.next();
                if (wine_iter.getQuality() > top){
                    TopIDList.clear();
                    TopType.clear();
                    top = wine_iter.getQuality();
                    topid = wine_iter.getID();
                    toptype = wine_iter.getWineKind();
                    TopIDList.add(topid);
                    TopType.add(toptype);
                }
                else if (wine_iter.getQuality() == top){
                    top = wine_iter.getQuality();
                    topid = wine_iter.getID();
                    TopIDList.add(topid);
                    TopType.add(toptype);
                }
                else {}
            }
            String topstr = "";
            for (int i=0;i<TopIDList.size();){
                topstr +="[" + df.format(TopIDList.get(i)) + " " + TopType.get(i) + "]  ";
                i++;
            }
            System.out.println("Q4. The best quality in wine samples is : quality " + top);
            System.out.println("    The ID of best wine samples is : " + topstr + "\n");


            double bottom = 10;
            ArrayList<Double> BottomIDList = new ArrayList<>();
            double bottomid;
            ArrayList<String> BottomType = new ArrayList<>();
            String bottomtype = null;
            Iterator<Wine> iterator_worst_quality = wines.iterator();
            while (iterator_worst_quality.hasNext()){
                Wine wine_iter = iterator_worst_quality.next();
                if (wine_iter.getQuality() < bottom){
                    BottomIDList.clear();
                    BottomType.clear();
                    bottom = wine_iter.getQuality();
                    bottomid = wine_iter.getID();
                    bottomtype = wine_iter.getWineKind();
                    BottomIDList.add(bottomid);
                    BottomType.add(bottomtype);
                }
                else if (wine_iter.getQuality() == bottom){
                    bottom = wine_iter.getQuality();
                    bottomid = wine_iter.getID();
                    BottomIDList.add(bottomid);
                    BottomType.add(bottomtype);
                }
                else {}
            }
            String bottomstr = "";
            for (int i=0;i<BottomIDList.size();){
                bottomstr +="[" + df.format(BottomIDList.get(i)) + " " + BottomType.get(i) +"]  ";
                i++;
            }
            System.out.println("Q5. The worst quality in wine samples is : quality " + bottom);
            System.out.println("    The ID and type of worst wine samples is : " + bottomstr + "\n");


            double hph = 0;
            ArrayList<Double> HphListID = new ArrayList<>();
            double hphid;
            ArrayList<String> HphType = new ArrayList<>();
            String hphtype = null;
            Iterator<Wine> iterator_High_pH = wines.iterator();
            while (iterator_High_pH.hasNext()){
                Wine wine_iter = iterator_High_pH.next();
                if (wine_iter.getpH() > hph){
                    HphListID.clear();
                    HphType.clear();
                    hph = wine_iter.getpH();
                    hphid = wine_iter.getID();
                    hphtype = wine_iter.getWineKind();
                    HphListID.add(hphid);
                    HphType.add(hphtype);
                }
                else if (wine_iter.getpH() == hph){
                    hph = wine_iter.getpH();
                    hphid = wine_iter.getID();
                    HphListID.add(hphid);
                    HphType.add(hphtype);
                }
                else {}
            }
            String hphstr = "";
            for (int i=0;i<HphListID.size();){
                hphstr +="[" + df.format(HphListID.get(i)) + " " + HphType.get(i) +"]  ";
                i++;
            }
            System.out.println("Q6. The highest pH in wine samples is : pH " + hph);
            System.out.println("    The ID and type of highest pH wine samples is : " +hphstr + "\n");


            double lph = 14;
            ArrayList<Double> LphListID = new ArrayList<>();
            double lphid;
            ArrayList<String> LphType = new ArrayList<>();
            String lphtype = null;
            Iterator<Wine> iterator_Low_pH = wines.iterator();
            while (iterator_Low_pH.hasNext()){
                Wine wine_iter = iterator_Low_pH.next();
                if (wine_iter.getpH() < lph){
                    LphListID.clear();
                    LphType.clear();
                    lph = wine_iter.getpH();
                    lphid = wine_iter.getID();
                    lphtype = wine_iter.getWineKind();
                    LphListID.add(lphid);
                    LphType.add(lphtype);
                }
                else if (wine_iter.getpH() == lph){
                    lph = wine_iter.getpH();
                    lphid = wine_iter.getID();
                    LphListID.add(lphid);
                    LphType.add(lphtype);
                }
                else {}
            }
            String lphstr = "";
            for (int i=0;i<LphListID.size();){
                lphstr +="[" + df.format(LphListID.get(i)) + " " + LphType.get(i) +"]  ";
                i++;
            }
            System.out.println("Q7. The lowest pH in wine samples is : pH " + lph);
            System.out.println("    The ID and type of highest pH wine samples is : " +lphstr + "\n");


            double hvalue = 0;
            Iterator<Wine> iterator_hvalue = wines.iterator();
            while (iterator_hvalue.hasNext()){
                Wine wine_iter = iterator_hvalue.next();
                if (wine_iter.getAlcohol() > hvalue && wine_iter.getWineKind().equals("RedWine")){
                    hvalue = wine_iter.getAlcohol();
                }
                else {}
            }
            System.out.println("Q8. The highest value of alcohol grade for whole samples of red wine: " + hvalue + "\n");


            double lvalue = 100;
            Iterator<Wine> iterator_lvalue_citric = wines.iterator();
            while (iterator_lvalue_citric.hasNext()){
                Wine wine_iter = iterator_lvalue_citric.next();
                if (wine_iter.getCitric_acid() < lvalue && wine_iter.getWineKind().equals("WhiteWine")){
                    lvalue = wine_iter.getCitric_acid();
                }
                else {}
            }
            System.out.println("Q9. The lowest value of citric acid of whole samples of white wine: " + lvalue + "\n");


            double total = 0; int num = 0;
            Iterator<Wine> iterator_average_acohol = wines.iterator();
            while (iterator_average_acohol.hasNext()){
                Wine wine_iter = iterator_average_acohol.next();
                if (wine_iter.getWineKind().equals("WhiteWine")){
                    total += wine_iter.getAlcohol();
                    num = num + 1;
                }
                else {}
            }
            DecimalFormat df2 = new DecimalFormat("0.000");
            System.out.println("Q10. The average value of acohol grade of whole samples of white wine: " + df2.format(total/num));



        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}

