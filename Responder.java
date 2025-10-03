import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 * The responder class represents a response generator object. It is used
 * to generate an automatic response. This is the second version of this 
 * class. This time, we generate some random behavior by randomly selecting 
 * a phrase from a predefined list of responses.
 * 
 * @author   Michael Kölling and David J. Barnes
 * @version 7.2
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> replies;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        replies = new HashMap<>();
        fillResponses();
    }

    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
    public void generateResponse(String word)
    {
        // Pick a random number for the index in the default response 
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        if (replies.containsKey(word))
        {
            System.out.println(replies.get(word));
        }
        else
        {
            pickDefaultResponse();
        }
    }
    
    public String pickDefaultResponse()
    {
        return "wow";
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponses()
    {
        replies.put("What", "That sounds odd. Could you describe this in more detail?");
        replies.put("How","""
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        replies.put("Why","I need a bit more information on that.");
        replies.put("Who","Have you checked that you do not have a dll conflict?");
        replies.put("When","That is covered in the manual. Have you read the manual?");
        replies.put("Where","""
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        replies.put("Bug","That's not a bug, it's a feature!");
        replies.put("hmm","Could you elaborate on that?");
        replies.put("Which","Have you tried running the app on your phone?");
        replies.put("Whom","I just checked StackOverflow - they don't know either.");
    }
}