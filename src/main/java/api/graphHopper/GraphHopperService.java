package api.graphHopper;



import java.util.List;

/**
 * @author mayun8
 *
 */
public interface GraphHopperService {

    List<Object> buildRoute(Double sLat, Double sLon, Double fLat, Double fLon);
}
