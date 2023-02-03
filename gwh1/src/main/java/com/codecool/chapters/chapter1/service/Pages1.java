package com.codecool.chapters.chapter1.service;

import com.codecool.service.Printer;

public class Pages1 {

   public static void printPage1() {
      Printer.printPage(
              "The village is calm and quiet. * The snow paints the scenery white. *" +
              "The chimneys of the houses smoke as they make the rooms warm and comfortable. *" +
              "The old hunter sits in his rocking chair and reads his favourite book, which he " +
                      "received from his grand-grand-father as a small child. *" +
              "In the book, there was a chapter about the legend of the giant white wolf, " +
              "which was never seen yet by humanly eyes but was heard every night in the village. *" +
              "You just arrived to the house of the hunter. You stays in front of his door. *" +
              "Push the doorbell to get in the house.");
   }

   public static void printPage2() {
      Printer.printPage(
              "The hunter hears, that somebody rings the bell. *" +
              "'Who the heck want to talk to me in the night? Is it a stranger or something bad happend?'" +
              "- thinks the hunter and goes calmly to the door. * As he opens it, he sees a young man in hunter" +
              "clothes with a big backpack. * 'Who are you, who disturbs me this late? What do you want from me, " +
              "young man?'");
   }

   public static void printPage3() {
      Printer.printPage(
              "'Hey John, God thank you`re at home! " +
              "Can you let me in? * I want to hear the legend of the giant white wolf, because I think, " +
              "I know, where it could be. I heard some rumors. Are you interested?' * 'Yeah, for sure. " +
              "But firstly, I beg your pardon, my friend, I am such an old fool, I can't remember your name. * " +
              "Can you tell me, who you are?'");
   }

   public static void printPage4(String name) {
      Printer.printPage(
              "'Oooh " + name + ", long time no see my friend, " +
              "come in. * Sure I can tell about the legend but first tell me what's going on with you?'");
   }

   public static void printPage5() {
      Printer.printPage("'Anyway, I need a drink for sure. * Have a seat in the main hall, until then " +
              "I fetch some good old scotch.'");
      Printer.printNarrative("You go to the main hall and you recognise the big black book on the table " +
              "near the rocking chair. * You can't wait and you take it in your hand. * You are searching for " +
              "the chapter about the wolf, as the old hunter arrives from the kitchen.");
      Printer.printPage("'What you are looking for is on page 65, chapter 12. * You can start to read it " +
              "loud, my eyes are old and the light is weak in the room. * So, just start to read.'");
      Printer.printNarrative("As you read the story about a wolf, which hunted down hundreds in the village " +
              "100 years ago, you and the old hunter hear something. * Some noise from outside. * The sound comes " +
              "from the woods, it sound like a howl but much deeper and way more frightening.");
      Printer.printPage("'This is him! The giant white wolf!' - said John. 'Come, prepare yourself, my son. " +
              "We need some weapon and equipment, to go out to the woods.'");
   }
}
