package com.tekshila.controllers;

import com.tekshila.Tweet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cd")
public class DashboardController {

//    @Autowired
//    @Qualifier("twitterInstance")
//    private Twitter twitter;


    @RequestMapping(value = "/search",produces = "application/json")
    public List<Tweet> searchtweets() throws TwitterException {

        Twitter twitter = getTwitterinstance();
      //  Query query = new Query("#Bangalore hospital bed");
        Query query = new Query("verified MUMBAI (bed OR beds OR icu OR oxygen OR ventilator OR ventilators) -\"not verified\" -\"unverified\" -\"needed\" -\"need\" -\"needs\" -\"required\" -\"require\" -\"requires\" -\"requirement\" -\"requirements\"");
        query.setCount(5);
        QueryResult result = twitter.search(query);

        return result.getTweets().stream()
                .map(item -> {
//                    MediaEntity[] m = item.getMediaEntities();
                    Tweet t = new Tweet();
                       t.setText(item.getText());
                       t.setDatePosted(item.getCreatedAt().toString());
                     //  t.setSource(item.toString());
//                       if(null != m) t.setSource(m[0].getMediaURL());
                       return t;
                })
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/search/loc",produces = "application/json")
    public List<Tweet> searchtweetsByLocation() throws TwitterException {

        Twitter twitter = getTwitterinstance();
        double latitude = 12.957980;
        double longitude = 77.401207;
        Query q = new Query("hospital bed");
        q.setGeoCode(new GeoLocation(latitude, longitude), 30, "km");
        q.setCount(5);
        QueryResult result = twitter.search(q);

        return result.getTweets().stream()
                .map(item -> {
//                    MediaEntity[] m = item.getMediaEntities();
                    Tweet t = new Tweet();
                    t.setText(item.getText());
                    t.setDatePosted(item.getCreatedAt().toString());
                    //  t.setSource(item.toString());
//                       if(null != m) t.setSource(m[0].getMediaURL());
                    return t;
                })
                .collect(Collectors.toList());
    }


    public Twitter getTwitterinstance() {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }

}
