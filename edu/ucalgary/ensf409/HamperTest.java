/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.3
 @since 1.0
 */

package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HamperTest {


    //***************** Test Can be Tested multiple times with modify these values *****************
    public int[] expectedNutritionalNeedsAdultMale = {16, 28, 26, 30, 2500};
    public int[] expectedNutritionalNeedsAdultFemale = {16, 28, 26, 30, 2500};
    public int[] expectedNutritionalNeedsChildrenOver8 = {21, 33, 31, 15, 2000};
    public int[] expectedNutritionalNeedsChildrenUnder8 = {21, 33, 31, 15, 1400};

    public int numAdultMale = 1;
    public int numAdultFeMale = 1;
    public int numChildUnder8 = 1;
    public int numChildOver8 = 2;
    public int[] expectedNeedsFamily = new int[4];
    public int[] expectedNeedsFamilyPercentage = new int[4];
    //**********************************************************************************************


    /**
     * helper method to create class NutritionalItems with given family members
     */
    @Test
    public NutritionalItems createNutritionalItemsForFamily(){
        for (int i = 0; i < expectedNeedsFamily.length-1 ; i++){
            // convert percentage form of individual family member type nutritional needs to actual value of specific nutrition type
            // sum them up and store at array
            expectedNeedsFamily[i] = (numAdultMale * expectedNutritionalNeedsAdultMale[4]* expectedNutritionalNeedsAdultMale[i]*(1/100)) +
                    (numAdultFeMale * expectedNutritionalNeedsAdultFemale[4]*expectedNutritionalNeedsAdultFemale[i]*(1/100)) +
                    (numChildOver8 * expectedNutritionalNeedsChildrenOver8[4]*expectedNutritionalNeedsChildrenOver8[i]*(1/100)) +
                    (numChildUnder8 * expectedNutritionalNeedsChildrenUnder8[4]*expectedNutritionalNeedsChildrenUnder8[i]*(1/100));
        }

        // convert back to percentage form for that family
        for(int i = 0 ; i < expectedNeedsFamily.length-1 ; i ++){
            expectedNeedsFamilyPercentage[i] = (expectedNeedsFamily[i]/(expectedNeedsFamily[0]+ expectedNeedsFamily[1]
                    +expectedNeedsFamily[2]+expectedNeedsFamily[3]))*100;
        }

        // calculate weekly calories separately
        int totalCaloriesFamily = expectedNutritionalNeedsAdultMale[4]*7 + expectedNutritionalNeedsAdultFemale[4]*7
                + expectedNutritionalNeedsChildrenOver8[4]*7 + expectedNutritionalNeedsChildrenUnder8[4]*7;


        NutritionalItems expectedNutritionalItemsFamily = new NutritionalItems(expectedNeedsFamilyPercentage[0],
                expectedNeedsFamilyPercentage[1], expectedNeedsFamilyPercentage[2],expectedNeedsFamilyPercentage[3],
                totalCaloriesFamily);

        return expectedNutritionalItemsFamily;
    }


    /**
     * Hamper(nutritionalRequirements: NutritionalItems)
     * check object created successfully or not.
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     *
     */
    @Test
    public void testFamilyClassConstructor() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper actualHamper = new Hamper(expectedNutritionalItemsFamily);
        assertNotNull("Hamper class was not created", actualHamper);

    }

    /**
     *  test for getNutritionalRequirement(): NutritionalItems
     *  check if it returns NutritionalItems object
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testGetNutritionalRequirements() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        NutritionalItems actualNutritionalItem = hamper.getNutritionalRequirements();
        assertNotNull("NutritionalItem class was not returned through" +
                "getNutritionalRequirement() method", actualNutritionalItem);
    }


    /**
     *  test for setNutritionalRequirement(nutritionalRequirements: NutritionalItems)
     *  check if it set NutritionalItems with right object
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetNutritionalRequirements() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new hamepr(expectedNutritionalItemsFamily);
        NutritionalItems expectedNutritionalItems = new NutritionalItems(10,20,30,40,500);
        hamper.setNutritionalRequirements(expectedNutritionalItems);
        NutritionalItems actualNutritionalRequirements = hamper.getNutritionalRequirements();

        int actualWholeGrains = actualNutritionalRequirements.getWholeGrains();
        int actualFruitVeggies = actualNutritionalRequirements.getFruitVeggies();
        int actualProtein = actualNutritionalRequirements.getProtein();
        int actualOthers = actualNutritionalRequirements.getOthers();
        int actualCalories = actualNutritionalRequirements.getCalories();

        int expectedWholeGrains = 10;
        int expectedFruitVeggies = 20;
        int expectedProtein = 30;
        int expectedOthers = 40;
        int expectedCalories = 500;

        assertEquals("setter for WholeGrain dose unexpected behavior",
                expectedWholeGrains, actualWholeGrains);
        assertEquals("setter for FruitVeggies dose unexpected behavior",
                expectedFruitVeggies, actualFruitVeggies);
        assertEquals("setter for Protein dose unexpected behavior",
                expectedProtein, actualProtein);
        assertEquals("setter for Others dose unexpected behavior",
                expectedOthers, actualOthers);
        assertEquals("setter for Calories dose unexpected behavior",
                expectedCalories, actualCalories);
    }

    /**
     *   test for getFoodItems():ArrayList<Food>
     *   createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *   specific family with percentage form.
     */
    @Test
    public void testGetFoodItems() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        ArrayList<Food> actualFoodItems = hamper.getFoodItems();
        assertNotNull("getFoodItems() dose not returned ArrayList<Food>", actualFoodItem);

    }

    /**
     *  test for setFoodItems(foodItems: ArrayList<Food>)
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetFoodItems() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        Food apple = new Food(100,"Apple",10,20,30,40,500);
        Food orange = new Food(101,"Orange",21,22,23,34,1000);
        Food grape = new Food(102,"Grape",24,33,33,10,15);

        Arraylist<Food> foods = new ArrayList<Food>();
        foods.add(apple);
        foods.add(orange);
        foods.add(grape);
        hamper.setFoodItems(foods);

        int ActualAppleId = hamper.getFoodItems().get(0).getItemId();
        String ActualAppleName = hamper.getFoodItems().get(0).getName();
        int ActualOrangeId = hamper.getFoodItems().get(1).getItemId();
        String ActualOrangeName = hamper.getFoodItems().get(1).getName();
        int ActualGrapeId = hamper.getFoodItems().get(2).getItemId();
        String ActualGrapeName = hamper.getFoodItems().get(2).getName();

        int expectedAppleId = 100;
        String expectedAppleName = "Apple";
        int expectedOrangeId = 101;
        String expectedOrangeName = "Orange";
        int expectedGrapeId = 102;
        String expectedGrapeName = "Grape";

        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedAppleId, ActualAppleId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedAppleName, ActualAppleName);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedOrangeId, ActualOrangeId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedOrangeName, ActualOrangeName);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedGrapeId, ActualGrapeId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedGrapeName, ActualGrapeName);

    }

    /**
     * test for getIsFilled(): boolean
     * which indicates this hamper can be filled(meet nutrition requirement) with current foods in inventory
     * and, it's default value is False
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     */
    @Test
    public void testGetIsFilled() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        boolean actualIsFilled = hamper.getIsFilled();
        assertTrue("getIsFilled() was not returned correct value ",actualIsFilled);
    }

    /**
     *  test for setIsFilled(status: boolean)
     *  default value of isFilled is False
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetIsFilled() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        hamper.setIsFilled(true);
        boolean actualIsFilled = hamper.getIsFilled();
        assertFalse("setIsFilled did not update current status",actualIsFilled);
    }

    /**
     *  test for calcBestHamper()
     *  this method attempt to fill the foodItems in hamper class with most efficient way that meets nutritional requirements.
     *  if it successfully calculated best food combination with exist foods it should update the inventory and change
     *  isFilled status to true
     *  however, if it is unable to find combination of foods due to out of stock of foods in inventory, it should not
     *  update the inventory and change isFilled status to false
     */

    /*
     *  we need a clear definition of "efficient hamper" to test this method
     *  1. find set of foods that have maximum of +20% of each nutrition's per family  Y1/N1
     *
     *  Y1. find set that have minimum quantity of foods (hamper filled)
     *      *** if it has to be the most efficient we must compare every
     *      single sets and check % diff here to confirm hamper ***
     *
     *  N1. if we could not find set that fit in maximum of 20% range, then find set that exceed 20% Y2/N2
     *
     *  Y2. set that exceed 20% food set (hamper filled)
     *      *** if it has to be the most efficient we must compare every
     *      single sets and check % diff here to confirm hamper ***
     *
     *  N2. could not find food set (hamper is not filled)
     */

    /**
     *  testCalcBestHamperWithEnoughFoods() is test when the inventory have enough foods
     */
    @Test
    public void testCalcBestHamperWithEnoughFoods() {

        NutritionalItems assumedNutritionalRequirementsForFamily = new NutritionalItems(10,10,10,70,1000); //100,100,100,700
        Hamper hamper = new Hamper(assumedNutritionalRequirementsForFamily);
        // ex)  NutritionalItems(15,20,20,35,1000)
        //      min nutrition  = 100,100,100,700
        //      min +20% range = 120,120,120,840

        //      apple =  10,10,10,70,300   --> 30,30,30,210   *3
        //      orange = 70,10,10,10,300   --> 210,30,30,30   *1
        //      grape =  10,10,10,70,100   --> 10,10,10,70    *1
        //      tuna =   10,10,10,70,500   --> 50,50,50,350   *2

        // few possible sets = 2 apple and 1 tuna --> 110,110,110,770 (1)
        //                     2 tuna                                 (2)
        // since (2) needs only 2 foods while (1) requires 3 foods this CalcBestHamperWithEnoughFoods()
        // must save two tunas into its foodItems array and delete tuna0, and tuna1 from inventory hash map and set is filled true

        HashMap<Integer, Food> smallInventory = new HashMap<Food>();

        Food apple0 = new Food(100,"Apple",10,10,10,70,300);
        Food orange0 = new Food(101,"Orange",70,10,10,10,300);
        Food grape0 = new Food(102,"Grape",10,10,10,70,100);
        Food tuna0 = new Food(103,"Tuna",10,10,10,70,500);
        Food tuna1 = new Food(104,"Tuna",10,10,10,70,500);
        Food apple1 = new Food(105,"Apple",10,10,10,70,300);
        Food apple2 = new Food(106,"Apple",10,10,10,70,300);

        smallInventory.put(100, apple0);
        smallInventory.put(101, orange0);
        smallInventory.put(102, grape0);
        smallInventory.put(103, tuna0);
        smallInventory.put(104, tuna1);
        smallInventory.put(105, apple1);
        smallInventory.put(106, apple2);


        hamper.calcBestHamper();
        // see if it deletes other foods then tuna0 and tuna1
        assertEquals("calcBestHamper() deleted wrong foods",apple0,smallInventory.get(100));
        assertEquals("calcBestHamper() deleted wrong foods",orange0,smallInventory.get(101);
        assertEquals("calcBestHamper() deleted wrong foods",grape0,smallInventory.get(102));
        assertEquals("calcBestHamper() deleted wrong foods",apple1,smallInventory.get(105));
        assertEquals("calcBestHamper() deleted wrong foods",apple2,smallInventory.get(106));

        // see if it deletes food that require to fill hamper
        assertNull("calcBestHamper() deleted wrong foods",smallInventory.get(103));
        assertNull("calcBestHamper() deleted wrong foods",smallInventory.get(104));


        // see if it fills its foodItems: ArrayList<Food>
        expectedFoodsinArray0 = hamper.getFoodItems().get(0);
        expectedFoodsinArray1 = hamper.getFoodItems().get(1);
        assertEquals("calcBestHamper() filled food array with wrong foods",tuna0, hamper.expectedFoodsinArray0);
        assertEquals("calcBestHamper() filled food array with wrong foods",tuna1, hamper.expectedFoodsinArray1);

        // see if it set isFilled to true
        assertTrue("even hamper is filled it did not set isFilled to true", hamper.getIsfilld());

    }

    /**
     *  testCalcBestHamperWithNotEnoughFoods() is test when the inventory have Not enough foods
     */
    @Test
    public void testCalcBestHamperWithNotEnoughFoods() {
        NutritionalItems assumedNutritionalRequirementsForFamily = new NutritionalItems(10,10,10,70,1000); //100,100,100,700
        Hamper hamper = new Hamper(assumedNutritionalRequirementsForFamily);
        //      min nutrition  = 100,100,100,700
        //      apple =  10,10,10,70,300   --> 30,30,30,210   *1
        //      orange = 70,10,10,10,300   --> 210,30,30,30   *1
        //      grape =  10,10,10,70,100   --> 10,10,10,70    *1
        //      tuna =   10,10,10,70,500   --> 50,50,50,350   *1
        //      it is not possible to form a hamper with given foods that meets minimum requirement

        Food apple0 = new Food(100,"Apple",10,10,10,70,300);
        Food orange0 = new Food(101,"Orange",70,10,10,10,300);
        Food grape0 = new Food(102,"Grape",10,10,10,70,100);
        Food tuna0 = new Food(103,"Tuna",10,10,10,70,500);

        smallInventory.put(100, apple0);
        smallInventory.put(101, orange0);
        smallInventory.put(102, grape0);
        smallInventory.put(103, tuna0);

        hamper.calcBestHamper();

        // see if it deletes foods even hamper cannot be filled (which should not)
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",apple0,smallInventory.get(100));
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",orange0,smallInventory.get(101));
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",grape0,smallInventory.get(102));
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",tuna0,smallInventory.get(100));

        // see if it fills its foodItems: ArrayList<Food> even hamper cannot be filled (which should not)
        assertEquals("calcBestHamper() filled its array of foods when hamper could not filled", 0,
                hamper.getFoodItems().size());

        // see if it set isFilled is still false
        assertFalse("even hamper cannot be filled, the status is true", hamper.getIsfilld());

    }

}