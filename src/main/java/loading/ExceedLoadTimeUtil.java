package loading;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeoutException;
/**
 * This utility class will check if the load time of an element exceeds 20seconds.
 * (The time can be edited depending on the requirements)
 */
@Slf4j
public class ExceedLoadTimeUtil {

    public static void exceedExpectedLoadTime(long totalTime) throws TimeoutException {
        if (totalTime < 20000) {
            log.info("Loading of this part is properly handled.");
        } else {
            log.error("The loading of this part needs improvement! Exceeds 20s"); //change, depending on requirements (Ex. 3seconds is the ideally loading)
            throw new TimeoutException();
        }
    }
}
