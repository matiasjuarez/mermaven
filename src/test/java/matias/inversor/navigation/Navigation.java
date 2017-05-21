package matias.inversor.navigation;

import navigation.santander.SantanderNavigation;
import org.junit.Test;

/**
 * Created by matias on 21/05/17.
 */
public class Navigation {

    @Test
    public void testNavigation(){
        SantanderNavigation santanderNavigation = new SantanderNavigation();
        santanderNavigation.operate();
    }
}
