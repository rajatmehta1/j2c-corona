package com.tekshila.controllers;

import com.tekshila.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/v1/cd")
@Slf4j
public class MedicalDeviceController {

    private final String srchString = "-\"not verified\" -\"unverified\" -\"needed\" -\"need\" -\"needs\" -\"required\" -\"require\" -\"requires\" -\"requirement\" -\"requirements\"";
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MedicalDeviceController.class);
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/{city_name}/devices",method = RequestMethod.GET)
    public String showMedicines(@PathVariable(name = "city_name", required = true) String cityName,Model model) {
        model.addAttribute("medCity","Medical Devices in " + cityName);
        model.addAttribute("cityName",cityName);
        return "medical_devices";
    }

    @RequestMapping(value = "/{city_name}/devices/{med_name}",method = RequestMethod.GET)
    public String getMedicines(@PathVariable(name = "city_name", required = true) String cityName,
                               @PathVariable(name = "med_name", required = true) String medName,
                               Model model) throws TwitterException  {
        String srchText = "verified " + cityName +
                          " (" + medName.replaceAll("-"," ") + ") " + srchString
                          + " exclude:retweets";
//            logger.info("Srch Text ==> " + srchText);
        Twitter twitter = getTwitterinstance();
        //  Query query = new Query("#Bangalore hospital bed");
        Query query = new Query(srchText);
       // query.setCount(20);
        query.setSince(
                format.format(yesterday())
                      );
        query.setResultType(Query.RECENT);
        QueryResult result = twitter.search(query);
        List<Tweet> tweets = new ArrayList<>();
        List<Status> tweetsRst = new ArrayList<>();
        tweetsRst = result.getTweets();
        for (Status t : tweetsRst) {
            Tweet twt = new Tweet();
//            if(null != t.getRetweetedStatus()) {
//                twt.setText(t.getRetweetedStatus().getText());
//            } else {
//            logger.info("Tweet ==> " + t.getText() + " <==");
            //String withoutHashTweet = t.getText().replaceAll("[#]", "");
                twt.setText(parse(t.getText()) + "\n\n");
//            }
            tweets.add(twt);
        }
            model.addAttribute("tweets", tweets);
            if(medName.contains("test")) {
                model.addAttribute("medCity","Covid Tests" + " in " + cityName);
            } else {
                model.addAttribute("medCity",medName + " in " + cityName);
            }
            model.addAttribute("medName",medName);
            model.addAttribute("cityName",cityName);

        return "medical_device_city";
    }

    public Twitter getTwitterinstance() {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }



    public String parse(String tweetText) {

// Search for URLs
        if (tweetText.contains("http:")) {
            int indexOfHttp = tweetText.indexOf("http:");
            int endPoint = (tweetText.indexOf(" ", indexOfHttp) != -1) ? tweetText.indexOf(" ", indexOfHttp) : tweetText.length();
            String url = tweetText.substring(indexOfHttp, endPoint);
            String targetUrlHtml= "<a href=’${url}’ target=’_blank’>${url}</a>";
            tweetText = tweetText.replace(url,targetUrlHtml );
        }

        String patternStr = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(tweetText);
        String result = "";

// Search for Hashtags
        while (matcher.find()) {
            result = matcher.group();
            result = result.replace(" ", "");
            String search = result.replace("#", "");
            String searchHTML="<a href=\"https://twitter.com/search?q=" + search + "\">" + result + "</a>";
            tweetText = tweetText.replace(result,searchHTML);
        }

// Search for Users
        patternStr = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)";
        pattern = Pattern.compile(patternStr);
        matcher = pattern.matcher(tweetText);
        while (matcher.find()) {
            result = matcher.group();
            result = result.replace(" ", "");
            String rawName = result.replace("@", "");
            String userHTML="<a href=\"https://twitter.com/${rawName}\">" + result + "</a>";
            tweetText = tweetText.replace(result,userHTML);
        }
        return tweetText;
    }
}
