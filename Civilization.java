import java.util.Scanner;


public class Civilization {
    static boolean playing = true;

    static String civilizationType; 
    static String[] cities;
    static int citiesCounter=1;
    static int numOfAttacks=0;
    static double gold=20.5;
    static double resources=30.0; 
    static int happiness=10; 
    static int militaryUnits=0;
    static int technologyPoints=0; //what is the default value...

    


    public static void main(String[] args) {

        	//Make user choose the leader. 
            System.out.println();
        	Scanner in = new Scanner(System.in);
        	System.out.println("--------Civilizations--------");
            System.out.println("0: American (George Washington)");
            System.out.println("1: Zulu (Shaka)");
            System.out.println("2: English (Queen Elizabeth I)");
            System.out.println("3: Chinese (Wu Zetain)");
            String[] leaders = {"American (George Washington)", "Zulu (Shaka)",
             "English (Queen Elizabeth I)", "Chinese (Wu Zetain)"};
             System.out.print("\nWhat kind of Civilization do you want to lead?\nEnter the corresponding number:");
             civilizationType = leaders[in.nextInt()];



			//Make user name city. 
            System.out.println();
			System.out.print("You have one city. Please name it: ");
			cities = new String[5];
			in.nextLine(); //get rid of the ENTER key that was pressed before. 
			cities[0] = in.nextLine();            
            

			//gameplay. Need to create another while loop. 
			while(playing)
			{
				System.out.println(); //create some space to make it look clean 

            
                
                
                printUpdate();


				presentOptions(); //present the options.

				int option = in.nextInt(); //take in input 

                performTurn(option);

                System.out.println();
                update(); //update on properties. 

                if(technologyPoints >=20 || numOfAttacks >=10)
                {
                    playing = false; 
                }

			}

        System.out.println("CONGRATULATIONS. YOU HAVE WON THE GAME.)");
        
    }// end of main method 
    public static void performTurn(int k)
    {
        switch (k)
        {
            case 0 : 
            {
                if(citiesCounter >=5 || gold < 15.5)
                {
                    failTurn();
                    break;
                }
                gold -= 15.5;
                SettleCity();
                break;
            }

            case 1: 
            {
                if(citiesCounter<2)
                {
                    failTurn();
                    break;
                }
                DemolishCity();
                resources+= 1.5;
                break;
            }
            case 2: 
            {
                if(gold <5 || resources <3)
                {
                    failTurn();
                    break;
                }
                BuildMilitia();
                break;
            }
            case 3: 
            {
                if(gold <50 || resources<2)
                {
                    failTurn();
                    break;
                }
                ResearchTechnology();
                break;
            }
            case 4: 
            {
                if(militaryUnits<6)
                {
                    failTurn();
                    break;
                }
                AttackCity();
                break;
            }
            case 5: 
            {
                break;
            }
        }
    }


    public static void BuildMilitia()
    {
        gold -= 5;
        resources -=3;
        militaryUnits++;
    }

    public static void ResearchTechnology()
    {
        gold -= 50;
        resources -= 2;
        technologyPoints++;
    }

    public static void AttackCity()
    {
        militaryUnits -= 6;
        happiness -=3;
        gold +=10;
        numOfAttacks ++;
    }

    public static void failTurn()
    {
        System.out.print("\nYou cannot perform this action. Your turn is over.");
    }

    public static void SettleCity()
    {

        Scanner input = new Scanner(System.in);
        System.out.print("\nCurrent Cities: ");
        for(int i =0; i<citiesCounter; i++)
        {
            System.out.print("(" +1 + ") " +cities[i] + " "); 
        }
        System.out.print("\nPlease Enter a name for your new city: "); 
        citiesCounter++; 

        cities[citiesCounter-1] = input.nextLine(); 
    }

    public static void DemolishCity()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Current Cities: ");
        for(int i =0; i<citiesCounter; i++)
        {
            System.out.print("(" + i + ") " +cities[i] + " ");
        }
        System.out.print("\nEnter corresponding number of city to be demolished: ");
        int index = in.nextInt(); 

        if(index == citiesCounter-1)
        {
            String[] temp = new String[5];
            for(int i=0; i<citiesCounter-1;i++)
            {
                temp[i] = cities[i];
            }
            cities = temp; 
        }
        else
        {
            String tempstring = cities[citiesCounter-1];
            cities[index] = tempstring; 
        }
        citiesCounter--;  
        }

         public static void presentOptions()
        {
        System.out.println("\n---------Actions-----------");
        System.out.println("0: Settle a City");
        System.out.println("1: Demolish a City");
        System.out.println("2: Build Militia");
        System.out.println("3: Research Technolgoy");
        System.out.println("4: Attack Enemy City");
        System.out.println("5: End Turn\n");
        System.out.print("Please enter an option number:");
        }


        public static void update()
        {
        resources++;
        if(happiness>20)
        {
            resources+= 5*citiesCounter;
        }
        gold += 3*citiesCounter;

        if(resources%2 ==0)
        {
            happiness++;
        }
        else 
        {
            happiness-=3;
        }
        }

    

      public static void printUpdate()
        {
                System.out.println("-----Current Properties-----");
                System.out.printf("%s%11s%n","Number of attacks: ", numOfAttacks);
                System.out.printf("%s%25.2f%n","Gold:", gold);
                System.out.printf("%s%20.2f%n","Resources:" ,resources);
                System.out.printf("%s%21s%n","Happiness", happiness);
                System.out.printf("%s%22s%n","Military", militaryUnits);
                System.out.printf("%s%20s%n","Technology", technologyPoints);
         }

    



}// end of class 
