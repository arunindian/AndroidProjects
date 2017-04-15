package web.org.examples;


import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestExample {
    public static void main(String[] args) {
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("8zKFLwF1TMTQkL5XmiF7gXqBj")
                    .setOAuthConsumerSecret("3fZDeD7FrccYK8ui3MHy3AzG28eSGUgXSOvMPxJ6FMyXYLPaF3")
                    .setOAuthAccessToken("932012203-1V0c4KsGEz3HFdbvUeIpCCMQLfI05ZE9jrSks2H9")
                    .setOAuthAccessTokenSecret("HJnSXD5C4udNCtApwlleqaQushTBicJqrqMnumMuiAygP");
            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();
            System.out.println("Showing available trends");
            for (Location location : locations) {
                System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
            }
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            System.exit(-1);
        }
    }
}
