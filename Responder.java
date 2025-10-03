import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;

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
    private boolean defaultMod;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        replies = new HashMap<>();
        fillResponses();
        defaultMod = false;
    }

    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        // Pick a random number for the index in the default response 
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        String sentence = "";
        boolean verify = false;
        for (String word : words)
        {
            String response = replies.get(word);
            if (response !=null)
            {
                sentence = sentence + " " + response;
                verify = true;
            }
        }
        if (verify == true)
        {
            return sentence;
        }
        return pickDefaultResponse();
    }
    
    public String pickDefaultResponse()
    {
        if(defaultMod==true)
        {
            defaultMod = false;
            return "wow";
        }
        else
        {
            defaultMod = true;
            return "cool";
        }
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponses()
    {
        replies.put("what", "That sounds odd. Could you describe this in more detail?");
        replies.put("how","""
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        replies.put("why","I need a bit more information on that.");
        replies.put("who","Have you checked that you do not have a dll conflict?");
        replies.put("when","That is covered in the manual. Have you read the manual?");
        replies.put("where","""
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        replies.put("bug","That's not a bug, it's a feature!");
        replies.put("hmm","Could you elaborate on that?");
        replies.put("which","Have you tried running the app on your phone?");
        replies.put("whom","I just checked StackOverflow - they don't know either.");
        replies.put("cheese","Yummy.");
        replies.put("monkey","They throw darts.");
        replies.put("joke","Why did the chicken cross the road? To get to the other side.");
    }
}