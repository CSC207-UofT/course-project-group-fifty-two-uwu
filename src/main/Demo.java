/* This is the Demo class that is for the purpose of showing how this game werks.
 * We should NOT and will NOT use this type of implementation as the final version.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    Stat INT = new Stat("Intelligence", "Knowledge of truth", 5, 0, 20);
    Stat PSY = new Stat("Psyche", "Understanding of mind", 3, 0, 20);
    Stat madness = new Stat("Madness", "The diversion of logics...", 20);
    Stat sadness = new Stat("Sadness", "The lamenting of loss...", 0);
    ArrayList<Stat> StatList = new ArrayList<>(Arrays.asList(INT, PSY, madness, sadness));
    Player you = new Player("Bebe Booboo", StatList, 2);
    Item reminiscence = new Reminiscence();

    public void part_one() {
        System.out.print("\n\t'History is the scar on the world's skin' - Ariya Sacca");
        for (int i = 0; i < 10; i ++){
            System.out.println();
        }
        System.out.print("\n\t'As I sailing through the rivers, I couldn't help but begin to wonder its end..'");
        System.out.print("\n\t'So much has already fallen to ruin, yet we still exits, to witness and to record...'");
        System.out.print("\n\t'Only to wait till our memory shatters and fades..'");
        System.out.print("\n\t'One day, we will inevitably fall into ashes and dusts...'");
        System.out.print("\n\t'But such is not the reason to forsake it.'");
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\tYou are reading the memoir of arguably the most outstanding archeologist in the past decades.");
        System.out.print("\n\tIn fact, this is her last memoir published ");
        System.out.print("\n\tWhat happended to her? And why does this name felt hauntingly familiar?");
        System.out.print("\n\tWill you try to recall the details?");
        System.out.print("\n\t[An easy check of Intelligence(requires 8)]");
        System.out.print("\n\t[1: try to recall]");
        System.out.print("\n\t[2: do not]");
        System.out.print("\n\t[Please type in your choice]");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1){
            this.check_one();
        }
        else {
            this.refuse_check_one();
        }
    }

    public void refuse_check_one(){
        if (you.value("Sadness") == 100){
            this.sadness_end();
        }
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\t[You refused to recall] ");
        System.out.print("\n\t[Maybe not all of the mysteries should come with an answer?] ");
        System.out.print("\n\t[But the shame you had now holds you even tighter...] ");
        System.out.print("\n\t[Your Sadness has increased by 30] ");
        you.change("Sadness", 30);
        System.out.print("\n\t[Your Sadness is currently at " + you.value("Sadness") + "]");
    }

    public void check_one(){
        Check check1 = new Check(8, "Intelligence", 25, "Sadness", 6);

        if (check1.check(you)){
            this.check_one_pass();
        }
        else {
            this.check_one_fail();
        }
    }

    public void check_one_pass(){
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\t[Check Passed!!!] ");
        System.out.print("\n\tYou remembered her smile in the corridor");
        System.out.print("\n\tEvery time you pass the hall way of the archeology department, she regards you from her painting");
        System.out.print("\n\tShe never came back from her last expedition");
        System.out.print("\n\tMost people say that she met her fate eventually...");
        System.out.print("\n\tYet others believe she found what she was pursuing all this time");
        you.addItem(new Reminiscence());
        System.out.print("\n\t[1 piece of Reminiscence has been added to your inventory]");
        System.out.print("\n\t[Reminiscence could help to reduce the progression of Madness]");
    }

    public void check_one_fail(){
        if (you.value("Sadness") == 100){
            this.sadness_end();
        }
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\t[Check Failed!!!] ");
        System.out.print("\n\t[You couldn't help but feel like out of all the questions you should not forget this one...] ");
        System.out.print("\n\t[Shame] ");
        System.out.print("\n\t[Your Sadness has increased by 25] ");
        System.out.print("\n\t[Your Sadness is currently at " + you.value("Sadness") + "]");
        System.out.print("\n\tLooks like this name will haunt you for a little longer");
        System.out.print("\n\tWill you try to recall again?");
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\t[An easy check of Intelligence(requires 8)]");
        System.out.print("\n\t[1: try to recall]");
        System.out.print("\n\t[2: do not]");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1){
            this.check_one();
        }
        else {
            this.refuse_check_one();
        }
    }

    public void sadness_end(){
        System.out.print("\n\t---------------------------------------------------------------------------------------------");
        System.out.print("\n\tYou closed your eyes, but your tear could not be stopped so easily");
        System.out.print("\n\tNothing matters, nothing exists, the only thing filled your mind was the unending sorrow");
        System.out.print("\n\tAnd pain.");
        System.out.print("\n\t[You met your end because your sadness has gone out of control] ");
        System.exit(0);
    }

}
