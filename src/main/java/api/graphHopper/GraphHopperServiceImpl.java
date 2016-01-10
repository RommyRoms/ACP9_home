/*
package api.graphHopper;

import model.Point;
import model.Route;
import model.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

*/
/**
 *  @author mayun8
 *  Realization of the graphhoppers.com api
 *  Get the route from the graphhoppers.com rest serrver api with the Apache HttpClient library
 * and put all the wariants of route into the list.
 *  Makind request from the Apache HttpClient realized by utils.HttpClientUtils class;
 *  Text reading from server response to String realized by org.apache.commons.io.IOUtils;
 *  web-service: REST
 *  parser: JSonParser from org.json.simple.parser.JSONParser;
 *//*


@Service
@PropertySource(value = "classpath:prop/graphhopper.properties")
public class GraphHopperServiceImpl implements GraphHopperService{
    public static final String TURN_SHARP_LEFT = "Turn sharp left";
    public static final String TURN_LEFT = "Turn left";
    public static final String TURN_SLIGHT_LEFT = "Turn slight left";
    public static final String CONTINUE_ON_STREET = "continue on street";
    public static final String TURN_SLIGHT_RIGHT = "Turn slight right";
    public static final String TURN_RIGHT = "Turn right";
    public static final String TURN_SHARP_RIGHT = "Turn sharp right";
    public static final String FINISH = "Finish";
    public static final String VIA_REACHED = "Via reached";
    public static final String USE_ROUNDABOUT = "Use round about";

    @Autowired
    private Environment environment;

    @Autowired
    private JSONParser jsonParser;



    @Override
    public  List<Route> buildRoute(Double sLat, Double sLon, Double fLat, Double fLon){

        List<Route> routes = new ArrayList<>();

        try {

            String jsonStringFromUrl = buildURLforGraphHopper(sLat,sLon,fLat,fLon);

            //create new Route
            Route route = new Route();

            //make instance of new parser
            JSONParser jsonParser = new JSONParser();
            JSONObject root = (JSONObject) jsonParser.parse(jsonStringFromUrl);

            //get full json
            JSONArray paths = (JSONArray)root.get("paths");

            //get the overall distance of the route, in meter  paths[0].distance -api
            JSONObject pathsJson = (JSONObject) paths.get(0);
            Double dist = (Double)pathsJson.get("distance"); //TODO:Double!!!
//            if (dist!=null) route.setDistance(dist);

            //points of Route
            List<Point> points = new LinkedList<>();

            //get coordinates to all points of route. Coordinates from arr = [lon,lat]
            JSONObject jsonPoints = (JSONObject)pathsJson.get("points");
            JSONArray pointsArrJson = (JSONArray)jsonPoints.get("coordinates");
            if (pointsArrJson!=null){
                pointsArrJson.stream().forEach(element -> {
                    JSONArray array = (JSONArray)element;
                    Double lon = (Double)array.get(0);
                    Double lat = (Double)array.get(1);
                    points.add(new Point(lon,lat));
                });
            }

            //get full route time  from api: paths[0].instructions[0].time
            Long time = (Long)pathsJson.get("time");
            if (time!=null) route.setDuration(time);

            //make steps for the points of route
            JSONArray instructions = (JSONArray)pathsJson.get("instructions");
            if (instructions!=null){
                for (int i = 0; i < instructions.size(); i++) {

                    JSONObject iterateInstruction =  (JSONObject) instructions.get(i);

                    //make new step
                    Step step = new Step();

                    //get step distance
//                  TODO: make Double distance
//                  Double x = (Double)iterateInstruction.get("distance");
//                  if (x!=null) step.setDistance(Long.parseLong(x.toString()));

                    //get step instructions
                    String instruction = (String) iterateInstruction.get("text");
                    if (instruction!=null) step.setInstruction(instruction);

                    //get step duration
                    Long stepTime = (Long) iterateInstruction.get("time");
                    if (stepTime!=null)step.setDuration(stepTime);

                    //get info from special api annotated info as the instruction
                    String anotationText = (String) iterateInstruction.get("annotation_text");
                    if (anotationText!=null)step.setInstruction(anotationText);

//                  TODO: set signs for anywhere
//                  System.out.println(iterateInstruction.get("sign"));

                    //get intervals of points to set all the parameters to them
                    JSONArray intervalArray = (JSONArray) iterateInstruction.get("interval");
                    Long index = (Long)intervalArray.get(0);

                    Long lastIndex = (Long)intervalArray.get(1);
                    for (int j= index.intValue(); j < lastIndex.intValue(); j++) {
                        Point point = points.get(j);
                        point.setStep(step);

                    }
                }
            }
            route.setPoints(points);
            routes.add(route);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return routes;
    }


    */
/**
     * @param sLat x coordinate of first point;
     * @param sLon y coordinate of first point;
     * @param fLat x coordinate of second point;
     * @param fLon y coordinate of second point;
     * @return url for request
     *//*

    private String buildURLforGraphHopper(Double sLat, Double sLon, Double fLat, Double fLon) {
        StringBuilder builder = new StringBuilder();
        builder.append(environment.getProperty("url"));
        builder.append("?point=").append(cutedToFourNumbersAfterPointDouble(sLat));
        builder.append("%2C").append(cutedToFourNumbersAfterPointDouble(sLon));
        builder.append("&point=").append(cutedToFourNumbersAfterPointDouble(fLat));
        builder.append("%2C").append(cutedToFourNumbersAfterPointDouble(fLon));
        builder.append("&vehicle=").append(environment.getProperty("vehicle"));
        builder.append("&locale=").append(environment.getProperty("locale"));
        builder.append("&debug=").append(environment.getProperty("debug"));
        builder.append("&points_encoded=").append(environment.getProperty("points_encoded"));
        builder.append("&key=").append(environment.getProperty("key"));

        return builder.toString();
    }

    */
/**
     *   Cutting the double to a valid view for url request
     *   returnValueSize - double value size to return
     *   @param num - double param with many numbers after point;
     *   @return double value with fixed tail after point
     *//*

    private double cutedToFourNumbersAfterPointDouble(Double num){
        int returnValueSize = 9;
        return Double.parseDouble(num.toString().substring(0,returnValueSize));
    }

    */
/**
     * @param arg - sign value from api, that says what to do to driver at the point
     * @return message for the advising driver at the point
     *//*

    private String signTranslator(int arg){
        String result = null;
        switch (arg) {
            case -3: result= TURN_SHARP_LEFT;
                break;
            case -2: result= TURN_LEFT;
                break;
            case -1: result= TURN_SLIGHT_LEFT;
                break;
            case 0: result= CONTINUE_ON_STREET;
                break;
            case 1: result= TURN_SLIGHT_RIGHT;
                break;
            case 2: result=TURN_RIGHT;
                break;
            case 3: result=TURN_SHARP_RIGHT;
                break;
            case 4: result=FINISH;
                break;
            case 5: result=VIA_REACHED;
                break;
            case 6: result=USE_ROUNDABOUT;
                break;
        }
        return result;
    }



}

*/
