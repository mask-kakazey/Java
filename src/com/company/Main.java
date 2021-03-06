package com.company;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Main {


    public static String[] input() throws WrongInputException {

        Scanner in = new Scanner(System.in);
        System.out.println("TypeOfATU/Title/Square/Population/Name/Surname/Position");
        String str;
        String dis[]=null;
        try {
            str = in.nextLine();
            dis = str.split("/",7);
            if (dis.length<7) throw new WrongInputException("Too short input");
            TypeOfATU.getTypeByUrl(dis[0]);
            Double.valueOf(dis[2]);
            Integer.valueOf(dis[3]);
        }
        catch (NumberFormatException e) {
            throw new WrongInputException("Wrong double or int input");
        }
        catch (IllegalArgumentException e) {
            throw new WrongInputException("Wrong enum input");
        }
        finally {
            //System.out.println("Clean garbage :)");
        }
        return dis;
    }


    public static void main(String[] args) {

        ArrayList<District>district1 = new ArrayList<>();

        district1.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Maks", "Kakazey","manager"));
        district1.add(new District(TypeOfATU.DISTRICT,"Southside",2.4,123,
                "Ivan", "Remmyt","manager"));

        ArrayList<District>district2 = new ArrayList<>();

        district2.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Maks", "Kakazey","manager"));

        //System.out.println("Posible type of ATU: " + TypeOfATU.all());
        String dis[]= null;
        /*while (true) {
            try {
//                dis = input();
                break;
            } catch (WrongInputException e) {
                System.out.println(e);
            }
        }

        district2.add(new District(TypeOfATU.getTypeByUrl(dis[0]),dis[1],Double.valueOf(dis[2]), Integer.valueOf(dis[3]),
                dis[4], dis[5],dis[6]));
        */

        ArrayList<Village>village1 = new ArrayList<>();

        village1.add(new Village(TypeOfATU.VILLAGE,"Verhovina",162.4,9232,
                "Ivan", "Ivanov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Viyki",20,41,
                "Sidor", "Sidorov","head", "harvest"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Sinelnikovo",20,50,
                "Sidor", "Sidorov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Usichi",20,30,
                "Sidor", "Sidorov","head", "harvest"));


        ArrayList<City>city1 = new ArrayList<>();

        city1.add(new City(TypeOfATU.CITY,"Dnepr",2000,115241,
                "Dmitriy", "Efremov","mayor", district1));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,116524,
                "Bogdanov", "Bogdan","mayor", district2));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,116524,
                "Bogdanov", "Bogdan","governor", district2));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,116524,
                "Bogdanov", "Bogdan","mayor", district2));


        ArrayList<City>city2 = new ArrayList<>();

        city2.add(new City(TypeOfATU.CITY,"Dnepr",2000,115241,
                "Dmitriy", "Efremov","mayor", district1));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));

        Region region = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city1,city1.get(0),village1);
        Region region1 = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city2,city2.get(0),village1);

        ArrayList<Region>listOfRegion = new ArrayList<>();
        listOfRegion.add(region);
        listOfRegion.add(region1);
        System.out.println(Region.getCityPopulationSum(region.getCity()));
        System.out.println(Region.getAveragePopulaiton(region.getVillage()));
        System.out.println(Region.getMaxPopulation(region.getCity()));
        System.out.println(Region.getMostFrequentTitleNames(listOfRegion));

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        region.display();
        //System.out.println(TypeOfATU.all());

        Date data1 = new Date();
        Voting voting1 = new Voting("Local elections",data1);
        voting1.changeManager(village1.get(0), "Maks", "Kakazey", "head");

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        region.display();

        System.out.println(district1.get(0).equals(district2.get(0)));

    }
}
